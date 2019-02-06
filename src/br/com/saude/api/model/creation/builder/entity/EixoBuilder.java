package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.EixoFilter;
import br.com.saude.api.model.entity.po.Eixo;

public class EixoBuilder extends GenericEntityBuilder<Eixo, EixoFilter> {

	public static EixoBuilder newInstance(Eixo eixo) {
		return new EixoBuilder(eixo);
	}
	
	public static EixoBuilder newInstance(List<Eixo> eixos) {
		return new EixoBuilder(eixos);
	}
	
	private EixoBuilder(Eixo eixo) {
		super(eixo);
	}
	
	private EixoBuilder(List<Eixo> eixos) {
		super(eixos);
	}

	@Override
	protected Eixo clone(Eixo eixo) {
		Eixo newEixo = new Eixo();
		
		newEixo.setId(eixo.getId());
		newEixo.setTitulo(eixo.getTitulo());
		newEixo.setVersion(eixo.getVersion());
		
		if(eixo.getEquipe() != null)
			newEixo.setEquipe(EquipeBuilder.newInstance(eixo.getEquipe()).getEntity());
		
		return newEixo;
	}	
}
