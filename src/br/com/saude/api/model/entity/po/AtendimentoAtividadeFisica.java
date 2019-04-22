package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class AtendimentoAtividadeFisica {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private boolean domingo;
	private boolean segunda;
	private boolean terca;
	private boolean quarta;
	private boolean quinta;
	private boolean sexta;
	private boolean sabado;
	
	@NotNull(message="É necessário informar os Minutos da Atividade Física.")
	private int minutos;
	
	@Transient
	private int total;
	
	@NotNull(message="É necessário informar a Classificação da Atividade Física.")
	@Size(max = 128, message="Tamanho máximo para Classificação da Atividade Física: 128")
	private String classificacao;
	
	@Size(max = 128, message="Tamanho máximo para Tipo da Atividade Física: 128")
	private String tipo;
	
	@Size(max = 2048, message="Tamanho máximo para Observação da Atividade Física: 2048")
	private String observacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="É necessário informar a Avaliação Física.")
	private AvaliacaoFisica avaliacaoFisica;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="É necessário informar a Atividade Física.")
	private AtividadeFisica atividade;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isDomingo() {
		return domingo;
	}

	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}

	public boolean isSegunda() {
		return segunda;
	}

	public void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}

	public boolean isTerca() {
		return terca;
	}

	public void setTerca(boolean terca) {
		this.terca = terca;
	}

	public boolean isQuarta() {
		return quarta;
	}

	public void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}

	public boolean isQuinta() {
		return quinta;
	}

	public void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}

	public boolean isSexta() {
		return sexta;
	}

	public void setSexta(boolean sexta) {
		this.sexta = sexta;
	}

	public boolean isSabado() {
		return sabado;
	}

	public void setSabado(boolean sabado) {
		this.sabado = sabado;
	}
	
	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	public int getTotal() {
		int dias = 0;
		if (this.isDomingo()) { dias++; }
		if (this.isSegunda()) { dias++; }
		if (this.isTerca()) { dias++; }
		if (this.isQuarta()) { dias++; }
		if (this.isQuinta()) { dias++; }
		if (this.isSexta()) { dias++; }
		if (this.isSabado()) { dias++; }
		
		this.total = dias * this.minutos;

		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	public AvaliacaoFisica getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}

	public AtividadeFisica getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadeFisica atividade) {
		this.atividade = atividade;
	}
}
