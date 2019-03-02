CREATE OR REPLACE FUNCTION iniciarAtendimento(bigint)
  RETURNS void AS
$BODY$
DECLARE
    atendimento CURSOR for
    select * from atendimento where id = $1;
BEGIN

    for _atendimento in atendimento loop

        UPDATE filaatendimento
        SET status = 'EM ATENDIMENTO',
        version = version + 1
        where id = _atendimento.fila_id;
        
    end loop;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;