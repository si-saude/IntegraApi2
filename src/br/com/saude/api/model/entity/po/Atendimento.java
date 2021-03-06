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
import javax.persistence.OrderBy;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

@Entity
public class Atendimento {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar a Fila do Atendimento.")
	@ManyToOne(fetch=FetchType.EAGER)
	private FilaAtendimento fila;
	
	@NotNull(message="� necess�rio informar a Tarefa do Atendimento.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Tarefa tarefa;
	
	@NotNull(message="� necess�rio informar o Check-in do Atendimento.")
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Checkin checkin;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumnsOrFormulas({
	    @JoinColumnOrFormula(formula=@JoinFormula(value="(select af.id "
	    		+ "from avaliacaofisica af "
	    		+ "where af.atendimento_id = id "
	    		+ "limit 1)", referencedColumnName="id")),
	})
	private AvaliacaoFisica avaliacaoFisica;
	
	@OrderBy(value="codigo")
	@OneToMany(mappedBy="atendimento", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@Fetch(FetchMode.SUBSELECT)
	private List<Triagem> triagens;
	
	private boolean acolhimento;
	
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

	public FilaAtendimento getFila() {
		return fila;
	}

	public void setFila(FilaAtendimento fila) {
		this.fila = fila;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Checkin getCheckin() {
		return checkin;
	}

	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}
	
	public AvaliacaoFisica getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}

	public List<Triagem> getTriagens() {
		return triagens;
	}

	public void setTriagens(List<Triagem> triagens) {
		this.triagens = triagens;
	}

	public boolean isAcolhimento() {
		return acolhimento;
	}

	public void setAcolhimento(boolean acolhimento) {
		this.acolhimento = acolhimento;
	}
}
