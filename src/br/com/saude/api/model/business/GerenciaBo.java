package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.GerenciaBuilder;
import br.com.saude.api.model.creation.builder.example.GerenciaExampleBuilder;
import br.com.saude.api.model.entity.filter.GerenciaFilter;
import br.com.saude.api.model.entity.po.Gerencia;
import br.com.saude.api.model.persistence.GerenciaDao;

public class GerenciaBo extends GenericBo<Gerencia, GerenciaFilter, GerenciaDao, GerenciaBuilder, 
	GerenciaExampleBuilder> {

	private static GerenciaBo instance;
	
	private GerenciaBo() {
		super();
	}
	
	public static GerenciaBo getInstance() {
		if(instance == null)
			instance = new GerenciaBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Gerencia> getList(GerenciaFilter filter) throws Exception {
		PagedList<Gerencia> list = super.getList(filter);
		Helper.simpleSort(list.getList());
		return list;
	}
}
