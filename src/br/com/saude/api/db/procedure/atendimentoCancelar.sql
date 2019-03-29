CREATE OR REPLACE FUNCTION atendimentoCancelar(bigint,text,text,bigint)
  RETURNS bigint AS
$BODY$
DECLARE
    atendimento CURSOR for
    select a.*, c.status as status_checkin 
    from atendimento a
    inner join checkin c on a.checkin_id = c.id
    where a.id = $1;
    
    _now bigint := $4;
    _today bigint := (EXTRACT(EPOCH FROM date_trunc('day', to_timestamp(_now/1000) )) * 1000)::bigint;
    _statusCheckin text := $3;
BEGIN

    for _atendimento in atendimento loop

        UPDATE filaatendimento
        SET status = $2,
        version = version + 1
        where id = _atendimento.fila_id;
        
        IF _atendimento.status_checkin = 'AUSENTE' THEN
        	_statusCheckin = _atendimento.status_checkin; 
        END IF;

        UPDATE checkin
        SET status = _statusCheckin,
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