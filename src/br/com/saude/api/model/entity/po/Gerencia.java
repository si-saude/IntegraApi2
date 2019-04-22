package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Gerencia implements Comparable<Gerencia> {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar C�digo da Ger�ncia.")
	@Size(max = 16, message="Tamanho m�ximo para C�digo da Ger�ncia: 10")
	private String codigo;
	
	@Transient
	private String codigoCompleto;
	
	@Size(max = 200, message="Tamanho m�ximo para Descri��o da Ger�ncia: 200")
	private String descricao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Gerencia gerencia;
	
	private boolean ausentePeriodico;

	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Gerencia getGerencia() {
		return gerencia;
	}

	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	public String getCodigoCompleto() {
		if(this.codigoCompleto == null)
			this.codigoCompleto = getCodigoCompletoGerencia(codigo);
		return this.codigoCompleto;
	}
	
	private String getCodigoCompletoGerencia(String codigo) {
		if(this.gerencia!=null)
			return this.gerencia.getCodigoCompletoGerencia(this.gerencia.codigo+"/"+codigo);
		return codigo;
	}

	public boolean isAusentePeriodico() {
		return ausentePeriodico;
	}

	public void setAusentePeriodico(boolean ausentePeriodico) {
		this.ausentePeriodico = ausentePeriodico;
	}

	@Override
	public int compareTo(Gerencia g) {
		return this.getCodigoCompleto().compareTo(g.getCodigoCompleto());
	}
}
