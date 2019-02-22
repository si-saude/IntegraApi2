package br.com.saude.api.model.entity.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class ProfissiogramaExame {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar o Exame do Grupo de Monitoramento.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Exame exame;
	
	@NotNull(message="É necessário informar o Grupo de Monitoramento do Exame.")
	@ManyToOne(fetch=FetchType.LAZY)
	private ProfissiogramaGrupo profissiogramaGrupo;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinTable(name="profissiogramaexame_criterio", 
	joinColumns = {@JoinColumn(name="profissiogramaexame_id")}, 
	inverseJoinColumns = {@JoinColumn(name="criterio_id")})
	private List<Criterio> criterios;
	
	private boolean opcional;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Criterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}

	public boolean isOpcional() {
		return opcional;
	}

	public void setOpcional(boolean opcional) {
		this.opcional = opcional;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public ProfissiogramaGrupo getProfissiogramaGrupo() {
		return profissiogramaGrupo;
	}

	public void setProfissiogramaGrupo(ProfissiogramaGrupo profissiogramaGrupo) {
		this.profissiogramaGrupo = profissiogramaGrupo;
	}
}
