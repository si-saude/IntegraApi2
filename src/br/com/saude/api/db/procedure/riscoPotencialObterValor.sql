CREATE OR REPLACE FUNCTION riscoPotencialObterValor(bigint)
  RETURNS double precision AS
$BODY$
DECLARE
	_riscoPotencialId bigint := $1;
      
   _idade integer := (select date_part('year', age(to_timestamp(p.dataNascimento/1000)))::integer
   					from pessoa p
   					inner join empregado e on p.id = e.pessoa_id
   					inner join riscopotencial rp on rp.empregado_id = e.id
   					where rp.id = _riscoPotencialId);
   					
   _valor double precision := (select sum(r.valor) from riscoempregado r
					    where r.risco_id = _riscoPotencialId
					      and r.status = 'REALIZADO');
   _peso double precision := 4.0;
   _qtd integer := (select count(r.id) from riscoempregado r
					    where r.risco_id = _riscoPotencialId
					      and r.status = 'REALIZADO') + 1;
  _valorRisco double precision := 0.0;
BEGIN

	IF _idade >= 60 THEN
		_peso := 0.0;
	ELSEIF _idade >= 50 THEN
		_peso := 1.0;
	ELSEIF _idade >= 40 THEN
		_peso := 2.0;
	ELSEIF _idade >= 30 THEN
		_peso := 3.0;
	END IF;
	
	IF _peso >= 0 THEN
		_valorRisco := 0.95 - (_peso/3.3);
		_valorRisco := _valorRisco + (log(1.0) / (_qtd + _qtd + 1.0));
		_valorRisco := (_valor + _valorRisco) / (_qtd + 0.0);
	ELSE
		_valorRisco := _valor / (_qtd - 1.0);
	END IF;
	
    return _valorRisco;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;