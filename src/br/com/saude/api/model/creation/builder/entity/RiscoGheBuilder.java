package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.RiscoGheFilter;
import br.com.saude.api.model.entity.po.RiscoGhe;

public class RiscoGheBuilder extends GenericEntityBuilder<RiscoGhe, RiscoGheFilter> {

	public static RiscoGheBuilder newInstance(RiscoGhe riscoGhe) {
		return new RiscoGheBuilder(riscoGhe);
	}
	
	public static RiscoGheBuilder newInstance(List<RiscoGhe> riscoGhes) {
		return new RiscoGheBuilder(riscoGhes);
	}
	
	private RiscoGheBuilder(RiscoGhe riscoGhe) {
		super(riscoGhe);
	}
	
	private RiscoGheBuilder(List<RiscoGhe> riscoGhes) {
		super(riscoGhes);
	}

	@Override
	protected RiscoGhe clone(RiscoGhe riscoGhe) {
		RiscoGhe newRiscoGhe = new RiscoGhe();
		
		newRiscoGhe.setId(riscoGhe.getId());
		newRiscoGhe.setTitulo(riscoGhe.getTitulo());
		newRiscoGhe.setVersion(riscoGhe.getVersion());
		
		return newRiscoGhe;
	}	

}
