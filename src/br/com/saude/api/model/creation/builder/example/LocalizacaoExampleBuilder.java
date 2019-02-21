package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.LocalizacaoFilter;
import br.com.saude.api.model.entity.po.Localizacao;

public class LocalizacaoExampleBuilder extends GenericExampleBuilder<Localizacao, LocalizacaoFilter> {

	public static LocalizacaoExampleBuilder newInstance(LocalizacaoFilter filter) {
		return new LocalizacaoExampleBuilder(filter);
	}
	
	private LocalizacaoExampleBuilder(LocalizacaoFilter filter) {
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
		this.addLeftJoinGenericFilter("base", this.filter.getBase(),
				BaseExampleBuilder.newInstance(this.filter.getBase()));
	}
}
