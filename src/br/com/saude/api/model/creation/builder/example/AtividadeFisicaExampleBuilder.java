package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.AtividadeFisicaFilter;
import br.com.saude.api.model.entity.po.AtividadeFisica;

public class AtividadeFisicaExampleBuilder extends GenericExampleBuilder<AtividadeFisica, AtividadeFisicaFilter> {

	public static AtividadeFisicaExampleBuilder newInstance(AtividadeFisicaFilter filter) {
		return new AtividadeFisicaExampleBuilder(filter);
	}
	
	private AtividadeFisicaExampleBuilder(AtividadeFisicaFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addDescricao();
	}
	
	private void addDescricao() {
		this.ilike("descricao", this.filter.getDescricao());
	}
	
}
