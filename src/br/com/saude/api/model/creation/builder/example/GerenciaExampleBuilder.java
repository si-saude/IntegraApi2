package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.GerenciaFilter;
import br.com.saude.api.model.entity.po.Gerencia;

public class GerenciaExampleBuilder extends GenericExampleBuilder<Gerencia, GerenciaFilter> {

	public static GerenciaExampleBuilder newInstance(GerenciaFilter filter) {
		return new GerenciaExampleBuilder(filter);
	}
	
	private GerenciaExampleBuilder(GerenciaFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addDescricao();
		addAusentePeriodico();
	}
	
	private void addDescricao() {
		this.ilike("descricao", this.filter.getDescricao() );
	}
	
	private void addAusentePeriodico() {
		this.entity.setAusentePeriodico(this.addBoolean("ausentePeriodico", this.filter.getAusentePeriodico()));
	}
}
