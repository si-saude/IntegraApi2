package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.GrupoMonitoramento;

public class GrupoMonitoramentoValidator extends GenericValidator<GrupoMonitoramento>{

	@Override
	public void validate(GrupoMonitoramento grupoMonitoramento ) throws Exception {
		
		super.validate(grupoMonitoramento);
		
		if(Helper.isNotNull(grupoMonitoramento.getAvaliacoes()))
			new AvaliacaoValidator().validate(grupoMonitoramento.getAvaliacoes());
	}
}
