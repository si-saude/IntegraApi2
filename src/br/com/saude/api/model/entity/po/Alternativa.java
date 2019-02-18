package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Alternativa {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar a Questão da Alternativa.")
	@ManyToOne(fetch=FetchType.LAZY)
	private Questao questao;
	
	@NotNull(message="É necessário informar o Título da Alternativa.")
	@Size(max = 1024, message="Tamanho máximo para o Título da Alternativa: 1024")
	private String titulo;
	
	@NotNull(message="É necessário informar o Código da Alternativa.")
	@Size(max = 4, message="Tamanho máximo para o Código da Alternativa: 4")
	private String codigo;
	
	@Size(max = 4, message="Tamanho máximo para o Código Anterior da Alternativa: 4")
	private String codigoAnterior;
	
	@Size(max = 4, message="Tamanho máximo para o Próximo Código da Alternativa: 4")
	private String codigoProximo;
	
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

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
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
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
