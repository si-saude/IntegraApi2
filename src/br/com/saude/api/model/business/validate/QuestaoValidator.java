package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Questao;

public class QuestaoValidator extends GenericValidator<Questao> {
	
	@Override
	public void validate(Questao questao) throws Exception {
		super.validate(questao);
		
		if(Helper.isNotNull(questao.getAlternativas())) {
			new AlternativaValidator().validate(questao.getAlternativas());
		}
	}
}
