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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

@Entity
public class RespostaFichaColeta {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="É necessário informar o Check-in da Resposta da Ficha de Coleta.")
	private Checkin checkin;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="É necessário informar a Pergunta da Resposta da Ficha de Coleta.")
	private PerguntaFichaColeta pergunta;
	
	@Size(max = 2048, message="Tamanho máximo para Conteúdo da Resposta da Ficha de Coleta: 2048")
	private String conteudo;
	
	@OneToMany(mappedBy="resposta", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@Fetch(FetchMode.SUBSELECT)
	private List<ItemRespostaFichaColeta> itens;
	
	@Formula(value="(select respostaFichaColetaGetCodigo(id))")
	private String codigo;
	
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

	public Checkin getCheckin() {
		return checkin;
	}

	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}

	public PerguntaFichaColeta getPergunta() {
		return pergunta;
	}

	public void setPergunta(PerguntaFichaColeta pergunta) {
		this.pergunta = pergunta;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public List<ItemRespostaFichaColeta> getItens() {
		return itens;
	}

	public void setItens(List<ItemRespostaFichaColeta> itens) {
		this.itens = itens;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
