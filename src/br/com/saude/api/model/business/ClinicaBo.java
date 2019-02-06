package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.ClinicaBuilder;
import br.com.saude.api.model.creation.builder.example.ClinicaExampleBuilder;
import br.com.saude.api.model.entity.filter.ClinicaFilter;
import br.com.saude.api.model.entity.po.Clinica;
import br.com.saude.api.model.persistence.ClinicaDao;

public class ClinicaBo extends GenericBo<Clinica, ClinicaFilter, ClinicaDao, 
										ClinicaBuilder, ClinicaExampleBuilder>{
	
	private static ClinicaBo instance;
	
	private ClinicaBo() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadExames();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	public static ClinicaBo getInstance() {
		if(instance == null)
			instance = new ClinicaBo();
		return instance;
	}
	
	@Override
	public Clinica getById(Object id) throws Exception {
		Clinica clinica = this.getById(id, this.functionLoadAll);
		Helper.simpleSort(clinica.getExames());
		return clinica;
	}
	
	@Override
	public PagedList<Clinica> getList(ClinicaFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
}
