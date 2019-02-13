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
public class ItemPerguntaFichaColeta {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 64, message="Tamanho máximo para Título do Item da Pergunta: 64")
	@NotNull(message="É necessário informar o Título do Item da Pergunta.")
	private String titulo;
	
	@Size(max = 64, message="Tamanho máximo para Path do Item da Pergunta: 64")
	private String path; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	private PerguntaFichaColeta pergunta;
	
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

	public PerguntaFichaColeta getPergunta() {
		return pergunta;
	}

	public void setPergunta(PerguntaFichaColeta pergunta) {
		this.pergunta = pergunta;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
