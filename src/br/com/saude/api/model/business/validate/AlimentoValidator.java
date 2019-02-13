package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Alimento;

public class AlimentoValidator extends GenericValidator<Alimento> {
	@Override
	public void validate(Alimento alimento) throws Exception {
		
		super.validate(alimento);
		
		if(Helper.isNotNull(alimento.getAlimentosMedidaCaseira()))
			new AlimentoMedidaCaseiraValidator().validate(alimento.getAlimentosMedidaCaseira());
	}
}
