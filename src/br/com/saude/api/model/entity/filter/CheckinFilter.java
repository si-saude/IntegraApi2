package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.DateFilter;
import br.com.saude.api.generic.GenericFilter;

public class CheckinFilter extends GenericFilter {
	
	private EmpregadoFilter empregado;
	private LocalizacaoFilter localizacao;
	private ServicoFilter servico;
	private String status;
	private DateFilter chegada;

	public EmpregadoFilter getEmpregado() {
		return empregado;
	}

	public void setEmpregado(EmpregadoFilter empregado) {
		this.empregado = empregado;
	}

	public ServicoFilter getServico() {
		return servico;
	}

	public void setServico(ServicoFilter servico) {
		this.servico = servico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DateFilter getChegada() {
		return chegada;
	}

	public void setChegada(DateFilter chegada) {
		this.chegada = chegada;
	}

	public LocalizacaoFilter getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(LocalizacaoFilter localizacao) {
		this.localizacao = localizacao;
	}
}
