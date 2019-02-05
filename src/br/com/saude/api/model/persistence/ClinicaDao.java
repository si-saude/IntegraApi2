package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;
import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.Clinica;

public class ClinicaDao extends GenericDao<Clinica> {
	
	private static ClinicaDao instance;
	
	private ClinicaDao() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = clinica -> {
			if(clinica.getExames() != null)
				Hibernate.initialize(clinica.getExames());
			return clinica;
		};
	}
	
	public static ClinicaDao getInstance() {
		if(instance == null)
			instance = new ClinicaDao();
		return instance;
	}
	
	@Override
	public Clinica getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
