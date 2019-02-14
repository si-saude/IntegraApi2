package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.RequisitoAsoFilter;
import br.com.saude.api.model.entity.po.RequisitoAso;

public class RequisitoAsoExampleBuilder extends GenericExampleBuilder<RequisitoAso, RequisitoAsoFilter> {

	public static RequisitoAsoExampleBuilder newInstance(RequisitoAsoFilter filter) {
		return new RequisitoAsoExampleBuilder(filter);
	}
	
	private RequisitoAsoExampleBuilder(RequisitoAsoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addConteudo();
	}
	
	private void addConteudo() {
		this.ilike("conteudo", this.filter.getConteudo());
	}
	
}
