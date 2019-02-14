package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class RequisitoAso {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar o Conte�do do Requisito.")
	@Size(max = 50, message="Tamanho m�ximo para Conte�do do Requisito: 50")
	private String conteudo;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}	
}
