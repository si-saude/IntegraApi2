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
import javax.persistence.OrderBy;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Servico {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar Nome do Serviço.")
	@Size(max = 128, message="Tamanho máximo para Nome do Serviço: 128")
	@Column(unique=true)
	private String nome;
	
	@NotNull(message="É necessário informar Código do Serviço.")
	@Size(max = 4, message="Tamanho máximo para Código do Serviço: 4")
	private String codigo;
	
	@Size(max = 64, message="Tamanho máximo para Grupo do Serviço: 64")
	@NotNull(message="É necessário informar Grupo do Serviço.")
	private String grupo;
	
	@Size(max = 256, message="Tamanho máximo para URL do Serviço: 256")
	private String url;
	
	private boolean publico;
	
	private boolean inativo;

	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="servico_equipe", 
	joinColumns = {@JoinColumn(name="servico_id")}, 
	inverseJoinColumns = {@JoinColumn(name="equipe_id")})
	@OrderBy(value="nome")
	private List<Equipe> equipes;
	
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
	
	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
}
