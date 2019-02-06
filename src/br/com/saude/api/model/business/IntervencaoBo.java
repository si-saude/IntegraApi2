package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.IntervencaoBuilder;
import br.com.saude.api.model.creation.builder.example.IntervencaoExampleBuilder;
import br.com.saude.api.model.entity.filter.IntervencaoFilter;
import br.com.saude.api.model.entity.po.Intervencao;
import br.com.saude.api.model.persistence.IntervencaoDao;

public class IntervencaoBo extends GenericBo<Intervencao, IntervencaoFilter, IntervencaoDao, IntervencaoBuilder, 
	IntervencaoExampleBuilder> {

	private static IntervencaoBo instance;
	
	private IntervencaoBo() {
		super();
	}
	
	public static IntervencaoBo getInstance() {
		if(instance == null)
			instance = new IntervencaoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Intervencao> getList(IntervencaoFilter filter) throws Exception {
		return super.getOrderedList(filter,"descricao");
	}
}
