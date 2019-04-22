package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.filter.AtendimentoFilter;
import br.com.saude.api.model.entity.po.Atendimento;

public class AtendimentoBuilder extends GenericEntityBuilder<Atendimento, AtendimentoFilter> {

	public static AtendimentoBuilder newInstance(Atendimento atendimento) {
		return new AtendimentoBuilder(atendimento);
	}
	
	public static AtendimentoBuilder newInstance(List<Atendimento> atendimentos) {
		return new AtendimentoBuilder(atendimentos);
	}
	
	private AtendimentoBuilder(Atendimento atendimento) {
		super(atendimento);
	}
	
	private AtendimentoBuilder(List<Atendimento> atendimentos) {
		super(atendimentos);
	}

	@Override
	protected Atendimento clone(Atendimento atendimento) {
		Atendimento newAtendimento = new Atendimento();
		
		newAtendimento.setId(atendimento.getId());
		newAtendimento.setAcolhimento(atendimento.isAcolhimento());
		newAtendimento.setVersion(atendimento.getVersion());
		
		if(atendimento.getCheckin() != null) {
			newAtendimento.setCheckin(CheckinBuilder.newInstance(atendimento.getCheckin()).getEntity());
		}
		
		if(atendimento.getTarefa() != null) {
			newAtendimento.setTarefa(TarefaBuilder.newInstance(atendimento.getTarefa()).getEntity());
		}
		
		if(atendimento.getFila()!= null) {
			newAtendimento.setFila(FilaAtendimentoBuilder.newInstance(atendimento.getFila()).getEntity());
		}
		
		if(atendimento.getAvaliacaoFisica() != null) {
			newAtendimento.setAvaliacaoFisica(AvaliacaoFisicaBuilder.newInstance(atendimento.getAvaliacaoFisica()).getEntity());
		}
		
		if(Helper.isNotNull(atendimento.getTriagens())) {
			newAtendimento.setTriagens(TriagemBuilder.newInstance(
					atendimento.getTriagens()).getEntityList());
		}
		
		return newAtendimento;
	}	

}
