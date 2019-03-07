package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
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
		this.functionLoadAll = risco -> {
			if(Helper.isNotNull(risco.getRiscos())) {
				Hibernate.initialize(risco.getRiscos());
			}
			return risco;
		};
	}
	
	@Override
	public RiscoPotencial getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
