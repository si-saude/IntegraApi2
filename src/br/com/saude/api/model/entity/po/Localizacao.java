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
public class Localizacao {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar o Nome da Localização.")
	@Size(max = 50, message="Tamanho máximo para Nome da Localização: 50")
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="É necessário informar a Base da Localização.")
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

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}
	
}
