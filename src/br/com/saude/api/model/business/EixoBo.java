package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.EixoBuilder;
import br.com.saude.api.model.creation.builder.example.EixoExampleBuilder;
import br.com.saude.api.model.entity.filter.EixoFilter;
import br.com.saude.api.model.entity.po.Eixo;
import br.com.saude.api.model.persistence.EixoDao;

public class EixoBo extends GenericBo<Eixo, EixoFilter, EixoDao, EixoBuilder, 
	EixoExampleBuilder> {

	private static EixoBo instance;
	
	private EixoBo() {
		super();
	}
	
	public static EixoBo getInstance() {
		if(instance == null)
			instance = new EixoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Eixo> getList(EixoFilter filter) throws Exception {
		return super.getOrderedList(filter,"titulo");
	}
}
