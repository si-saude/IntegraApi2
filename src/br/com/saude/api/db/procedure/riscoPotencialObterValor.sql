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
   _peso integer := 4;
   _qtd integer := (select count(r.id) from riscoempregado r
					    where r.risco_id = _riscoPotencialId
					      and r.status = 'REALIZADO');
BEGIN

	IF _idade >= 60 THEN
		_peso := 0;
	ELSEIF _idade >= 50 THEN
		_peso := 1;
	ELSEIF _idade >= 40 THEN
		_peso := 2;
	ELSEIF _idade >= 30 THEN
		_peso := 3;
	END IF;
	
    return ((0.95 - (_peso / 3.3)) + _valor) / _qtd;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;