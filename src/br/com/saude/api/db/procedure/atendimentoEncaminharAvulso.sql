CREATE OR REPLACE FUNCTION atendimentoEncaminharAvulso(bigint,bigint,bigint,bigint)
  RETURNS bigint AS
$BODY$
DECLARE
    
    _checkinId bigint := $1;
    _tarefaId bigint := $2;
    _filaId bigint := $3;
    _now bigint := $4;
    _rtn bigint;
BEGIN

    _rtn := (select atendimentoEncaminhar(_checkinId,_tarefaId,_filaId,_now));
	
	UPDATE checkin
	SET status = 'AUSENTE'
	WHERE id = _checkinId;	
    
	return 1;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;