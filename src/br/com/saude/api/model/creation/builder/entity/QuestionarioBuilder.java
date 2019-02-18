package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.QuestionarioFilter;
import br.com.saude.api.model.entity.po.Questionario;

public class QuestionarioBuilder extends GenericEntityBuilder<Questionario, QuestionarioFilter> {

	public static QuestionarioBuilder newInstance(Questionario questionario) {
		return new QuestionarioBuilder(questionario);
	}
	
	public static QuestionarioBuilder newInstance(List<Questionario> questionarios) {
		return new QuestionarioBuilder(questionarios);
	}
	
	private QuestionarioBuilder(Questionario questionario) {
		super(questionario);
	}
	
	private QuestionarioBuilder(List<Questionario> questionarios) {
		super(questionarios);
	}

	@Override
	protected Questionario clone(Questionario questionario) {
		Questionario newQuestionario = new Questionario();
		
		newQuestionario.setId(questionario.getId());
		newQuestionario.setTipo(questionario.getTipo());
		newQuestionario.setInativo(questionario.isInativo());
		newQuestionario.setNome(questionario.getNome());
		newQuestionario.setVersion(questionario.getVersion());
		
		return newQuestionario;
	}	
	
	public QuestionarioBuilder loadQuestoes() throws Exception {
		return (QuestionarioBuilder) this.loadProperty("questoes", questionario -> {
			return QuestaoBuilder.newInstance(questionario.getQuestoes()).getEntityList();
		});
	}

}
