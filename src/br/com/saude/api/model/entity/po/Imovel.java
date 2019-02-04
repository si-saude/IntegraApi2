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
public class Imovel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar Nome da Im�vel.")
	@Size(max = 64, message="Tamanho m�ximo para Nome da Im�vel: 64")
	@Column(unique=true)
	private String nome;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Base base;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
}
