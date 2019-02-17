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

@Entity
public class Questao {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar a Quest�o da Alternativa.")
	@ManyToOne(fetch=FetchType.LAZY)
	private Questionario questionario;
	
	@NotNull(message="� necess�rio informar o T�tulo da Quest�o.")
	@Size(max = 2048, message="Tamanho m�ximo para o T�tulo da Quest�o: 2048")
	private String titulo;
	
	@NotNull(message="� necess�rio informar o Tipo da Quest�o.")
	@Size(max = 64, message="Tamanho m�ximo para o Tipo da Quest�o: 64")
	private String tipo;
	
	@NotNull(message="� necess�rio informar o C�digo da Quest�o.")
	@Size(max = 4, message="Tamanho m�ximo para o C�digo da Quest�o: 4")
	private String codigo;
	
	@Size(max = 4, message="Tamanho m�ximo para o C�digo Anterior da Quest�o: 4")
	private String codigoAnterior;
	
	@Size(max = 4, message="Tamanho m�ximo para o Pr�ximo C�digo da Quest�o: 4")
	private String codigoProximo;
	
	@OrderBy(value="codigo")
	@OneToMany(mappedBy="questao", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Alternativa> alternativas;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setNome(String titulo) {
		this.titulo = titulo;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
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

	public String getCodigoAnterior() {
		return codigoAnterior;
	}

	public void setCodigoAnterior(String codigoAnterior) {
		this.codigoAnterior = codigoAnterior;
	}

	public String getCodigoProximo() {
		return codigoProximo;
	}

	public void setCodigoProximo(String codigoProximo) {
		this.codigoProximo = codigoProximo;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
