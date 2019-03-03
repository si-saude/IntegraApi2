package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

@Entity
public class Triagem {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="É necessário informar o Indicador da Triagem.")
	private IndicadorSast indicador;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="É necessário informar o Atendimento da Triagem.")
	private Atendimento atendimento;
	
	private int indice = -1;
	
	@Formula(value="indicador.codigo")
	private String codigo;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public IndicadorSast getIndicador() {
		return indicador;
	}

	public void setIndicador(IndicadorSast indicador) {
		this.indicador = indicador;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
