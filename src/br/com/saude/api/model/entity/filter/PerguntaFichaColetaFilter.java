package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.BooleanFilter;
import br.com.saude.api.generic.GenericFilter;

public class PerguntaFichaColetaFilter extends GenericFilter {
	private GrupoPerguntaFichaColetaFilter grupo;
	private String tipo;
	private String codigo;
	private String path;
	private BooleanFilter inativo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public GrupoPerguntaFichaColetaFilter getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoPerguntaFichaColetaFilter grupo) {
		this.grupo = grupo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public BooleanFilter getInativo() {
		return inativo;
	}
	public void setInativo(BooleanFilter inativo) {
		this.inativo = inativo;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
