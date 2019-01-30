package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.GenericFilter;

public class CriterioFilter extends GenericFilter {

	private String nome;
	private String tipo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}
