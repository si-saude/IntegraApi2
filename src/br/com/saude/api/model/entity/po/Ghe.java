package br.com.saude.api.model.entity.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ghe {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar Nome do GHE.")
	@Size(max = 64, message="Tamanho m�ximo para Nome do GHE: 64")
	@Column(unique=true)
	private String nome;
	
	@NotNull(message="� necess�rio informar C�digo do GHE.")
	@Size(max = 64, message="Tamanho m�ximo para C�digo do GHE: 64")
	@Column(unique=true)
	private String codigo;
	
	private long dataCriacao;
	
	private long dataDesativacao;
	
	@Size(max = 1024, message="Tamanho m�ximo para Descri��o do GHE: 1024")
	private String descricao;
	
	@Size(max = 1024, message="Tamanho m�ximo para Descri��o do Ambiente do GHE: 1024")
	private String descricaoAmbiente;
	
	@Size(max = 1024, message="Tamanho m�ximo para Descri��o das Tarefas do GHE: 1024")
	private String descricaoTarefas;
	
	@Min(value=0, message="Valor m�nimo para Dura��o da Jornada do GHE: 0")
	private int duracaoJornada;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private RiscoGhe risco;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public long getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(long dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public long getDataDesativacao() {
		return dataDesativacao;
	}

	public void setDataDesativacao(long dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoAmbiente() {
		return descricaoAmbiente;
	}

	public void setDescricaoAmbiente(String descricaoAmbiente) {
		this.descricaoAmbiente = descricaoAmbiente;
	}

	public String getDescricaoTarefas() {
		return descricaoTarefas;
	}

	public void setDescricaoTarefas(String descricaoTarefas) {
		this.descricaoTarefas = descricaoTarefas;
	}

	public int getDuracaoJornada() {
		return duracaoJornada;
	}

	public void setDuracaoJornada(int duracaoJornada) {
		this.duracaoJornada = duracaoJornada;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public RiscoGhe getRisco() {
		return risco;
	}

	public void setRisco(RiscoGhe risco) {
		this.risco = risco;
	}
}
