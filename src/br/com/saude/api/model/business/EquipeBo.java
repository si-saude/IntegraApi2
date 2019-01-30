package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.EquipeBuilder;
import br.com.saude.api.model.creation.builder.example.EquipeExampleBuilder;
import br.com.saude.api.model.entity.filter.EquipeFilter;
import br.com.saude.api.model.entity.po.Equipe;
import br.com.saude.api.model.persistence.EquipeDao;

public class EquipeBo extends GenericBo<Equipe, EquipeFilter, EquipeDao, EquipeBuilder, 
	EquipeExampleBuilder> {

	private static EquipeBo instance;
	
	private EquipeBo() {
		super();
	}
	
	public static EquipeBo getInstance() {
		if(instance == null)
			instance = new EquipeBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Equipe> getList(EquipeFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
}
