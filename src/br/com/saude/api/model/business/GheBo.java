package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.GheBuilder;
import br.com.saude.api.model.creation.builder.example.GheExampleBuilder;
import br.com.saude.api.model.entity.filter.GheFilter;
import br.com.saude.api.model.entity.po.Ghe;
import br.com.saude.api.model.persistence.GheDao;

public class GheBo extends GenericBo<Ghe, GheFilter, GheDao, GheBuilder, 
	GheExampleBuilder> {

	private static GheBo instance;
	
	private GheBo() {
		super();
	}
	
	public static GheBo getInstance() {
		if(instance == null)
			instance = new GheBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Ghe> getList(GheFilter filter) throws Exception {
		return super.getOrderedList(filter,"codigo");
	}
	
	@Override
	public Ghe save(Ghe ghe) throws Exception {
		
		if(ghe.getId() == 0) {
			ghe.setDataCriacao(Helper.getToday());
		}
		
		return super.save(ghe);
	}
}
