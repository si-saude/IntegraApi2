package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Diagnostico {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 16, message="Tamanho m�ximo para C�digo do Diagn�stivo: 16")
	@NotNull(message="� necess�rio informar o C�digo do Diagn�stico.")
	private String codigo;
	
	@Size(max = 300, message="Tamanho m�ximo para Descri��o do Diagn�stivo: 300")
	@NotNull(message="� necess�rio informar o Descri��o do Diagn�stico.")
	private String descricao;
	
	@NotNull(message="� necess�rio informar o Inativo do Diagn�stico.")
	private boolean inativo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="� necess�rio informar o Eixo do Diagn�stico.")
	private Eixo eixo;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	public Eixo getEixo() {
		return eixo;
	}

	public void setEixo(Eixo eixo) {
		this.eixo = eixo;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
		
}
