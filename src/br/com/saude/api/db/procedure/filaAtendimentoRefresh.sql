CREATE OR REPLACE FUNCTION filaAtendimentoRefresh()
  RETURNS bigint AS
$BODY$
DECLARE
    localizacoes CURSOR for
    select id,nome from localizacao;

    regras REFCURSOR;
    _regra RECORD;

    checkins REFCURSOR;
    _checkin RECORD;

    dependencias REFCURSOR;
    _dependencia RECORD;

    filas REFCURSOR;
    _fila RECORD;
	
	indicadores REFCURSOR;
    _indicador RECORD;

    _tarefaId bigint;
	_atendimentoId bigint;
	_now bigint;
BEGIN

    for _localizacao in localizacoes loop
        OPEN checkins FOR
        select c.*, s.regraatendimento_id 
        from checkin c
        inner join servico s on s.id = c.servico_id
        where c.localizacao_id = _localizacao.id
          and date_trunc('day', to_timestamp(c.chegada/1000.0)) = date_trunc('day', now())
          and c.status = 'AGUARDANDO'
        order by c.atualizacao;
	<<checkin_loop>>
        loop 
            fetch next FROM checkins into _checkin;
            exit when _checkin is null;
            
            OPEN regras FOR
            select id,acolhimento,equipe_id
	    from regraatendimentoequipe
            where regraatendimento_id = _checkin.regraatendimento_id
            order by ordem;
            <<regra_loop>>
            loop
		fetch next FROM regras into _regra;
		exit when _regra is null;
		
                _tarefaId := (select cf.tarefa_id
                    from checkin_tarefa cf
                    inner join tarefa t on cf.tarefa_id = t.id
                    where cf.checkin_id = _checkin.id
                      and t.equipe_id = _regra.equipe_id
		      and t.status in ('ABERTA','PENDENTE')
                    limit 1);

                IF _tarefaId > 0 THEN

                    OPEN dependencias FOR
                    select equipe_id
                    from dependencia
                    where regraatendimentoequipe_id = _regra.id;
                    loop
                        fetch next FROM dependencias into _dependencia;
                        exit when _dependencia is null;
						
			IF EXISTS (select 1
				from checkin_tarefa cf
				inner join tarefa t on cf.tarefa_id = t.id
				where cf.checkin_id = _checkin.id
				  and t.equipe_id = _dependencia.equipe_id
				  and t.status in ('ABERTA','PENDENTE','CONFIRMADA'))
			THEN
				close dependencias;
				CONTINUE regra_loop;
			END IF;                    
		    end loop;
		    close dependencias;

			OPEN filas FOR
			select id,profissional_id
			from filaatendimento f
			where date_trunc('day', to_timestamp(f.data/1000.0)) = date_trunc('day', now())
				and status = 'DISPON�VEL'
				and localizacao_id = _localizacao.id
				and exists (select 1 
					from profissional_equipe pe
					where f.profissional_id = pe.profissional_id
					and _regra.equipe_id = pe.equipe_id)
				and exists (select 1 
					from servico_profissional sp
					where f.profissional_id = sp.profissional_id
					and _checkin.servico_id = sp.servico_id);
			    loop
				fetch next FROM filas into _fila;
				exit when _fila is null;
				
				_atendimentoId := (select nextval('atendimento_id_seq'));
				_now := (EXTRACT(EPOCH FROM date_trunc('second', now())) * 1000)::bigint;

				INSERT INTO atendimento(id,version,checkin_id,fila_id,tarefa_id,acolhimento)
				VALUES (_atendimentoId,0,_checkin.id,_fila.id,_tarefaId,_regra.acolhimento);

				UPDATE tarefa
				SET atualizacao = _now,
					inicio = _now,
					status = 'EXECU��O',
					version = version + 1,
					responsavel_id = _fila.profissional_id
				WHERE id = _tarefaId;

				UPDATE filaatendimento
				SET status = 'AGUARDANDO EMPREGADO',
					version = version + 1
				WHERE id = _fila.id;

				UPDATE checkin
				SET atualizacao = _now,
					status = 'EM ATENDIMENTO',
					version = version + 1
				WHERE id = _checkin.id;

				--CRIAR FICHA DE TRIAGEM
				OPEN indicadores FOR
				select id
				from indicadorsast i
				where i.inativo = false
				  and i.equipe_id = _regra.equipe_id
				order by i.codigo;
				loop
					fetch next FROM indicadores into _indicador;
					exit when _indicador is null;
						 
					INSERT INTO triagem (id, indicador_id, atendimento_id, indice, version)
					VALUES (nextval('triagem_id_seq'), _indicador.id, _atendimentoId, -1, 0);
				end loop;
				close indicadores;
						 
			close filas;
			close regras;
			CONTINUE checkin_loop;
			end loop;
			close filas;

                END IF;
            end loop;
            close regras;
        end loop;
        close checkins;
    end loop;
    return 1;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;