package br.com.saude.api.model.entity.po;

import javax.persistence.Column;
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
public class Eixo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	@Size(max = 256, message="Tamanho m�ximo para Titulo do Eixo: 256")
	@NotNull(message="� necess�rio informar o T�tulo do Eixo.")
	private String titulo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="� necess�rio informar a Equipe do Eixo.")
	private Equipe equipe;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
