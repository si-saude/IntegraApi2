package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.AvaliacaoFisica;

public class AvaliacaoFisicaBuilder extends GenericEntityBuilder<AvaliacaoFisica, GenericFilter> {

	public static AvaliacaoFisicaBuilder newInstance(AvaliacaoFisica avaliacaoFisica) {
		return new AvaliacaoFisicaBuilder(avaliacaoFisica);
	}
	
	public static AvaliacaoFisicaBuilder newInstance(List<AvaliacaoFisica> avaliacoesFisicas) {
		return new AvaliacaoFisicaBuilder(avaliacoesFisicas);
	}
	
	private AvaliacaoFisicaBuilder(AvaliacaoFisica avaliacaoFisica) {
		super(avaliacaoFisica);
	}
	
	private AvaliacaoFisicaBuilder(List<AvaliacaoFisica> avaliacoesFisicas) {
		super(avaliacoesFisicas);
	}

	@Override
	protected AvaliacaoFisica clone(AvaliacaoFisica avaliacaoFisica) {
		AvaliacaoFisica newAvaliacaoFisica = new AvaliacaoFisica();
		
		newAvaliacaoFisica.setId(avaliacaoFisica.getId());
		newAvaliacaoFisica.setPratica(avaliacaoFisica.isPratica());
		newAvaliacaoFisica.setAcao(avaliacaoFisica.isAcao());
		newAvaliacaoFisica.setInteresse(avaliacaoFisica.isInteresse());
		newAvaliacaoFisica.setObservacoes(avaliacaoFisica.getObservacoes());
		newAvaliacaoFisica.setVersion(avaliacaoFisica.getVersion());
		
		if(Helper.isNotNull(avaliacaoFisica.getAtendimentoAtividadesFisicas())) {
			newAvaliacaoFisica.setAtendimentoAtividadesFisicas(AtendimentoAtividadeFisicaBuilder.newInstance(
					avaliacaoFisica.getAtendimentoAtividadesFisicas()).getEntityList());
		}
		
		return newAvaliacaoFisica;
	}	

}
