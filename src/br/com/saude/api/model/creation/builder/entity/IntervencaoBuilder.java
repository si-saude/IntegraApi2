package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.IntervencaoFilter;
import br.com.saude.api.model.entity.po.Intervencao;

public class IntervencaoBuilder extends GenericEntityBuilder<Intervencao, IntervencaoFilter> {

	public static IntervencaoBuilder newInstance(Intervencao intervencao) {
		return new IntervencaoBuilder(intervencao);
	}
	
	public static IntervencaoBuilder newInstance(List<Intervencao> intervencaos) {
		return new IntervencaoBuilder(intervencaos);
	}
	
	private IntervencaoBuilder(Intervencao intervencao) {
		super(intervencao);
	}
	
	private IntervencaoBuilder(List<Intervencao> intervencaos) {
		super(intervencaos);
	}

	@Override
	protected Intervencao clone(Intervencao intervencao) {
		Intervencao newIntervencao = new Intervencao();
		
		newIntervencao.setId(intervencao.getId());
		newIntervencao.setDescricao(intervencao.getDescricao());
		newIntervencao.setInativo(intervencao.isInativo());
		newIntervencao.setVersion(intervencao.getVersion());
		
		if(intervencao.getEquipe() != null)
			newIntervencao.setEquipe(EquipeBuilder.newInstance(intervencao.getEquipe()).getEntity());
		
		return newIntervencao;
	}	
}
