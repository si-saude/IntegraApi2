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
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class PerguntaFichaColeta {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="� necess�rio informar o Grupo da Pergunta.")
	@Size(max = 64, message="Tamanho m�ximo para Grupo da Pergunta: 64")
	private String grupo;
	
	@NotNull(message="� necess�rio informar o Tipo da Pergunta.")
	@Size(max = 64, message="Tamanho m�ximo para Tipo da Pergunta: 64")
	private String tipo;
	
	@NotNull(message="� necess�rio informar o C�digo da Pergunta.")
	@Size(max = 4, message="Tamanho m�ximo para C�digo da Pergunta: 4")
	private String codigo;
	
	@Size(max = 128, message="Tamanho m�ximo para Path da Pergunta: 128")
	private String path;
	
	@NotNull(message="� necess�rio informar o Descri��o da Pergunta.")
	@Size(max = 1024, message="Tamanho m�ximo para Descri��o da Pergunta: 1024")
	private String descricao;
	
	@OneToMany(mappedBy="pergunta", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ItemPerguntaFichaColeta> itens;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="perguntafichacoleta_equipe", 
	joinColumns = {@JoinColumn(name="perguntafichacoleta_id")}, 
	inverseJoinColumns = {@JoinColumn(name="equipe_id")})
	private List<Equipe> equipes;
	
	private boolean inativo;
	
	private int ordem;
	
	@Version
	private long version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ItemPerguntaFichaColeta> getItens() {
		return itens;
	}

	public void setItens(List<ItemPerguntaFichaColeta> itens) {
		this.itens = itens;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
