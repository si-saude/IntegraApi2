package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.CursoFilter;
import br.com.saude.api.model.entity.po.Curso;

public class CursoExampleBuilder extends GenericExampleBuilder<Curso, CursoFilter> {

	public static CursoExampleBuilder newInstance(CursoFilter filter) {
		return new CursoExampleBuilder(filter);
	}
	
	private CursoExampleBuilder(CursoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addDescricao();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addDescricao() {
		this.ilike("descricao", this.filter.getDescricao());
	}
}
