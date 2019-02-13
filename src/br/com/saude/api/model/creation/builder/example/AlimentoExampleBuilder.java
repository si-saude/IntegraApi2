package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.AlimentoFilter;
import br.com.saude.api.model.entity.po.Alimento;

public class AlimentoExampleBuilder extends GenericExampleBuilder<Alimento, AlimentoFilter> {

	public static AlimentoExampleBuilder newInstance(AlimentoFilter filter) {
		return new AlimentoExampleBuilder(filter);
	}
	
	private AlimentoExampleBuilder(AlimentoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addInativo();
		addTipo();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addInativo() {
		this.entity.setInativo(this.addBoolean("inativo", this.filter.getInativo()));
	}
	
	private void addTipo() {
		this.ilike("tipo", this.filter.getTipo());
	}
	
}
