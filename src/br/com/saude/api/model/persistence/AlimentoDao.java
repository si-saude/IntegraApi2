package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Alimento;

public class AlimentoDao extends GenericDao<Alimento> {

	private static AlimentoDao instance;
	
	private AlimentoDao() {
		super();
	}
	
	public static AlimentoDao getInstance() {
		if(instance == null)
			instance = new AlimentoDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = alimento -> {	
			if(Helper.isNotNull(alimento.getAlimentosMedidaCaseira()))
				Hibernate.initialize(alimento.getAlimentosMedidaCaseira());
			
			if(Helper.isNotNull(alimento.getSubstituicoes()))
				Hibernate.initialize(alimento.getSubstituicoes());
			
			return alimento;
		};
	}
	
	@Override
	public Alimento getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
