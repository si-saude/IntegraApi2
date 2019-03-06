package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.RespostaAvaliacaoAtendimento;

public class RespostaAvaliacaoAtendimentoBuilder extends GenericEntityBuilder<RespostaAvaliacaoAtendimento, GenericFilter> {

	public static RespostaAvaliacaoAtendimentoBuilder newInstance(RespostaAvaliacaoAtendimento resposta) {
		return new RespostaAvaliacaoAtendimentoBuilder(resposta);
	}
	
	public static RespostaAvaliacaoAtendimentoBuilder newInstance(List<RespostaAvaliacaoAtendimento> respostas) {
		return new RespostaAvaliacaoAtendimentoBuilder(respostas);
	}
	
	private RespostaAvaliacaoAtendimentoBuilder(RespostaAvaliacaoAtendimento resposta) {
		super(resposta);
	}
	
	private RespostaAvaliacaoAtendimentoBuilder(List<RespostaAvaliacaoAtendimento> respostas) {
		super(respostas);
	}

	@Override
	protected RespostaAvaliacaoAtendimento clone(RespostaAvaliacaoAtendimento resposta) {
		RespostaAvaliacaoAtendimento newRespostaAvaliacaoAtendimento = new RespostaAvaliacaoAtendimento();
		
		newRespostaAvaliacaoAtendimento.setId(resposta.getId());
		newRespostaAvaliacaoAtendimento.setCodigo(resposta.getCodigo());
		newRespostaAvaliacaoAtendimento.setConteudo(resposta.getConteudo());
		newRespostaAvaliacaoAtendimento.setVersion(resposta.getVersion());
		
		if(resposta.getQuestao() != null) {
			newRespostaAvaliacaoAtendimento.setQuestao(QuestaoBuilder
					.newInstance(resposta.getQuestao()).getEntity());
		}
		
		if(Helper.isNotNull(resposta.getItens())) {
			newRespostaAvaliacaoAtendimento.setItens(ItemRespostaAvaliacaoAtendimentoBuilder
					.newInstance(resposta.getItens()).getEntityList());
		}
		
		return newRespostaAvaliacaoAtendimento;
	}	

}
