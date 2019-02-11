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
	private int id;
	
	@Size(max = 64, message="Tamanho m�ximo para Label do Item Pergunta Ficha Coleta.: 64")
	@NotNull(message="� necess�rio informar o Label da Pergunta.")
	private String label;
	
	@Size(max = 64, message="Tamanho m�ximo para Path do Item Pergunta Ficha Coleta.: 64")
	private String path; 
	
	@ManyToOne(fetch=FetchType.EAGER)
	private PerguntaFichaColeta pergunta;
	
	@Version
	private long version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
	
}
