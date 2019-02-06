package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.IntervencaoFilter;
import br.com.saude.api.model.entity.po.Intervencao;

public class IntervencaoExampleBuilder extends GenericExampleBuilder<Intervencao, IntervencaoFilter> {

	public static IntervencaoExampleBuilder newInstance(IntervencaoFilter filter) {
		return new IntervencaoExampleBuilder(filter);
	}
	
	private IntervencaoExampleBuilder(IntervencaoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addDescricao();
		addEquipe();
		addInativo();
	}
	
	private void addDescricao() {
		this.ilike("descricao", this.filter.getDescricao());
	}
	
	private void addInativo() {
		this.entity.setInativo(this.addBoolean("inativo", this.filter.getInativo()));
	}
	
	private void addEquipe() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("equipe", this.filter.getEquipe(),
				EquipeExampleBuilder.newInstance(this.filter.getEquipe()));
	}
}
