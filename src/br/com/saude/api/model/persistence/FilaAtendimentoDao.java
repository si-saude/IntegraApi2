package br.com.saude.api.model.persistence;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.FilaAtendimento;

public class FilaAtendimentoDao extends GenericDao<FilaAtendimento> {

	private static FilaAtendimentoDao instance;
	
	private FilaAtendimentoDao() {
		super();
	}
	
	public static FilaAtendimentoDao getInstance() {
		if(instance == null)
			instance = new FilaAtendimentoDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
}
