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
public class Intervencao {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="� necess�rio informar a Equipe da Interven��o.")
	private Equipe equipe;
	
	@Size(max = 2048, message="Tamanho m�ximo para Descri��o da Interven��o: 2048")
	@NotNull(message="� necess�rio informar a Descri��o da Interven��o.")
	private String descricao;
	
	@NotNull(message="� necess�rio informar o Inativo da Interven��o.")
	private boolean inativo;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
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

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}