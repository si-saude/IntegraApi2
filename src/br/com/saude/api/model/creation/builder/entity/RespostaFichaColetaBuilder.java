package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.RespostaFichaColeta;

public class RespostaFichaColetaBuilder 
	extends GenericEntityBuilder<RespostaFichaColeta, GenericFilter> {

	public static RespostaFichaColetaBuilder newInstance(RespostaFichaColeta resposta) {
		return new RespostaFichaColetaBuilder(resposta);
	}
	
	public static RespostaFichaColetaBuilder newInstance(List<RespostaFichaColeta> respostas) {
		return new RespostaFichaColetaBuilder(respostas);
	}
	
	private RespostaFichaColetaBuilder(RespostaFichaColeta resposta) {
		super(resposta);
	}
	
	private RespostaFichaColetaBuilder(List<RespostaFichaColeta> respostas) {
		super(respostas);
	}

	@Override
	protected RespostaFichaColeta clone(RespostaFichaColeta resposta) {
		RespostaFichaColeta newRespostaFichaColeta = new RespostaFichaColeta();
		
		newRespostaFichaColeta.setId(resposta.getId());
		newRespostaFichaColeta.setCodigo(resposta.getCodigo());
		newRespostaFichaColeta.setConteudo(resposta.getConteudo());
		newRespostaFichaColeta.setVersion(resposta.getVersion());
		
		if(resposta.getPergunta() != null) {
			newRespostaFichaColeta.setPergunta(PerguntaFichaColetaBuilder
					.newInstance(resposta.getPergunta()).getEntity());
		}
		
		if(Helper.isNotNull(resposta.getItens())) {
			newRespostaFichaColeta.setItens(ItemRespostaFichaColetaBuilder
					.newInstance(resposta.getItens()).getEntityList());
		}
		
		return newRespostaFichaColeta;
	}	

}
