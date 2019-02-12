package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.RegraAtendimentoEquipe;

public class RegraAtendimentoEquipeValidator extends GenericValidator<RegraAtendimentoEquipe> {

	@Override
	public void validate(RegraAtendimentoEquipe regra) throws Exception {
		super.validate(regra);
		
		if(Helper.isNotNull(regra.getDependencias())) {
			new DependenciaValidator().validate(regra.getDependencias());
		}
	}
}
