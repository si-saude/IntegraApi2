package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Questionario;

public class QuestionarioValidator extends GenericValidator<Questionario> {
	
	@Override
	public void validate(Questionario questionario) throws Exception {
		super.validate(questionario);
		
		if(Helper.isNotNull(questionario.getQuestoes())) {
			new QuestaoValidator().validate(questionario.getQuestoes());
		}
	}
}
