package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class Atendimento {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar a Fila do Atendimento.")
	@ManyToOne(fetch=FetchType.EAGER)
	private FilaAtendimento fila;
	
	@NotNull(message="É necessário informar a Tarefa do Atendimento.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Tarefa tarefa;
	
	@NotNull(message="É necessário informar o Check-in do Atendimento.")
	@ManyToOne(fetch=FetchType.EAGER)
	private Checkin checkin;
	
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

	public FilaAtendimento getFila() {
		return fila;
	}

	public void setFila(FilaAtendimento fila) {
		this.fila = fila;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Checkin getCheckin() {
		return checkin;
	}

	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}
}
