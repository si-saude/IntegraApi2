package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.ImovelFilter;
import br.com.saude.api.model.entity.po.Imovel;

public class ImovelExampleBuilder extends GenericExampleBuilder<Imovel, ImovelFilter> {

	public static ImovelExampleBuilder newInstance(ImovelFilter filter) {
		return new ImovelExampleBuilder(filter);
	}
	
	private ImovelExampleBuilder(ImovelFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addBase();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	
	private void addBase() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("base", this.filter.getBase(),
				BaseExampleBuilder.newInstance(this.filter.getBase()));
	}
}
