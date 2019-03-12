CREATE OR REPLACE FUNCTION respostaFichaColetaGetCodigo(bigint)
  RETURNS text AS
$BODY$
DECLARE
    _respostaId bigint := $1;
BEGIN
	IF _respostaId > 0 THEN
		return (select g.ordem || ' - ' || p.codigo
			from respostafichacoleta r
			inner join perguntafichacoleta p on r.pergunta_id = p.id
			inner join grupoperguntafichacoleta g on p.grupo_id = g.id
			where r.id = _respostaId
			limit 1);
	END IF;
	return '';
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;