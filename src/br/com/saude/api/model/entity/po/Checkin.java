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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Checkin {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar o Empregado do Check-in.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Empregado empregado;
	
	@NotNull(message="É necessário informar a Localização do Check-in.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Localizacao localizacao;
	
	@Min(value=1, message="É necessário informar a Chegada do Check-in.")
	private long chegada;
	
	@Min(value=1, message="É necessário informar a Atualização do Check-in.")
	private long atualizacao;
	
	@NotNull(message="É necessário informar o Status do Check-in.")
	@Size(max = 64, message="Tamanho máximo para Status do Check-in: 64")
	private String status;
	
	@NotNull(message="É necessário informar o Serviço do Check-in.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Servico servico;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="checkin_tarefa", 
				joinColumns = {@JoinColumn(name="checkin_id")}, 
				inverseJoinColumns = {@JoinColumn(name="tarefa_id")})
	@Fetch(FetchMode.SUBSELECT)
	private List<Tarefa> tarefas;
	
	@OneToMany(mappedBy="checkin", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy(value="codigo")
	private List<RespostaFichaColeta> respostas;
	
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

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public long getChegada() {
		return chegada;
	}

	public void setChegada(long chegada) {
		this.chegada = chegada;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public long getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(long atualizacao) {
		this.atualizacao = atualizacao;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<RespostaFichaColeta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaFichaColeta> respostas) {
		this.respostas = respostas;
	}
}
