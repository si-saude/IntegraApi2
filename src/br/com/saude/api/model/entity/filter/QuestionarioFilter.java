package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.BooleanFilter;
import br.com.saude.api.generic.GenericFilter;

public class QuestionarioFilter extends GenericFilter {

	private String nome;
	private String tipo;
	private BooleanFilter inativo;

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

	public BooleanFilter getInativo() {
		return inativo;
	}

	public void setInativo(BooleanFilter inativo) {
		this.inativo = inativo;
	}
	
}
