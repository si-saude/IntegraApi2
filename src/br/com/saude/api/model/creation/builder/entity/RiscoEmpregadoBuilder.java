package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.RiscoEmpregado;

public class RiscoEmpregadoBuilder extends GenericEntityBuilder<RiscoEmpregado, GenericFilter> {

	public static RiscoEmpregadoBuilder newInstance(RiscoEmpregado risco) {
		return new RiscoEmpregadoBuilder(risco);
	}
	
	public static RiscoEmpregadoBuilder newInstance(List<RiscoEmpregado> riscos) {
		return new RiscoEmpregadoBuilder(riscos);
	}
	
	private RiscoEmpregadoBuilder(RiscoEmpregado risco) {
		super(risco);
	}
	
	private RiscoEmpregadoBuilder(List<RiscoEmpregado> riscos) {
		super(riscos);
	}

	@Override
	protected RiscoEmpregado clone(RiscoEmpregado risco) {
		RiscoEmpregado newRiscoEmpregado = new RiscoEmpregado();
		
		newRiscoEmpregado.setId(risco.getId());
		newRiscoEmpregado.setStatus(risco.getStatus());
		newRiscoEmpregado.setData(risco.getData());
		newRiscoEmpregado.setValor(risco.getValor());
		newRiscoEmpregado.setVersion(risco.getVersion());
		
		if(risco.getEquipe() != null) {
			newRiscoEmpregado.setEquipe(EquipeBuilder.newInstance(risco.getEquipe()).getEntity());
		}
		
		return newRiscoEmpregado;
	}	

}
