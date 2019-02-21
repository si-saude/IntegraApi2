package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Registro {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar o Nome do Registro.")
	@Size(max = 200, message="Tamanho máximo para Nome do Registro: 200")
	private String conselho;
	
	@Size(max = 2, message="Tamanho máximo para UF do Registro: 2")
	private String uf;
	
	@NotNull(message="É necessário informar o Número do Registro.")
	@Size(max = 26, message="Tamanho máximo para Nome do Registro: 26")
	private String numero;
	
	private long vencimento;

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

	public Long getVencimento() {
		return vencimento;
	}

	public void setVencimento(Long vencimento) {
		this.vencimento = vencimento;
	}
}
