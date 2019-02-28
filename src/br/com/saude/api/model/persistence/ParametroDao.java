package br.com.saude.api.model.persistence;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.Parametro;

public class ParametroDao extends GenericDao<Parametro> {

	private static ParametroDao instance;
	
	private ParametroDao() {
		super();
	}
	
	public static ParametroDao getInstance() {
		if(instance == null)
			instance = new ParametroDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {

	}
}
