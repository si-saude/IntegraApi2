package br.com.saude.api.model.entity.dto;

public class TempoAtendimentoDto {

	private String empregado;
	private String equipe;
	private String profissional;
	private String status;
	private long inicio;
	private long fim;
	private long duracao;
	
	private long chegada;
	private long saida;
	private long tempoTotal;
	
	public String getEmpregado() {
		return empregado;
	}
	public void setEmpregado(String empregado) {
		this.empregado = empregado;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	public String getProfissional() {
		return profissional;
	}
	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getInicio() {
		return inicio;
	}
	public void setInicio(long inicio) {
		this.inicio = inicio;
	}
	public long getFim() {
		return fim;
	}
	public void setFim(long fim) {
		this.fim = fim;
	}
	public long getDuracao() {
		return duracao;
	}
	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}
	public long getChegada() {
		return chegada;
	}
	public void setChegada(long chegada) {
		this.chegada = chegada;
	}
	public long getSaida() {
		return saida;
	}
	public void setSaida(long saida) {
		this.saida = saida;
	}
	public long getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(long tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	
}
