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
public class ItemRespostaAvaliacaoAtendimento {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar a Resposta do Item.")
	@ManyToOne(fetch=FetchType.LAZY)
	private RespostaAvaliacaoAtendimento resposta;
	
	@Size(max = 2048, message="Tamanho máximo para Conteúdo do Item: 2048")
	@NotNull(message="É necessário informar o Conteúdo do Item.")
	private String conteudo;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RespostaAvaliacaoAtendimento getResposta() {
		return resposta;
	}

	public void setResposta(RespostaAvaliacaoAtendimento resposta) {
		this.resposta = resposta;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
