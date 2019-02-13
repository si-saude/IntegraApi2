package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.RegimeFilter;
import br.com.saude.api.model.entity.po.Regime;

public class RegimeExampleBuilder extends GenericExampleBuilder<Regime, RegimeFilter> {

	public static RegimeExampleBuilder newInstance(RegimeFilter filter) {
		return new RegimeExampleBuilder(filter);
	}
	
	private RegimeExampleBuilder(RegimeFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
}
