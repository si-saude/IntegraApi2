CREATE OR REPLACE FUNCTION filaAtendimentoRefresh(bigint)
  RETURNS void AS
$BODY$
DECLARE
    localizacoes CURSOR for
    select id,nome from localizacao;

    regras CURSOR for
    select id,acolhimento,equipe_id
    from regraatendimentoequipe
    where regraatendimento_id = $1
    order by ordem;

    checkins REFCURSOR;
    _checkin RECORD;

    dependencias REFCURSOR;
    _dependencia RECORD;

    filas REFCURSOR;
    _fila RECORD;

    _tarefaId bigint;
	_atendimentoId bigint;
	_now bigint;
BEGIN

    for _localizacao in localizacoes loop
        OPEN checkins FOR
        select * 
        from checkin c
        where c.localizacao_id = _localizacao.id
          and date_trunc('day', to_timestamp(c.chegada/1000.0)) = date_trunc('day', now())
          and c.status = 'AGUARDANDO'
        order by c.atualizacao;
	<<checkin_loop>>
        loop 
            fetch next FROM checkins into _checkin;
            exit when _checkin is null;
            
            <<regra_loop>>
            for _regra in regras 
            loop

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
                    from regraatendimentoequipe_equipe
                    where regraatendimentoequipe_id = _regra.id;
                    loop
                        fetch next FROM dependencias into _dependencia;
                        exit when _dependencia is null;
						
			IF NOT EXISTS (select 1
				from checkin_tarefa cf
				inner join tarefa t on cf.tarefa_id = t.id
				where cf.checkin_id = _checkin.id
				  and t.equipe_id = _dependencia.equipe_id
				  and t.status = 'CONCLUÍDA') 
			  AND EXISTS (select 1 
				from checkin_tarefa cf
				inner join tarefa t on cf.tarefa_id = t.id
				where cf.checkin_id = _checkin.id
				  and t.equipe_id = _dependencia.equipe_id) 
			THEN
				close dependencias;
				CONTINUE regra_loop;
			END IF;                    
                    end loop;
                    close dependencias;

                    OPEN filas FOR
                    select id,profissional_id
                    from filaatendimento f
                    where to_timestamp(f.data/1000.0) = date_trunc('day', now())
                      and status = 'DISPONÍVEL'
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
			_now := (EXTRACT(EPOCH FROM date_trunc('second', now())::timestamp without time zone) * 1000)::bigint;
											  
			INSERT INTO atendimento(id,version,checkin_id,fila_id,tarefa_id)
			VALUES (_atendimentoId,0,_checkin.id,_fila.id,_tarefaId);
											  
			UPDATE tarefa
			SET atualizacao = _now,
				inicio = _now,
				status = 'EXECUÇÃO',
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
			close filas;
			CONTINUE checkin_loop;
                    end loop;
                    close filas;

                END IF;
            end loop;
        end loop;
        close checkins;
    end loop;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
