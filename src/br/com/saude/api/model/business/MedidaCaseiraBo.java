package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.MedidaCaseiraBuilder;
import br.com.saude.api.model.creation.builder.example.MedidaCaseiraExampleBuilder;
import br.com.saude.api.model.entity.filter.MedidaCaseiraFilter;
import br.com.saude.api.model.entity.po.MedidaCaseira;
import br.com.saude.api.model.persistence.MedidaCaseiraDao;

public class MedidaCaseiraBo extends GenericBo<MedidaCaseira, MedidaCaseiraFilter, MedidaCaseiraDao, MedidaCaseiraBuilder, 
MedidaCaseiraExampleBuilder> {

	private static MedidaCaseiraBo instance;
	
	private MedidaCaseiraBo() {
		super();
	}
	
	public static MedidaCaseiraBo getInstance() {
		if(instance == null)
			instance = new MedidaCaseiraBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<MedidaCaseira> getList(MedidaCaseiraFilter filter) throws Exception {
		return super.getOrderedList(filter,"descricao");
	}
}
