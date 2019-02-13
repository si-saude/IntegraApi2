package br.com.saude.api.model.entity.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ghee {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar Nome do GHEE.")
	@Size(max = 64, message="Tamanho máximo para Nome do GHEE: 64")
	@Column(unique=true)
	private String nome;
	
	@NotNull(message="É necessário informar Código do GHEE.")
	@Size(max = 64, message="Tamanho máximo para Código do GHEE: 64")
	@Column(unique=true)
	private String codigo;
	
	private long dataCriacao;
	
	private long dataDesativacao;
	
	@Size(max = 1024, message="Tamanho máximo para Descrição do GHEE: 1024")
	private String descricao;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public long getDataCriacao() {
		return dataCriacao;
	}

	public long getDataDesativacao() {
		return dataDesativacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public long getVersion() {
		return version;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDataCriacao(long dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setDataDesativacao(long dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setVersion(long version) {
		this.version = version;
	}	
}
