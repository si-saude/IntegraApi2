package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Curriculo;

public class CurriculoBuilder extends GenericEntityBuilder<Curriculo, GenericFilter> {

	public static CurriculoBuilder newInstance(Curriculo curriculo) {
		return new CurriculoBuilder(curriculo);
	}
	
	public static CurriculoBuilder newInstance(List<Curriculo> curriculos) {
		return new CurriculoBuilder(curriculos);
	}
	
	private CurriculoBuilder(Curriculo curriculo) {
		super(curriculo);
	}
	
	private CurriculoBuilder(List<Curriculo> curriculos) {
		super(curriculos);
	}

	@Override
	protected Curriculo clone(Curriculo curriculo) {
		Curriculo newCurriculo = new Curriculo();
		
		newCurriculo.setId(curriculo.getId());
		newCurriculo.setHistorico(curriculo.getHistorico());
		newCurriculo.setFormacao(curriculo.getFormacao());
		newCurriculo.setAtuacao(curriculo.getAtuacao());
		newCurriculo.setVersion(curriculo.getVersion());
		
		if(Helper.isNotNull(curriculo.getCurriculoCursos())) {
			newCurriculo.setCurriculoCursos(CurriculoCursoBuilder
					.newInstance(curriculo.getCurriculoCursos()).getEntityList());
		}
		
		return newCurriculo;
	}	

}
