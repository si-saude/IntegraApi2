package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.AvaliacaoAtendimentoFilter;
import br.com.saude.api.model.entity.po.AvaliacaoAtendimento;

public class AvaliacaoAtendimentoExampleBuilder extends GenericExampleBuilder<AvaliacaoAtendimento, AvaliacaoAtendimentoFilter> {

	public static AvaliacaoAtendimentoExampleBuilder newInstance(AvaliacaoAtendimentoFilter filter) {
		return new AvaliacaoAtendimentoExampleBuilder(filter);
	}
	
	private AvaliacaoAtendimentoExampleBuilder(AvaliacaoAtendimentoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addStatus();
		addCheckin();
		addQuestionario();
	}
	
	private void addStatus() {
		this.ilike("status", this.filter.getStatus());
	}
	
	private void addCheckin() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("checkin", this.filter.getCheckin(),
				CheckinExampleBuilder.newInstance(this.filter.getCheckin()));
	}
	
	private void addQuestionario() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("questionario", this.filter.getQuestionario(),
				QuestionarioExampleBuilder.newInstance(this.filter.getQuestionario()));
	}
}
