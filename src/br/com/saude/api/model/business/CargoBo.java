package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.CargoBuilder;
import br.com.saude.api.model.creation.builder.example.CargoExampleBuilder;
import br.com.saude.api.model.entity.filter.CargoFilter;
import br.com.saude.api.model.entity.po.Cargo;
import br.com.saude.api.model.persistence.CargoDao;

public class CargoBo extends GenericBo<Cargo, CargoFilter, CargoDao, CargoBuilder, 
	CargoExampleBuilder> {

	private static CargoBo instance;
	
	private CargoBo() {
		super();
	}
	
	public static CargoBo getInstance() {
		if(instance == null)
			instance = new CargoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadCursos();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	@Override
	public PagedList<Cargo> getList(CargoFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
	
	@Override
	public Cargo getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
