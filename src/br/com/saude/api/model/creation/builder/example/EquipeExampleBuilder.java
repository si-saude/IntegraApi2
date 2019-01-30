package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.EquipeFilter;
import br.com.saude.api.model.entity.po.Equipe;

public class EquipeExampleBuilder extends GenericExampleBuilder<Equipe, EquipeFilter> {

	public static EquipeExampleBuilder newInstance(EquipeFilter filter) {
		return new EquipeExampleBuilder(filter);
	}
	
	private EquipeExampleBuilder(EquipeFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addAbreviacao();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addAbreviacao() {
		this.ilike("abreviacao", this.filter.getAbreviacao());
	}
}
