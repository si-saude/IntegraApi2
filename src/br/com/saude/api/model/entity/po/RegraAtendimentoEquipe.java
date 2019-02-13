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
public class RegraAtendimentoEquipe {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar a Regra de Atendimento da Equipe.")
	@ManyToOne(fetch=FetchType.LAZY)
	private RegraAtendimento regraAtendimento;
	
	@NotNull(message="É necessário informar a Equipe da Regra.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Equipe equipe;
	
	private boolean acolhimento;
	
	private int ordem;
	
	@OneToMany(mappedBy="regraAtendimentoEquipe", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Dependencia> dependencias;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RegraAtendimento getRegraAtendimento() {
		return regraAtendimento;
	}

	public void setRegraAtendimento(RegraAtendimento regraAtendimento) {
		this.regraAtendimento = regraAtendimento;
	}
	
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public boolean isAcolhimento() {
		return acolhimento;
	}

	public void setAcolhimento(boolean acolhimento) {
		this.acolhimento = acolhimento;
	}

	public List<Dependencia> getDependencias() {
		return dependencias;
	}

	public void setDependencias(List<Dependencia> dependencias) {
		this.dependencias = dependencias;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
}
