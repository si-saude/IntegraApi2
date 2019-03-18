package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.BooleanFilter;
import br.com.saude.api.generic.GenericFilter;

public class AtendimentoFilter extends GenericFilter {

	private FilaAtendimentoFilter fila;
	private CheckinFilter checkin;
	private TarefaFilter tarefa;
	private BooleanFilter acolhimento;
	
	public FilaAtendimentoFilter getFila() {
		return fila;
	}
	public void setFila(FilaAtendimentoFilter fila) {
		this.fila = fila;
	}
	public CheckinFilter getCheckin() {
		return checkin;
	}
	public void setCheckin(CheckinFilter checkin) {
		this.checkin = checkin;
	}
	public TarefaFilter getTarefa() {
		return tarefa;
	}
	public void setTarefa(TarefaFilter tarefa) {
		this.tarefa = tarefa;
	}
	public BooleanFilter getAcolhimento() {
		return acolhimento;
	}
	public void setAcolhimento(BooleanFilter acolhimento) {
		this.acolhimento = acolhimento;
	}
	
}
