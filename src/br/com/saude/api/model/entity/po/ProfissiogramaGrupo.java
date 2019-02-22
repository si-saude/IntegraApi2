package br.com.saude.api.model.entity.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class ProfissiogramaGrupo {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar o Grupo de Monitoramento.")
	@ManyToOne(fetch=FetchType.EAGER)
	private GrupoMonitoramento grupoMonitoramento;
	
	@NotNull(message="É necessário informar o Profissiograma.")
	@ManyToOne(fetch=FetchType.LAZY)
	private Profissiograma profissiograma;
	
	@OneToMany(mappedBy="profissiogramaGrupo", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ProfissiogramaExame> profissiogramaExames;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public GrupoMonitoramento getGrupoMonitoramento() {
		return grupoMonitoramento;
	}

	public void setGrupoMonitoramento(GrupoMonitoramento grupoMonitoramento) {
		this.grupoMonitoramento = grupoMonitoramento;
	}

	public Profissiograma getProfissiograma() {
		return profissiograma;
	}

	public void setProfissiograma(Profissiograma profissiograma) {
		this.profissiograma = profissiograma;
	}

	public List<ProfissiogramaExame> getProfissiogramaExames() {
		return profissiogramaExames;
	}

	public void setProfissiogramaExames(List<ProfissiogramaExame> profissiogramaExames) {
		this.profissiogramaExames = profissiogramaExames;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
