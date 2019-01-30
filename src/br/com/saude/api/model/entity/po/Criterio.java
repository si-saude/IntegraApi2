package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Criterio {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar Nome do Crit�rio.")
	@Size(max = 256, message="Tamanho m�ximo para Nome do Crit�rio: 256")
	private String nome;
	
	@NotNull(message="� necess�rio informar Tipo do Crit�rio.")
	@Size(max = 64, message="Tamanho m�ximo para Tipo do Crit�rio: 64")
	private String tipo;
	
	@Size(max = 16, message="Tamanho m�ximo para Operador do Crit�rio: 16")
	private String operador;
	
	@NotNull(message="� necess�rio informar Valor do Crit�rio.")
	@Size(max = 64, message="Tamanho m�ximo para Valor do Crit�rio: 64")
	private String valor;
	
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	
}
