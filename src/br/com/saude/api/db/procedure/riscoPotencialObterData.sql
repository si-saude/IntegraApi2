CREATE OR REPLACE FUNCTION riscoPotencialObterData(bigint)
  RETURNS bigint AS
$BODY$
DECLARE
	_riscoPotencialId bigint := $1;
      
   _data bigint;
BEGIN

	_data := (select data from riscoempregado 
				where risco_id = _riscoPotencialId
				  and status = 'REALIZADO'
				order by data desc limit 1);
	
    return _data;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;