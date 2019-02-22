package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Curriculo;

public class CurriculoValidator extends GenericValidator<Curriculo> {

	@Override
	public void validate(Curriculo curriculo) throws Exception {
		if (Helper.isNotNull(curriculo.getCurriculoCursos())) {
			new CurriculoCursoValidator().validate(curriculo.getCurriculoCursos());
		}
	}
}
