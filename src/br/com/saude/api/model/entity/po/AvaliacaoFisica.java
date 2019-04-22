package br.com.saude.api.model.entity.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class AvaliacaoFisica {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private boolean pratica;
	
	private boolean interesse;
	
	private boolean acao;
	
	@Size(max = 2048, message="Tamanho máximo para Observações da Avaliação Física: 2048")
	private String observacoes;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "atendimento_id")
	private Atendimento atendimento;

	@OneToMany(mappedBy="avaliacaoFisica", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@Fetch(FetchMode.SUBSELECT)
	private List<AtendimentoAtividadeFisica> atendimentoAtividadesFisicas;

	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isPratica() {
		return pratica;
	}

	public void setPratica(boolean pratica) {
		this.pratica = pratica;
	}
	
	public boolean isInteresse() {
		return interesse;
	}

	public void setInteresse(boolean interesse) {
		this.interesse = interesse;
	}
	
	public boolean isAcao() {
		return acao;
	}

	public void setAcao(boolean acao) {
		this.acao = acao;
	}
	
	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public List<AtendimentoAtividadeFisica> getAtendimentoAtividadesFisicas() {
		return atendimentoAtividadesFisicas;
	}

	public void setAtendimentoAtividadesFisicas(List<AtendimentoAtividadeFisica> atendimentoAtividadesFisicas) {
		this.atendimentoAtividadesFisicas = atendimentoAtividadesFisicas;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
