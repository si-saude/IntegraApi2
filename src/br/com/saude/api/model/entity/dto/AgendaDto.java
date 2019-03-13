package br.com.saude.api.model.entity.dto;

public class AgendaDto {

	private String cliente;
	private String servico;
	private long data;
	private String equipes;
	private String status;
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public long getData() {
		return data;
	}
	public void setData(long data) {
		this.data = data;
	}
	public String getEquipes() {
		return equipes;
	}
	public void setEquipes(String equipes) {
		this.equipes = equipes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
