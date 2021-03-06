package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
public class Registro {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 200, message="Tamanho m�ximo para Nome do Registro: 200")
	private String conselho;
	
	@Size(max = 2, message="Tamanho m�ximo para UF do Registro: 2")
	private String uf;
	
	@Size(max = 26, message="Tamanho m�ximo para Nome do Registro: 26")
	private String numero;
	
	private long vencimento;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public long getVencimento() {
		return vencimento;
	}

	public void setVencimento(long vencimento) {
		this.vencimento = vencimento;
	}
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
