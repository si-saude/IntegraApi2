package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class AlimentoMedidaCaseira {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar o Alimento do Alimento Medida Caseira.")
	@ManyToOne(fetch=FetchType.LAZY)
	private Alimento alimento;
	
	@NotNull(message="É necessário informar a Medida Caseira do Alimento Medida Caseira.")
	@ManyToOne(fetch=FetchType.EAGER)
	private MedidaCaseira medidaCaseira;
	
	private String referencia;
	
	private double quantidade;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public Alimento getAlimento() {
		return alimento;
	}
	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}
	public MedidaCaseira getMedidaCaseira() {
		return medidaCaseira;
	}
	public void setMedidaCaseira(MedidaCaseira medidaCaseira) {
		this.medidaCaseira = medidaCaseira;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
}
