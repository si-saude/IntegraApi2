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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class ItemRespostaFichaColeta {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="É necessário informar a Resposta do Item.")
	private RespostaFichaColeta resposta;
	
	@OrderBy(value="ordem")
	@OneToMany(mappedBy="item", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@Fetch(FetchMode.SUBSELECT)
	private List<DetalheRespostaFichaColeta> detalhes;
	
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

	public RespostaFichaColeta getResposta() {
		return resposta;
	}

	public void setResposta(RespostaFichaColeta resposta) {
		this.resposta = resposta;
	}

	public List<DetalheRespostaFichaColeta> getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(List<DetalheRespostaFichaColeta> detalhes) {
		this.detalhes = detalhes;
	}
}
