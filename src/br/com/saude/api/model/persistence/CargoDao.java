package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.Cargo;

public class CargoDao extends GenericDao<Cargo> {

	private static CargoDao instance;
	
	private CargoDao() {
		super();
	}
	
	public static CargoDao getInstance() {
		if(instance == null)
			instance = new CargoDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = cargo -> {
			if(cargo.getCursos() != null)
				Hibernate.initialize(cargo.getCursos());
			
			return cargo;
		};
	}
	
	@Override
	public Cargo getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
