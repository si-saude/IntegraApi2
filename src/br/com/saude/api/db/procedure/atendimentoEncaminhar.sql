CREATE OR REPLACE FUNCTION atendimentoEncaminhar(bigint,bigint,bigint,bigint)
  RETURNS bigint AS
$BODY$
DECLARE
    
    _checkinId bigint := $1;
    _tarefaId bigint := $2;
    _filaId bigint := $3;
    _now bigint := $4;
    _atendimentoId bigint;
    _profissionalId bigint;
    _equipeId bigint;
    _acolhimento boolean := false;
    
    indicadores REFCURSOR;
    _indicador RECORD;
BEGIN

    _atendimentoId := (select nextval('atendimento_id_seq'));
    _profissionalId := (select profissional_id from filaatendimento where id = _filaId);
    _equipeId := (select equipe_id from tarefa where id = _tarefaId);
    
    IF (select acolhimento_id from parametro limit 1) = _equipeId THEN
    	_acolhimento := true;
    END IF;
    
    INSERT INTO atendimento(id,version,checkin_id,fila_id,tarefa_id,acolhimento)
	VALUES (_atendimentoId,0,_checkinId,_filaId,_tarefaId,_acolhimento);
	
	UPDATE tarefa
	SET atualizacao = _now,
		inicio = _now,
		status = 'EXECUÇÃO',
		version = version + 1,
		responsavel_id = _profissionalId
	WHERE id = _tarefaId;
	
	UPDATE filaatendimento
	SET status = 'AGUARDANDO EMPREGADO',
		version = version + 1
	WHERE id = _filaId;
	
	UPDATE checkin
	SET atualizacao = _now,
		status = 'EM ATENDIMENTO',
		version = version + 1
	WHERE id = _checkinId;
	
	--CRIAR FICHA DE TRIAGEM
	OPEN indicadores FOR
	select id
	from indicadorsast i
	where i.inativo = false
	  and i.equipe_id = _equipeId
	order by i.codigo;
	loop
		fetch next FROM indicadores into _indicador;
		exit when _indicador is null;
			 
		INSERT INTO triagem (id, indicador_id, atendimento_id, indice, version)
		VALUES (nextval('triagem_id_seq'), _indicador.id, _atendimentoId, -1, 0);
	end loop;
	close indicadores;
	
    
	return 1;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;