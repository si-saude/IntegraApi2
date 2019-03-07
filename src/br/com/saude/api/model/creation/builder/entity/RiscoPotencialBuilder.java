package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.RiscoPotencialFilter;
import br.com.saude.api.model.entity.po.RiscoPotencial;

public class RiscoPotencialBuilder extends GenericEntityBuilder<RiscoPotencial,RiscoPotencialFilter> {
	
	public static RiscoPotencialBuilder newInstance(RiscoPotencial risco) {
		return new RiscoPotencialBuilder(risco);
	}
	
	public static RiscoPotencialBuilder newInstance(List<RiscoPotencial> riscos) {
		return new RiscoPotencialBuilder(riscos);
	}
	
	private RiscoPotencialBuilder(RiscoPotencial risco) {
		super(risco);
	}

	private RiscoPotencialBuilder(List<RiscoPotencial> riscos) {
		super(riscos);
	}

	@Override
	protected RiscoPotencial clone(RiscoPotencial risco) {
		RiscoPotencial newRiscoPotencial = new RiscoPotencial();
		
		newRiscoPotencial.setId(risco.getId());
		newRiscoPotencial.setVersion(risco.getVersion());
		newRiscoPotencial.setStatus(risco.getStatus());
		
		if(risco.getEmpregado() != null)
			newRiscoPotencial.setEmpregado(EmpregadoBuilder.newInstance(risco.getEmpregado()).getEntity());
		
		if(risco.getResponsavel() != null)
			newRiscoPotencial.setResponsavel(EquipeBuilder.newInstance(risco.getResponsavel()).getEntity());
		
		return newRiscoPotencial;
	}
	
	public RiscoPotencialBuilder loadRiscos() throws Exception {
		return (RiscoPotencialBuilder) this.loadProperty("riscos", risco -> {
			return RiscoEmpregadoBuilder.newInstance(risco.getRiscos()).getEntityList();
		});
	}
}
