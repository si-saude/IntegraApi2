package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.Helper;
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
		newRiscoPotencial.setValor(risco.getValor());
		newRiscoPotencial.setStatus(risco.getStatus());
		newRiscoPotencial.setData(risco.getData());
		
		if(risco.getEmpregado() != null)
			newRiscoPotencial.setEmpregado(EmpregadoBuilder.newInstance(risco.getEmpregado()).getEntity());
		
		if(risco.getResponsavel() != null)
			newRiscoPotencial.setResponsavel(EquipeBuilder.newInstance(risco.getResponsavel()).getEntity());
		
		if(Helper.isNotNull(risco.getRiscos())) {
			newRiscoPotencial.setRiscos(RiscoEmpregadoBuilder.newInstance(
					risco.getRiscos()).getEntityList());
		}
		
		return newRiscoPotencial;
	}
	
	public RiscoPotencial getNewEntity() {
		return this.newEntity;
	}
}
