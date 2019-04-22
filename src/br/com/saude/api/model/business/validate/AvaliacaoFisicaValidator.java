package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.AvaliacaoFisica;

public class AvaliacaoFisicaValidator extends GenericValidator<AvaliacaoFisica> {
	
	@Override
	public void validate(AvaliacaoFisica avaliacaoFisica) throws Exception {
		
		super.validate(avaliacaoFisica);
		
		if(Helper.isNotNull(avaliacaoFisica.getAtendimentoAtividadesFisicas()))
			new AtendimentoAtividadeFisicaValidator().validate(avaliacaoFisica.getAtendimentoAtividadesFisicas());
	}
}
