package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.RequisitoAsoFilter;
import br.com.saude.api.model.entity.po.RequisitoAso;

public class RequisitoAsoBuilder extends GenericEntityBuilder<RequisitoAso, RequisitoAsoFilter> {

	public static RequisitoAsoBuilder newInstance(RequisitoAso requisitoAso) {
		return new RequisitoAsoBuilder(requisitoAso);
	}
	
	public static RequisitoAsoBuilder newInstance(List<RequisitoAso> requisitosAso) {
		return new RequisitoAsoBuilder(requisitosAso);
	}
	
	private RequisitoAsoBuilder(RequisitoAso requisitoAso) {
		super(requisitoAso);
	}
	
	private RequisitoAsoBuilder(List<RequisitoAso> requisitosAso) {
		super(requisitosAso);
	}

	@Override
	protected RequisitoAso clone(RequisitoAso requisitoAso) {
		RequisitoAso newRequisitoAso = new RequisitoAso();
		
		newRequisitoAso.setId(requisitoAso.getId());
		newRequisitoAso.setConteudo(requisitoAso.getConteudo());
		newRequisitoAso.setVersion(requisitoAso.getVersion());
		
		return newRequisitoAso;
	}	

}
