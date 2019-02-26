package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.DateFilter;
import br.com.saude.api.generic.GenericFilter;

public class FilaAtendimentoFilter extends GenericFilter {

	private LocalizacaoFilter localizacao;
	private ProfissionalFilter profissional;
	private DateFilter data;
	private String status;
	
	public LocalizacaoFilter getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(LocalizacaoFilter localizacao) {
		this.localizacao = localizacao;
	}
	public ProfissionalFilter getProfissional() {
		return profissional;
	}
	public void setProfissional(ProfissionalFilter profissional) {
		this.profissional = profissional;
	}
	public DateFilter getData() {
		return data;
	}
	public void setData(DateFilter data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
