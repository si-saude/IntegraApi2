package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.AtendimentoFilter;
import br.com.saude.api.model.entity.po.Atendimento;

public class AtendimentoExampleBuilder extends GenericExampleBuilder<Atendimento, AtendimentoFilter> {

	public static AtendimentoExampleBuilder newInstance(AtendimentoFilter filter) {
		return new AtendimentoExampleBuilder(filter);
	}
	
	private AtendimentoExampleBuilder(AtendimentoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addCheckin();
		addFila();
		addTarefa();
		addAcolhimento();
	}
	
	private void addAcolhimento() {
		this.entity.setAcolhimento(this.addBoolean("acolhimento", this.filter.getAcolhimento()));
	}
	
	private void addCheckin() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("checkin", this.filter.getCheckin(),
				CheckinExampleBuilder.newInstance(this.filter.getCheckin()));
	}
	
	private void addFila() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("fila", this.filter.getFila(),
				FilaAtendimentoExampleBuilder.newInstance(this.filter.getFila()));
	}
	
	private void addTarefa() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("tarefa", this.filter.getTarefa(),
				TarefaExampleBuilder.newInstance(this.filter.getTarefa()));
	}
}
