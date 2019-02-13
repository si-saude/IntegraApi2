package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.BooleanFilter;
import br.com.saude.api.generic.GenericFilter;

public class GerenciaFilter extends GenericFilter {
	private String codigoCompleto;
	private String descricao;
	private BooleanFilter ausentePeriodico;
	
	public String getCodigoCompleto() {
		return codigoCompleto;
	}
	public void setCodigoCompleto(String codigoCompleto) {
		this.codigoCompleto = codigoCompleto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BooleanFilter getAusentePeriodico() {
		return ausentePeriodico;
	}
	public void setAusentePeriodico(BooleanFilter ausentePeriodico) {
		this.ausentePeriodico = ausentePeriodico;
	}
}
