package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.Parametro;

public class ParametroBuilder extends GenericEntityBuilder<Parametro, GenericFilter> {

	public static ParametroBuilder newInstance(Parametro parametro) {
		return new ParametroBuilder(parametro);
	}
	
	public static ParametroBuilder newInstance(List<Parametro> parametros) {
		return new ParametroBuilder(parametros);
	}
	
	private ParametroBuilder(Parametro parametro) {
		super(parametro);
	}
	
	private ParametroBuilder(List<Parametro> parametros) {
		super(parametros);
	}

	@Override
	protected Parametro clone(Parametro parametro) {
		Parametro newParametro = new Parametro();
		
		newParametro.setId(parametro.getId());
		newParametro.setVersion(parametro.getVersion());
		
		if(parametro.getRegraPeriodico() != null) {
			newParametro.setRegraPeriodico(RegraAtendimentoBuilder
					.newInstance(parametro.getRegraPeriodico()).getEntity());
		}
		
		if(parametro.getAcolhimento() != null) {
			newParametro.setAcolhimento(EquipeBuilder
					.newInstance(parametro.getAcolhimento()).getEntity());
		}
		
		return newParametro;
	}	

}
