package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.GenericFilter;

public class ProfissionalFilter extends GenericFilter {
	
	private EmpregadoFilter empregado;

	public EmpregadoFilter getEmpregado() {
		return empregado;
	}

	public void setEmpregado(EmpregadoFilter empregado) {
		this.empregado = empregado;
	}	
}
