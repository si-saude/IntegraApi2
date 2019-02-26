package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.CheckinBuilder;
import br.com.saude.api.model.creation.builder.example.CheckinExampleBuilder;
import br.com.saude.api.model.entity.filter.CheckinFilter;
import br.com.saude.api.model.entity.po.Checkin;
import br.com.saude.api.model.persistence.CheckinDao;

public class CheckinBo extends GenericBo<Checkin, CheckinFilter, CheckinDao, CheckinBuilder, 
	CheckinExampleBuilder> {

	private static CheckinBo instance;
	
	private CheckinBo() {
		super();
	}
	
	public static CheckinBo getInstance() {
		if(instance == null)
			instance = new CheckinBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Checkin> getList(CheckinFilter filter) throws Exception {
		return super.getOrderedList(filter,"chegada");
	}
}
