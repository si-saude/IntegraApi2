package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Exame;

public class ExameDao extends GenericDao<Exame> {

	private static ExameDao instance;
	
	private ExameDao() {
		super();
	}
	
	public static ExameDao getInstance() {
		if(instance == null)
			instance = new ExameDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = exame -> {
			if(Helper.isNotNull(exame.getCampoExames())) {
				Hibernate.initialize(exame.getCampoExames());
			}
			return exame;
		};
	}
	
	@Override
	public Exame getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
