package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.GenericFilter;

public class MedidaCaseiraFilter extends GenericFilter {

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
