package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.AvaliacaoAtendimento;

public class AvaliacaoAtendimentoValidator extends GenericValidator<AvaliacaoAtendimento> {

	@Override
	public void validate(AvaliacaoAtendimento avaliacao) throws Exception {
		super.validate(avaliacao);
		
		if(Helper.isNotNull(avaliacao.getRespostas())) {
			new RespostaAvaliacaoAtendimentoValidator().validate(avaliacao.getRespostas());
		}
	}
}
