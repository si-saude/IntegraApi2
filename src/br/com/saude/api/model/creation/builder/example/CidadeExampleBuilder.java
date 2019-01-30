package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.CidadeFilter;
import br.com.saude.api.model.entity.po.Cidade;

public class CidadeExampleBuilder extends GenericExampleBuilder<Cidade, CidadeFilter> {

	public static CidadeExampleBuilder newInstance(CidadeFilter filter) {
		return new CidadeExampleBuilder(filter);
	}
	
	private CidadeExampleBuilder(CidadeFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addUf();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addUf() {
		this.ilike("uf", this.filter.getUf());
	}
}
