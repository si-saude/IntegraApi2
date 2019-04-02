package br.com.saude.api.model.entity.dto;

public class TempoAtendimentoDto {

	private String empregado;
	private String equipe;
	private String profissional;
	private String status;
	private String duracao;
	private String tempoTotal;
	
	private long inicio;
	private long fim;
	private long chegada;
	private long saida;
	
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
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
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
	public String getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(String tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	
}
