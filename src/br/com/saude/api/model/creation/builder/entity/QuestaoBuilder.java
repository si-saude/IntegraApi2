package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Questao;

public class QuestaoBuilder extends GenericEntityBuilder<Questao, GenericFilter> {

	public static QuestaoBuilder newInstance(Questao questao) {
		return new QuestaoBuilder(questao);
	}
	
	public static QuestaoBuilder newInstance(List<Questao> questaos) {
		return new QuestaoBuilder(questaos);
	}
	
	private QuestaoBuilder(Questao questao) {
		super(questao);
	}
	
	private QuestaoBuilder(List<Questao> questaos) {
		super(questaos);
	}

	@Override
	protected Questao clone(Questao questao) {
		Questao newQuestao = new Questao();
		
		newQuestao.setId(questao.getId());
		newQuestao.setCodigo(questao.getCodigo());
		newQuestao.setCodigoAnterior(questao.getCodigoAnterior());
		newQuestao.setCodigoProximo(questao.getCodigoProximo());
		newQuestao.setTitulo(questao.getTitulo());
		newQuestao.setTipo(questao.getTipo());
		newQuestao.setVersion(questao.getVersion());
		
		if(Helper.isNotNull(questao.getAlternativas())) {
			newQuestao.setAlternativas(AlternativaBuilder
					.newInstance(questao.getAlternativas()).getEntityList());
		}
		
		return newQuestao;
	}	

}
