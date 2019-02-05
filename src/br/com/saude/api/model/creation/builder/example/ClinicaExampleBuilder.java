package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.ClinicaFilter;
import br.com.saude.api.model.entity.po.Clinica;

public class ClinicaExampleBuilder extends GenericExampleBuilder<Clinica,ClinicaFilter> {

	public static ClinicaExampleBuilder newInstance(ClinicaFilter filter) {
		return new ClinicaExampleBuilder(filter);
	}
	
	private ClinicaExampleBuilder(ClinicaFilter filter) {
		super(filter);
	}

	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addUf() {
		this.ilike("uf", this.filter.getUf());
	}
	

	@Override
	protected void createExample() {
		addNome();
		addUf();
	}
}
