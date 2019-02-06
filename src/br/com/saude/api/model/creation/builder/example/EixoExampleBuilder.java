package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.EixoFilter;
import br.com.saude.api.model.entity.po.Eixo;

public class EixoExampleBuilder extends GenericExampleBuilder<Eixo, EixoFilter> {

	public static EixoExampleBuilder newInstance(EixoFilter filter) {
		return new EixoExampleBuilder(filter);
	}
	
	private EixoExampleBuilder(EixoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addTitulo();
		addEquipe();
	}
	
	private void addTitulo() {
		this.ilike("titulo", this.filter.getTitulo());
	}
	
	private void addEquipe() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("equipe", this.filter.getEquipe(),
				EquipeExampleBuilder.newInstance(this.filter.getEquipe()));
	}
}
