package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.model.entity.po.Atendimento;

public class AtendimentoValidator extends GenericValidator<Atendimento> {
	
	@Override
	public void validate(Atendimento atendimento) throws Exception {
		
		super.validate(atendimento);
		
		if(atendimento.getAvaliacaoFisica() != null)
			new AvaliacaoFisicaValidator().validate(atendimento.getAvaliacaoFisica());
	}
}
