CREATE OR REPLACE FUNCTION tarefaAtualizarPendencias()
  RETURNS void AS
$BODY$
DECLARE
    _today bigint := (EXTRACT(EPOCH FROM date_trunc('day', now())) * 1000)::bigint;
BEGIN
	
	UPDATE tarefa
	SET status = 'PENDENTE'
	WHERE status = 'ABERTA'
	  and inicio < _today;
	
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
