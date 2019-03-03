CREATE OR REPLACE FUNCTION atendimentoIniciar(bigint)
  RETURNS bigint AS
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
	return 1;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;