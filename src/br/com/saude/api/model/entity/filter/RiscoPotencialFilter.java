package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.GenericFilter;

public class RiscoPotencialFilter extends GenericFilter {

	private String status;
	private EmpregadoFilter empregado;
	private EquipeFilter responsavel;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public EmpregadoFilter getEmpregado() {
		return empregado;
	}
	public void setEmpregado(EmpregadoFilter empregado) {
		this.empregado = empregado;
	}
	public EquipeFilter getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(EquipeFilter responsavel) {
		this.responsavel = responsavel;
	}	
}
