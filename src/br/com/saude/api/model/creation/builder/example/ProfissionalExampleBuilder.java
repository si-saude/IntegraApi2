package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.ProfissionalFilter;
import br.com.saude.api.model.entity.po.Profissional;

public class ProfissionalExampleBuilder extends GenericExampleBuilder<Profissional, ProfissionalFilter> {

	public static ProfissionalExampleBuilder newInstance(ProfissionalFilter filter) {
		return new ProfissionalExampleBuilder(filter);
	}
	
	private ProfissionalExampleBuilder(ProfissionalFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addEmpregado();
	}
	
	private void addEmpregado() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("empregado", this.filter.getEmpregado(),
				EmpregadoExampleBuilder.newInstance(this.filter.getEmpregado()));
	}
	
}
