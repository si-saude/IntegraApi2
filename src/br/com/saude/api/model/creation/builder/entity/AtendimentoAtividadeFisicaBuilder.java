package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.AtendimentoAtividadeFisica;

public class AtendimentoAtividadeFisicaBuilder extends GenericEntityBuilder<AtendimentoAtividadeFisica, GenericFilter> {

	public static AtendimentoAtividadeFisicaBuilder newInstance(AtendimentoAtividadeFisica atendimentoAtividadeFisica) {
		return new AtendimentoAtividadeFisicaBuilder(atendimentoAtividadeFisica);
	}
	
	public static AtendimentoAtividadeFisicaBuilder newInstance(List<AtendimentoAtividadeFisica> atendimentoAtividadesFisicas) {
		return new AtendimentoAtividadeFisicaBuilder(atendimentoAtividadesFisicas);
	}
	
	private AtendimentoAtividadeFisicaBuilder(AtendimentoAtividadeFisica atendimentoAtividadeFisica) {
		super(atendimentoAtividadeFisica);
	}
	
	private AtendimentoAtividadeFisicaBuilder(List<AtendimentoAtividadeFisica> atendimentoAtividadesFisicas) {
		super(atendimentoAtividadesFisicas);
	}

	@Override
	protected AtendimentoAtividadeFisica clone(AtendimentoAtividadeFisica atendimentoAtividadeFisica) {
		AtendimentoAtividadeFisica newAtendimentoAtividadeFisica = new AtendimentoAtividadeFisica();
		
		newAtendimentoAtividadeFisica.setId(atendimentoAtividadeFisica.getId());
		
		newAtendimentoAtividadeFisica.setDomingo(atendimentoAtividadeFisica.isDomingo());
		newAtendimentoAtividadeFisica.setSegunda(atendimentoAtividadeFisica.isSegunda());
		newAtendimentoAtividadeFisica.setTerca(atendimentoAtividadeFisica.isTerca());
		newAtendimentoAtividadeFisica.setQuarta(atendimentoAtividadeFisica.isQuarta());
		newAtendimentoAtividadeFisica.setQuinta(atendimentoAtividadeFisica.isQuinta());
		newAtendimentoAtividadeFisica.setSexta(atendimentoAtividadeFisica.isSexta());
		newAtendimentoAtividadeFisica.setSabado(atendimentoAtividadeFisica.isSabado());
		
		newAtendimentoAtividadeFisica.setMinutos(atendimentoAtividadeFisica.getMinutos());
		newAtendimentoAtividadeFisica.setTotal(atendimentoAtividadeFisica.getTotal());
		newAtendimentoAtividadeFisica.setClassificacao(atendimentoAtividadeFisica.getClassificacao());
		newAtendimentoAtividadeFisica.setTipo(atendimentoAtividadeFisica.getTipo());
		newAtendimentoAtividadeFisica.setObservacao(atendimentoAtividadeFisica.getObservacao());
		newAtendimentoAtividadeFisica.setMinutos(atendimentoAtividadeFisica.getMinutos());
		newAtendimentoAtividadeFisica.setVersion(atendimentoAtividadeFisica.getVersion());
		
		if(atendimentoAtividadeFisica.getAtividade() != null)
			newAtendimentoAtividadeFisica.setAtividade(AtividadeFisicaBuilder.newInstance(atendimentoAtividadeFisica.getAtividade()).getEntity());
		
		return newAtendimentoAtividadeFisica;
	}	
}
