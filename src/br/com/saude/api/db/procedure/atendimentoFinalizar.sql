CREATE OR REPLACE FUNCTION atendimentoFinalizar(bigint,text,bigint)
  RETURNS bigint AS
$BODY$
DECLARE
    atendimento CURSOR for
    select * from atendimento where id = $1;
    
    _now bigint := $3;
    _rtn bigint;
BEGIN

    for _atendimento in atendimento loop
    
    	UPDATE tarefa
        SET atualizacao = _now,
        fim = _now,
		status = 'CONCLUÍDA'
        WHERE id = _atendimento.tarefa_id;
        
        IF not exists (select 1
        				from filaatendimento
        				where id = _atendimento.fila_id
        				  and status = 'LANÇAMENTO DE INFORMAÇÕES') THEN

		        IF exists (select 1 
		        			from checkin_tarefa ct
		        			inner join tarefa t on ct.tarefa_id = t.id
		        			where ct.checkin_id = _atendimento.checkin_id
		        			  and t.status in ('PENDENTE','ABERTA')) THEN
		        		UPDATE checkin
				        SET status = 'AGUARDANDO',
				        version = version + 1
				        WHERE id = _atendimento.checkin_id;  
		        ELSE
		        		UPDATE checkin
				        SET status = 'FINALIZADO',
				        version = version + 1
				        WHERE id = _atendimento.checkin_id;
				        
				        --CRIAR AVALIAÇÃO DE ATENDIMENTO
						INSERT INTO avaliacaoatendimento(id, status, version, checkin_id, questionario_id)
				        VALUES(nextval('avaliacaoatendimento_id_seq'), 'PENDENTE', 0, _atendimento.checkin_id,
							  (select id from questionario where inativo = false order by id limit 1));
							  
						--GERAR/ATUALIZAR O RISCO
						_rtn := (select riscoPotencialAtualizar(_atendimento.checkin_id, _now));
		        END IF;
	    END IF;
        
        UPDATE filaatendimento
        SET status = $2,
        version = version + 1
        where id = _atendimento.fila_id;
        
    end loop;
	return 1;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;