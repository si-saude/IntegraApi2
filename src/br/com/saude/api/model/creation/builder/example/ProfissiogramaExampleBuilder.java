package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.ProfissiogramaFilter;
import br.com.saude.api.model.entity.po.Profissiograma;

public class ProfissiogramaExampleBuilder extends GenericExampleBuilder<Profissiograma,ProfissiogramaFilter> {

	public static ProfissiogramaExampleBuilder newInstance(ProfissiogramaFilter filter) {
		return new ProfissiogramaExampleBuilder(filter);
	}
	
	private ProfissiogramaExampleBuilder(ProfissiogramaFilter filter) {
		super(filter);
	}

	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addVinculo() {
		this.ilike("vinculo", this.filter.getVinculo());
	}
	
	private void addConcluido() {
		this.entity.setConcluido(this.addBoolean("concluido", this.filter.getConcluido()));
	}

	@Override
	protected void createExample() {
		addNome();
		addVinculo();
		addConcluido();
	}
}
