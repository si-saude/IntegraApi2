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
public class RiscoEmpregado {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="É necessário informar o Risco Potencial do Risco Empregado.")
	private RiscoPotencial risco;
	
	@Size(max = 32, message="Tamanho máximo para Status: 32")
	@NotNull(message="É necessário informar o Status do Risco Empregado.")
	private String status;
	
	private long data;
	
	private double valor;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RiscoPotencial getRisco() {
		return risco;
	}

	public void setRisco(RiscoPotencial risco) {
		this.risco = risco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}
}
