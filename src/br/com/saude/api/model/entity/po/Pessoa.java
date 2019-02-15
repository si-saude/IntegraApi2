package br.com.saude.api.model.entity.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;

@Entity
public class Pessoa {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar o Nome.")
	@Size(max = 400, message="Tamanho m�ximo para Nome: 400")
	private String nome;
	
	@Size(max = 32, message="Tamanho m�ximo para RG: 32")
	private String rg;
	
	@Column(unique=true)
	@Size(max = 11, message="Tamanho m�ximo para Cpf: 11")
	@NotNull(message="� necess�rio informar o Cpf.")
	private String cpf;
	
	@Min(value=1, message="� necess�rio informar a Data de Nascimento.")
	private long dataNascimento;
	
	@Size(max = 16, message="Tamanho m�ximo para Sexo: 16")
	private String sexo;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="pessoa_telefone", 
				joinColumns = {@JoinColumn(name="pessoa_id")}, 
				inverseJoinColumns = {@JoinColumn(name="telefone_id")})
	private List<Telefone> telefones;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@Formula(value="date_part('year', age(to_timestamp(dataNascimento/1000)))::integer")
	private int idade;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public long getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(long dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
