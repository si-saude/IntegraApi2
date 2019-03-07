package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.RiscoPotencialBuilder;
import br.com.saude.api.model.creation.builder.example.RiscoPotencialExampleBuilder;
import br.com.saude.api.model.entity.filter.RiscoPotencialFilter;
import br.com.saude.api.model.entity.po.RiscoPotencial;
import br.com.saude.api.model.persistence.RiscoPotencialDao;

public class RiscoPotencialBo extends GenericBo<RiscoPotencial, RiscoPotencialFilter, RiscoPotencialDao, RiscoPotencialBuilder, 
	RiscoPotencialExampleBuilder> {

	private static RiscoPotencialBo instance;
	
	private RiscoPotencialBo() {
		super();
	}
	
	public static RiscoPotencialBo getInstance() {
		if(instance == null)
			instance = new RiscoPotencialBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadRiscos();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	@Override
	public PagedList<RiscoPotencial> getList(RiscoPotencialFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
	
	@Override
	public RiscoPotencial getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
