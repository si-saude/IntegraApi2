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
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class AvaliacaoAtendimento {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotNull(message="� necess�rio informar o Check-in da Avalia��o.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Checkin checkin;
	
	@NotNull(message="� necess�rio informar o Question�rio da Avalia��o.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Questionario questionario;
	
	@OneToMany(mappedBy="avaliacao", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy(value="codigo")
	private List<RespostaAvaliacaoAtendimento> respostas;
	
	@NotNull(message="� necess�rio informar o Status da Avalia��o.")
	@Size(max = 64, message="Tamanho m�ximo para Status da Avalia��o: 64")
	private String status;
	
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

	public Checkin getCheckin() {
		return checkin;
	}

	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public List<RespostaAvaliacaoAtendimento> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaAvaliacaoAtendimento> respostas) {
		this.respostas = respostas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
