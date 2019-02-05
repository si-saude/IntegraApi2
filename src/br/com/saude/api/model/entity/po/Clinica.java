package br.com.saude.api.model.entity.po;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Clinica {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar Nome da Cl�nica.")
	@Size(max = 128, message="Tamanho m�ximo para Nome da Cl�nica: 128")
	private String nome;
	
	@Size(max = 512, message="Tamanho m�ximo para Endere�o da Cl�nica: 512")
	private String endereco;
	
	@Size(max = 128, message="Tamanho m�ximo para Telefoned da Cl�nica: 128")
	private String telefones;
	
	@NotNull(message="� necess�rio informar UF da Cl�nica.")
	@Size(max = 2, message="Tamanho m�ximo para UF da Cl�nica: 2")
	private String uf;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="clinica_exame", 
	joinColumns = {@JoinColumn(name="clinica_id")}, 
	inverseJoinColumns = {@JoinColumn(name="exame_id")})
	private List<Exame> exames;
	
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

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}
}
