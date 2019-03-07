package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.RiscoPotencialFilter;
import br.com.saude.api.model.entity.po.RiscoPotencial;

public class RiscoPotencialExampleBuilder extends GenericExampleBuilder<RiscoPotencial, RiscoPotencialFilter> {

	public static RiscoPotencialExampleBuilder newInstance(RiscoPotencialFilter filter) {
		return new RiscoPotencialExampleBuilder(filter);
	}
	
	private RiscoPotencialExampleBuilder(RiscoPotencialFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addStatus();
		addResponsavel();
		addEmpregado();
	}
	
	private void addStatus() {
		this.ilike("status", this.filter.getStatus());
	}
	
	private void addResponsavel() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("responsavel", this.filter.getResponsavel(),
				EquipeExampleBuilder.newInstance(this.filter.getResponsavel()));
	}
	
	private void addEmpregado() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("empregado", this.filter.getEmpregado(),
				EmpregadoExampleBuilder.newInstance(this.filter.getEmpregado()));
	}
}
