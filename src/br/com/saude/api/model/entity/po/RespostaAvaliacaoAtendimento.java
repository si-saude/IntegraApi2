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
public class RespostaAvaliacaoAtendimento {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar a Avaliação da Resposta.")
	@ManyToOne(fetch=FetchType.LAZY)
	private AvaliacaoAtendimento avaliacao;
	
	@NotNull(message="É necessário informar a Questão da Resposta.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Questao questao;
	
	@Size(max = 2048, message="Tamanho máximo para Conteúdo da Resposta: 2048")
	private String conteudo;
	
	@Formula(value="(select q.codigo from questao q where q.id = questao_id)")
	private String codigo;
	
	@OneToMany(mappedBy="resposta", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@Fetch(FetchMode.SUBSELECT)
	private List<ItemRespostaAvaliacaoAtendimento> itens;
	
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

	public AvaliacaoAtendimento getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoAtendimento avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<ItemRespostaAvaliacaoAtendimento> getItens() {
		return itens;
	}

	public void setItens(List<ItemRespostaAvaliacaoAtendimento> itens) {
		this.itens = itens;
	}
}
