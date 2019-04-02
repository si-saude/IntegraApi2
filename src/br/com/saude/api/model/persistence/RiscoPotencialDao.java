package br.com.saude.api.model.persistence;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.RiscoPotencial;

public class RiscoPotencialDao extends GenericDao<RiscoPotencial> {

	private static RiscoPotencialDao instance;
	
	private RiscoPotencialDao() {
		super();
	}
	
	public static RiscoPotencialDao getInstance() {
		if(instance == null)
			instance = new RiscoPotencialDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
}
