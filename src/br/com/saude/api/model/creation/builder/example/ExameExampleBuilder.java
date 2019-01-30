package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.ExameFilter;
import br.com.saude.api.model.entity.po.Exame;

public class ExameExampleBuilder extends GenericExampleBuilder<Exame, ExameFilter> {

	public static ExameExampleBuilder newInstance(ExameFilter filter) {
		return new ExameExampleBuilder(filter);
	}
	
	private ExameExampleBuilder(ExameFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addCodigo();
		addDescricao();
	}
	
	private void addCodigo() {
		this.ilike("codigo", this.filter.getCodigo());
	}
	
	private void addDescricao() {
		this.ilike("descricao", this.filter.getDescricao());
	}
}
