package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.RegraAtendimentoEquipe;

public class RegraAtendimentoEquipeBuilder extends GenericEntityBuilder<RegraAtendimentoEquipe, GenericFilter> {

	public static RegraAtendimentoEquipeBuilder newInstance(RegraAtendimentoEquipe regra) {
		return new RegraAtendimentoEquipeBuilder(regra);
	}
	
	public static RegraAtendimentoEquipeBuilder newInstance(List<RegraAtendimentoEquipe> regras) {
		return new RegraAtendimentoEquipeBuilder(regras);
	}
	
	private RegraAtendimentoEquipeBuilder(RegraAtendimentoEquipe regra) {
		super(regra);
	}
	
	private RegraAtendimentoEquipeBuilder(List<RegraAtendimentoEquipe> regras) {
		super(regras);
	}

	@Override
	protected RegraAtendimentoEquipe clone(RegraAtendimentoEquipe regra) {
		RegraAtendimentoEquipe newRegraAtendimentoEquipe = new RegraAtendimentoEquipe();
		
		newRegraAtendimentoEquipe.setId(regra.getId());
		newRegraAtendimentoEquipe.setAcolhimento(regra.isAcolhimento());
		newRegraAtendimentoEquipe.setOrdem(regra.getOrdem());
		newRegraAtendimentoEquipe.setVersion(regra.getVersion());
		if(regra.getEquipe() != null) {
			newRegraAtendimentoEquipe.setEquipe(EquipeBuilder
					.newInstance(regra.getEquipe()).getEntity());
		}
		if(Helper.isNotNull(regra.getDependencias())) {
			newRegraAtendimentoEquipe.setDependencias(
					DependenciaBuilder.newInstance(regra.getDependencias()).getEntityList());
		}
		
		return newRegraAtendimentoEquipe;
	}	
}
