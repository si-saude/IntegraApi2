CREATE OR REPLACE FUNCTION atendimentoLiberar(bigint,bigint)
  RETURNS bigint AS
$BODY$
DECLARE
    atendimento CURSOR for
    select * from atendimento where id = $1;
    
    _now bigint := $2;
BEGIN

    for _atendimento in atendimento loop
    
    	UPDATE tarefa
        SET atualizacao = _now,
		version = version + 1
        WHERE id = _atendimento.tarefa_id;

        UPDATE filaatendimento
        SET status = 'LANÇAMENTO DE INFORMAÇÕES',
        version = version + 1
        where id = _atendimento.fila_id;
        
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
        
    end loop;
	return 1;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;