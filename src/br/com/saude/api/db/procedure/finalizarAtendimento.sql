CREATE OR REPLACE FUNCTION finalizarAtendimento(bigint,text)
  RETURNS void AS
$BODY$
DECLARE
    atendimento CURSOR for
    select * from atendimento where id = $1;
    
    _now bigint := (EXTRACT(EPOCH FROM date_trunc('minute', now())) * 1000)::bigint;
BEGIN

    for _atendimento in atendimento loop
    
    	UPDATE tarefa
        SET atualizacao = _now,
        fim = _now,
		status = 'CONCLU�DA',
		version = version + 1
        WHERE id = _atendimento.tarefa_id;
        
        IF not exists (select 1
        				from filaatendimento
        				where id = _atendimento.fila_id
        				  and status = 'LAN�AMENTO DE INFORMA��ES') THEN

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
		        END IF;
	    END IF;
        
        UPDATE filaatendimento
        SET status = $2,
        version = version + 1
        where id = _atendimento.fila_id;
        
    end loop;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;