package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.CriterioBuilder;
import br.com.saude.api.model.creation.builder.example.CriterioExampleBuilder;
import br.com.saude.api.model.entity.filter.CriterioFilter;
import br.com.saude.api.model.entity.po.Criterio;
import br.com.saude.api.model.persistence.CriterioDao;

public class CriterioBo extends GenericBo<Criterio, CriterioFilter, CriterioDao, CriterioBuilder, 
	CriterioExampleBuilder> {

	private static CriterioBo instance;
	
	private CriterioBo() {
		super();
	}
	
	public static CriterioBo getInstance() {
		if(instance == null)
			instance = new CriterioBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Criterio> getList(CriterioFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
}
