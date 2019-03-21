package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Parametro {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private RegraAtendimento regraPeriodico;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Equipe acolhimento;
		
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RegraAtendimento getRegraPeriodico() {
		return regraPeriodico;
	}

	public void setRegraPeriodico(RegraAtendimento regraPeriodico) {
		this.regraPeriodico = regraPeriodico;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Equipe getAcolhimento() {
		return acolhimento;
	}

	public void setAcolhimento(Equipe acolhimento) {
		this.acolhimento = acolhimento;
	}
}
