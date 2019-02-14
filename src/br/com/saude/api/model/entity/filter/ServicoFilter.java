package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.BooleanFilter;
import br.com.saude.api.generic.GenericFilter;

public class ServicoFilter extends GenericFilter {

	private String nome;
	private String codigo;
	private String grupo;
	private BooleanFilter publico;
	private BooleanFilter inativo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public BooleanFilter getPublico() {
		return publico;
	}
	public void setPublico(BooleanFilter publico) {
		this.publico = publico;
	}
	public BooleanFilter getInativo() {
		return inativo;
	}
	public void setInativo(BooleanFilter inativo) {
		this.inativo = inativo;
	}
	
}
