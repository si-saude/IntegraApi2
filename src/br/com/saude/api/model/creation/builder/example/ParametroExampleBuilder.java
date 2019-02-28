package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.Parametro;

public class ParametroExampleBuilder extends GenericExampleBuilder<Parametro, GenericFilter> {

	public static ParametroExampleBuilder newInstance(GenericFilter filter) {
		return new ParametroExampleBuilder(filter);
	}
	
	private ParametroExampleBuilder(GenericFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {

	}
}
