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
public class IndicadorAssociadoSast {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="� necess�rio informar a Ger�ncia de Empregado.")
	private IndicadorSast indicadorSast;
	
	@Size(max = 3, message="Tamanho m�ximo para C�digo: 3")
	private String codigo;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public IndicadorSast getIndicadorSast() {
		return indicadorSast;
	}

	public void setIndicadorSast(IndicadorSast indicadorSast) {
		this.indicadorSast = indicadorSast;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
}
