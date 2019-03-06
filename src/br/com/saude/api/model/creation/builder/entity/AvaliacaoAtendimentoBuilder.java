package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.AvaliacaoAtendimentoFilter;
import br.com.saude.api.model.entity.po.AvaliacaoAtendimento;

public class AvaliacaoAtendimentoBuilder extends GenericEntityBuilder<AvaliacaoAtendimento, AvaliacaoAtendimentoFilter> {

	public static AvaliacaoAtendimentoBuilder newInstance(AvaliacaoAtendimento avaliacao) {
		return new AvaliacaoAtendimentoBuilder(avaliacao);
	}
	
	public static AvaliacaoAtendimentoBuilder newInstance(List<AvaliacaoAtendimento> avaliacoes) {
		return new AvaliacaoAtendimentoBuilder(avaliacoes);
	}
	
	private AvaliacaoAtendimentoBuilder(AvaliacaoAtendimento avaliacao) {
		super(avaliacao);
	}
	
	private AvaliacaoAtendimentoBuilder(List<AvaliacaoAtendimento> avaliacoes) {
		super(avaliacoes);
	}

	@Override
	protected AvaliacaoAtendimento clone(AvaliacaoAtendimento avaliacao) {
		AvaliacaoAtendimento newAvaliacaoAtendimento = new AvaliacaoAtendimento();
		
		newAvaliacaoAtendimento.setId(avaliacao.getId());
		newAvaliacaoAtendimento.setStatus(avaliacao.getStatus());
		newAvaliacaoAtendimento.setVersion(avaliacao.getVersion());
		
		if(avaliacao.getCheckin() != null) {
			newAvaliacaoAtendimento.setCheckin(CheckinBuilder.newInstance(avaliacao.getCheckin()).getEntity());
		}
		
		if(avaliacao.getQuestionario() != null) {
			newAvaliacaoAtendimento.setQuestionario(QuestionarioBuilder
					.newInstance(avaliacao.getQuestionario()).getEntity());
		}
		
		return newAvaliacaoAtendimento;
	}	

	public AvaliacaoAtendimentoBuilder loadRespostas() throws Exception {
		return (AvaliacaoAtendimentoBuilder) this.loadProperty("respostas", avaliacao -> {
			return RespostaAvaliacaoAtendimentoBuilder
					.newInstance(avaliacao.getRespostas()).getEntityList();
		});
	}
}
