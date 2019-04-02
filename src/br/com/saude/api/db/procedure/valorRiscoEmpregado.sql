-- Function: valorriscoempregado(bigint)

-- DROP FUNCTION valorriscoempregado(bigint);

CREATE OR REPLACE FUNCTION valorriscoempregado(bigint)
  RETURNS double precision AS
$BODY$
DECLARE
	_qtdAssociacoes integer := (select count(ia.id) 
					from indicadorassociadosast ia
					inner join indicadorsast i on ia.indicadorsast_id = i.id
					where i.inativo = false);
	_valor double precision := 0.0;
	_somaIndice integer := 0;
	_qtdTriagem integer := 0;
	_critico boolean := false;
	_qtdIndice integer := 0;
	_prioridade integer := 0;
	_equipeId bigint := 0;


	_riscoEmpregadoId integer := $1;

	triagens CURSOR for
	select tr.*, e.prioridadesast, i.critico, e.id as equipeId
	from triagem tr
	inner join atendimento a on tr.atendimento_id = a.id
	inner join tarefa t on t.id = a.tarefa_id
	inner join riscopotencial rp on t.cliente_id = rp.empregado_id
	inner join riscoempregado re on re.risco_id = rp.id and re.equipe_id = t.equipe_id
	inner join indicadorsast i on i.id = tr.indicador_id
	inner join equipe e on e.id = t.equipe_id
	where re.id = _riscoEmpregadoId
	  and tr.indice >= 0
	  and i.inativo = false;
	
BEGIN

	for _triagem in triagens loop
		_somaIndice := _somaIndice + _triagem.indice;
		_qtdTriagem := _qtdTriagem + 1;
		_prioridade := _triagem.prioridadesast;
		_equipeId := _triagem.equipeId;
		
		IF _triagem.indice <= _triagem.critico THEN
			_critico := true;
		END IF;
	end loop;

	_valor := log(_prioridade + 1 + 0.00) / (_prioridade + 5);
	_valor := _valor / (_qtdTriagem + _prioridade);

	IF _critico THEN
		_valor := _valor + 0.95;
	ELSE
		_valor := _valor + (0.95 - (((_somaIndice + 0.00) / _qtdTriagem) / 4.3));
	END IF;
	

	_qtdIndice := (select count(tr.id)
			from triagem tr
			inner join atendimento a on tr.atendimento_id = a.id
			inner join tarefa t on t.id = a.tarefa_id
			inner join checkin_tarefa ct on ct.tarefa_id = t.id
			inner join indicadorsast i on tr.indicador_id = i.id
			inner join riscopotencial rp on rp.empregado_id = t.cliente_id
			inner join riscoempregado re on rp.id = re.risco_id
			where re.id = _riscoEmpregadoId
			  and tr.indice >= 0
			  and tr.indice < 3
			  and exists (select 1 
					from indicadorassociadosast ia
					inner join indicadorsast i2 on ia.indicadorsast_id = i2.id
					where ia.codigo = i.codigo
					  and i2.equipe_id = _equipeId));

	_valor := _valor + (_qtdIndice * (0.05 / _qtdAssociacoes));
	
    return _valor;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
