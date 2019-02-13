package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.EnfaseBuilder;
import br.com.saude.api.model.creation.builder.example.EnfaseExampleBuilder;
import br.com.saude.api.model.entity.filter.EnfaseFilter;
import br.com.saude.api.model.entity.po.Enfase;
import br.com.saude.api.model.persistence.EnfaseDao;

public class EnfaseBo extends GenericBo<Enfase, EnfaseFilter, EnfaseDao, EnfaseBuilder, 
EnfaseExampleBuilder> {

	private static EnfaseBo instance;
	
	private EnfaseBo() {
		super();
	}
	
	public static EnfaseBo getInstance() {
		if(instance == null)
			instance = new EnfaseBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Enfase> getList(EnfaseFilter filter) throws Exception {
		return super.getOrderedList(filter,"descricao");
	}
}
