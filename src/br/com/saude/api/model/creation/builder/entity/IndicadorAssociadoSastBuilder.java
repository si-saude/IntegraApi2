package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.IndicadorAssociadoSast;

public class IndicadorAssociadoSastBuilder extends GenericEntityBuilder<IndicadorAssociadoSast, GenericFilter> {

	public static IndicadorAssociadoSastBuilder newInstance(IndicadorAssociadoSast indicador) {
		return new IndicadorAssociadoSastBuilder(indicador);
	}
	
	public static IndicadorAssociadoSastBuilder newInstance(List<IndicadorAssociadoSast> indicadors) {
		return new IndicadorAssociadoSastBuilder(indicadors);
	}
	
	private IndicadorAssociadoSastBuilder(IndicadorAssociadoSast indicador) {
		super(indicador);
	}
	
	private IndicadorAssociadoSastBuilder(List<IndicadorAssociadoSast> indicadors) {
		super(indicadors);
	}

	@Override
	protected IndicadorAssociadoSast clone(IndicadorAssociadoSast indicador) {
		IndicadorAssociadoSast newIndicadorAssociadoSast = new IndicadorAssociadoSast();
		
		newIndicadorAssociadoSast.setId(indicador.getId());
		newIndicadorAssociadoSast.setCodigo(indicador.getCodigo());
		newIndicadorAssociadoSast.setVersion(indicador.getVersion());
		
		return newIndicadorAssociadoSast;
	}	

}
