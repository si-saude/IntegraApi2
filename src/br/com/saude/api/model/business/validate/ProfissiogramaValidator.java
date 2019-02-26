package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Profissiograma;

public class ProfissiogramaValidator extends GenericValidator<Profissiograma> {

	@Override
	public void validate(Profissiograma profissiograma) throws Exception {
		super.validate(profissiograma);
		
		if(Helper.isNotNull(profissiograma.getProfissiogramaGrupos()))
			new ProfissiogramaGrupoValidator().validate(profissiograma.getProfissiogramaGrupos());
	}
}
