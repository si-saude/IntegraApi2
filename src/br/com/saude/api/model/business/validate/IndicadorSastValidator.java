package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.IndicadorSast;

public class IndicadorSastValidator extends GenericValidator<IndicadorSast>{

	@Override
	public void validate(IndicadorSast indicador ) throws Exception {
		
		super.validate(indicador);
		
		if(Helper.isNotNull(indicador.getIndicadorAssociadoSasts()))
			new IndicadorAssociadoSastValidator().validate(indicador.getIndicadorAssociadoSasts());
	}
}
