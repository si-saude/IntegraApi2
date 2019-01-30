package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Exame;

public class ExameValidator extends GenericValidator<Exame> {

	@Override
	public void validate(Exame exame) throws Exception {
		super.validate(exame);
		
		if(Helper.isNotNull(exame.getCampoExames()))
			new CampoExameValidator().validate(exame.getCampoExames());
	}
}
