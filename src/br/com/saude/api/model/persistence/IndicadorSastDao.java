package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;
import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.IndicadorSast;

public class IndicadorSastDao extends GenericDao<IndicadorSast> {
	
	private static IndicadorSastDao instance;
	
	private IndicadorSastDao() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = indicador -> {
			if(indicador.getEquipe() != null)
				Hibernate.initialize(indicador.getEquipe());
			
			if(Helper.isNotNull(indicador.getIndicadorAssociadoSasts()))
				Hibernate.initialize(indicador.getIndicadorAssociadoSasts());
			return indicador;
		};
	}
	
	public static IndicadorSastDao getInstance() {
		if(instance == null)
			instance = new IndicadorSastDao();
		return instance;
	}
	
	@Override
	public IndicadorSast getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
