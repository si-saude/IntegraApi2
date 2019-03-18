CREATE OR REPLACE FUNCTION riscoPotencialAtualizar(bigint,bigint)
  RETURNS bigint AS
$BODY$
DECLARE

    equipes CURSOR for
    select id,prioridadesast
    from equipe
    where prioridadesast > 0;

    triagens REFCURSOR;
    _triagem RECORD;

	_checkinId bigint := $1;
	_empregadoId bigint := (select empregado_id from checkin where id = _checkinId limit 1);
	_riscoPotencialId bigint := (select coalesce((select id from riscopotencial where empregado_id = _empregadoId limit 1),0));
	_riscoEmpregadoId bigint;

	_qtdEquipe integer := (select count(id) from equipe where prioridadesast > 0);
	_qtdAssociacoes integer := (select count(ia.id) 
					from indicadorassociadosast ia
					inner join indicadorsast i on ia.indicadorsast_id = i.id
					where i.inativo = false);
	_valor double precision;
	_somaIndice integer;
	_qtdTriagem integer;
	_critico boolean;
	_qtdIndice integer;
BEGIN

	IF NOT _riscoPotencialId > 0 THEN
		_riscoPotencialId := (select nextval('riscopotencial_id_seq'));

		INSERT INTO riscopotencial(id, status, version, empregado_id)
		VALUES (_riscoPotencialId, 'PLANEJAMENTO', 0, _empregadoId);
	END IF;

	UPDATE riscoempregado
	SET status = 'ENCERRADO'
	WHERE risco_id = _riscoPotencialId;
	
	for _equipe in equipes loop
		_valor := 0;
		_somaIndice := 0;
		_qtdTriagem := 0;
		_critico := false;
		_qtdIndice := 0;
		_riscoEmpregadoId := (select nextval('riscoempregado_id_seq'));

		OPEN triagens FOR
		select tr.indice, tr.atendimento_id, i.critico, i.ausentecalculointerdisciplinar
		from triagem tr
		inner join atendimento a on tr.atendimento_id = a.id
		inner join tarefa t on t.id = a.tarefa_id
		inner join checkin_tarefa ct on ct.tarefa_id = t.id
		inner join indicadorsast i on i.id = tr.indicador_id
		where ct.checkin_id = _checkinId
		  and t.equipe_id = _equipe.id
		  --and i.ausentecalculointerdisciplinar = false
		  and i.inativo = false
		  and tr.indice >= 0;
		loop 
		    fetch next FROM triagens into _triagem;
		    exit when _triagem is null;

		    _somaIndice := _somaIndice + _triagem.indice;
		    _qtdTriagem := _qtdTriagem + 1;

		    IF _triagem.indice <= _triagem.critico THEN
				_critico := true;
		    END IF;
		end loop;
		close triagens;

		_valor := log( (_equipe.prioridadesast + 1 + 0.00) / (_equipe.prioridadesast + _qtdEquipe) );
		_valor := _valor / (_qtdTriagem + _equipe.prioridadesast);

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
				where ct.checkin_id = _checkinId
				  and tr.indice >= 0
				  and tr.indice < 3
				  and exists (select 1 
						from indicadorassociadosast ia
						inner join indicadorsast i2 on ia.indicadorsast_id = i2.id
						where ia.codigo = i.codigo
						  and i2.equipe_id = _equipe.id));

		_valor := _valor + (_qtdIndice * (0.05 / _qtdAssociacoes));

		INSERT INTO riscoempregado(id, status, valor, version, risco_id, data, equipe_id)
		VALUES (_riscoEmpregadoId, 'REALIZADO', _valor, 0, _riscoPotencialId, $1, _equipe.id);
	end loop;
    return 1;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;