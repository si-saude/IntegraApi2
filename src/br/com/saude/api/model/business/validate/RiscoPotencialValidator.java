package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.RiscoPotencial;

public class RiscoPotencialValidator extends GenericValidator<RiscoPotencial> {

	@Override
	public void validate(RiscoPotencial risco) throws Exception {
		super.validate(risco);
		
		if(Helper.isNotNull(risco.getRiscos())) {
			new RiscoEmpregadoValidator().validate(risco.getRiscos());
		}
	}
}
