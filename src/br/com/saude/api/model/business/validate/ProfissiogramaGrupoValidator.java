package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.ProfissiogramaGrupo;

public class ProfissiogramaGrupoValidator extends GenericValidator<ProfissiogramaGrupo> {

	@Override
	public void validate(ProfissiogramaGrupo profissiogramaGrupo) throws Exception {
		super.validate(profissiogramaGrupo);
		
		if(Helper.isNotNull(profissiogramaGrupo.getProfissiogramaExames())) {
			new ProfissiogramaExameValidator().validate(profissiogramaGrupo.getProfissiogramaExames());
		}
	}
}
