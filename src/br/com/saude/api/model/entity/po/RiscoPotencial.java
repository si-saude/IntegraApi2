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
import javax.validation.constraints.Size;

import org.hibernate.annotations.JoinFormula;

@Entity
public class RiscoPotencial {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 32, message="Tamanho máximo para Status: 32")
	@NotNull(message="É necessário informar o Status do Risco Potencial.")
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="É necessário informar o Empregado do Risco Potencial.")
	private Empregado empregado;
	
	@OneToMany(mappedBy="risco", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<RiscoEmpregado> riscos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinFormula("(select * from equipe e where e.id = getEquipeResponsavel(id))")
	private Equipe responsavel;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public List<RiscoEmpregado> getRiscos() {
		return riscos;
	}

	public void setRiscos(List<RiscoEmpregado> riscos) {
		this.riscos = riscos;
	}

	public Equipe getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Equipe responsavel) {
		this.responsavel = responsavel;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
