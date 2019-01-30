package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.BaseFilter;
import br.com.saude.api.model.entity.po.Base;

public class BaseExampleBuilder extends GenericExampleBuilder<Base, BaseFilter> {

	public static BaseExampleBuilder newInstance(BaseFilter filter) {
		return new BaseExampleBuilder(filter);
	}
	
	private BaseExampleBuilder(BaseFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addUf();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addUf() {
		this.ilike("uf", this.filter.getUf());
	}
}
