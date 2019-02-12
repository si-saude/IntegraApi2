package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.RegraAtendimento;

public class RegraAtendimentoValidator extends GenericValidator<RegraAtendimento> {

	@Override
	public void validate(RegraAtendimento regra) throws Exception {
		super.validate(regra);
		
		if(Helper.isNotNull(regra.getRegraAtendimentoEquipes())) {
			new RegraAtendimentoEquipeValidator().validate(regra.getRegraAtendimentoEquipes());
		}
	}
}
