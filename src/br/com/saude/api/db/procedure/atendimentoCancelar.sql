CREATE OR REPLACE FUNCTION atendimentoCancelar(bigint,text,text)
  RETURNS bigint AS
$BODY$
DECLARE
    atendimento CURSOR for
    select * from atendimento where id = $1;
    
    _now bigint := (EXTRACT(EPOCH FROM date_trunc('minute', now())) * 1000)::bigint;
    _today bigint := (EXTRACT(EPOCH FROM date_trunc('day', now())) * 1000)::bigint;
BEGIN

    for _atendimento in atendimento loop

        UPDATE filaatendimento
        SET status = $2,
        version = version + 1
        where id = _atendimento.fila_id;

        UPDATE checkin
        SET status = $3,
        version = version + 1,
        atualizacao = chegada
        WHERE id = _atendimento.checkin_id;

        UPDATE tarefa
        SET responsavel_id = null,
		atualizacao = _now,
		inicio = _today,
		status = 'PENDENTE',
		version = version + 1
        WHERE id = _atendimento.tarefa_id;

        DELETE FROM triagem where atendimento_id = _atendimento.id; 
        
        DELETE FROM atendimento WHERE id = _atendimento.id;
        
    end loop;
	return 1;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;