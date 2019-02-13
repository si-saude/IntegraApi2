package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.PerguntaFichaColeta;

public class PerguntaFichaColetaValidator extends GenericValidator<PerguntaFichaColeta> {

	@Override
	public void validate(PerguntaFichaColeta pergunta) throws Exception {
		super.validate(pergunta);
		
		if(Helper.isNotNull(pergunta.getItens())) {
			new ItemPerguntaFichaColetaValidator().validate(pergunta.getItens());
		}
	}
}
