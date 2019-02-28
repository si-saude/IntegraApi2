package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.creation.builder.entity.ParametroBuilder;
import br.com.saude.api.model.creation.builder.example.ParametroExampleBuilder;
import br.com.saude.api.model.entity.po.Parametro;
import br.com.saude.api.model.persistence.ParametroDao;

public class ParametroBo extends GenericBo<Parametro, GenericFilter, ParametroDao, ParametroBuilder, 
	ParametroExampleBuilder> {

	private static ParametroBo instance;
	
	private ParametroBo() {
		super();
	}
	
	public static ParametroBo getInstance() {
		if(instance == null)
			instance = new ParametroBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
}
