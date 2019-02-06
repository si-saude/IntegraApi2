package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.IndicadorSastBuilder;
import br.com.saude.api.model.creation.builder.example.IndicadorSastExampleBuilder;
import br.com.saude.api.model.entity.filter.IndicadorSastFilter;
import br.com.saude.api.model.entity.po.IndicadorSast;
import br.com.saude.api.model.persistence.IndicadorSastDao;

public class IndicadorSastBo extends GenericBo<IndicadorSast, IndicadorSastFilter, IndicadorSastDao, IndicadorSastBuilder, 
	IndicadorSastExampleBuilder> {

	private static IndicadorSastBo instance;
	
	private IndicadorSastBo() {
		super();
	}
	
	public static IndicadorSastBo getInstance() {
		if(instance == null)
			instance = new IndicadorSastBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadEquipe().loadIndicadores();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	@Override
	public PagedList<IndicadorSast> getList(IndicadorSastFilter filter) throws Exception {
		return super.getOrderedList(filter,"codigo");
	}
	
	@Override
	public IndicadorSast getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
