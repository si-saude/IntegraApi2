package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.CurriculoCurso;

public class CurriculoCursoBuilder extends GenericEntityBuilder<CurriculoCurso, GenericFilter> {

	public static CurriculoCursoBuilder newInstance(CurriculoCurso curriculoCurso) {
		return new CurriculoCursoBuilder(curriculoCurso);
	}
	
	public static CurriculoCursoBuilder newInstance(List<CurriculoCurso> curriculoCursos) {
		return new CurriculoCursoBuilder(curriculoCursos);
	}
	
	private CurriculoCursoBuilder(CurriculoCurso curriculoCurso) {
		super(curriculoCurso);
	}
	
	private CurriculoCursoBuilder(List<CurriculoCurso> curriculoCursos) {
		super(curriculoCursos);
	}

	@Override
	protected CurriculoCurso clone(CurriculoCurso curriculoCurso) {
		CurriculoCurso newCurriculoCurso = new CurriculoCurso();
		
		newCurriculoCurso.setId(curriculoCurso.getId());
		newCurriculoCurso.setData(curriculoCurso.getData());
		newCurriculoCurso.setVersion(curriculoCurso.getVersion());
		
		if(curriculoCurso.getCurso() != null) {
			newCurriculoCurso.setCurso(CursoBuilder.newInstance(curriculoCurso.getCurso()).getEntity());
		}
		
		return newCurriculoCurso;
	}	

}
