package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.GenericFilter;

public class RiscoGheFilter extends GenericFilter {

	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
