package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.Dependencia;

public class DependenciaBuilder extends GenericEntityBuilder<Dependencia, GenericFilter> {

	public static DependenciaBuilder newInstance(Dependencia dependencia) {
		return new DependenciaBuilder(dependencia);
	}
	
	public static DependenciaBuilder newInstance(List<Dependencia> dependencias) {
		return new DependenciaBuilder(dependencias);
	}
	
	private DependenciaBuilder(Dependencia dependencia) {
		super(dependencia);
	}
	
	private DependenciaBuilder(List<Dependencia> dependencias) {
		super(dependencias);
	}

	@Override
	protected Dependencia clone(Dependencia dependencia) {
		Dependencia newDependencia = new Dependencia();
		
		newDependencia.setId(dependencia.getId());
		newDependencia.setVersion(dependencia.getVersion());
		if(dependencia.getEquipe() != null) {
			newDependencia.setEquipe(EquipeBuilder.newInstance(dependencia.getEquipe()).getEntity());
		}
		
		return newDependencia;
	}	

}
