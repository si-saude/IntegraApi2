package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.BooleanFilter;
import br.com.saude.api.generic.GenericFilter;

public class IndicadorSastFilter extends GenericFilter {
	private String nome;
	private String codigo;
	private EquipeFilter equipe;
	private BooleanFilter obrigatorio;
	private BooleanFilter ausenteCalculoInterdisciplinar;
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
	public EquipeFilter getEquipe() {
		return equipe;
	}
	public void setEquipe(EquipeFilter equipe) {
		this.equipe = equipe;
	}
	public BooleanFilter getObrigatorio() {
		return obrigatorio;
	}
	public void setObrigatorio(BooleanFilter obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	public BooleanFilter getInativo() {
		return inativo;
	}
	public void setInativo(BooleanFilter inativo) {
		this.inativo = inativo;
	}
	public BooleanFilter getAusenteCalculoInterdisciplinar() {
		return ausenteCalculoInterdisciplinar;
	}
	public void setAusenteCalculoInterdisciplinar(BooleanFilter ausenteCalculoInterdisciplinar) {
		this.ausenteCalculoInterdisciplinar = ausenteCalculoInterdisciplinar;
	}
}
