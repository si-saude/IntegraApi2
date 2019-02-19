package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.GheFilter;
import br.com.saude.api.model.entity.po.Ghe;

public class GheExampleBuilder extends GenericExampleBuilder<Ghe, GheFilter> {

	public static GheExampleBuilder newInstance(GheFilter filter) {
		return new GheExampleBuilder(filter);
	}
	
	private GheExampleBuilder(GheFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addCodigo();
		addDescricao();
		addDataCriacao();
		addDataDesativacao();
		addRiscoGhe();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addCodigo() {
		this.ilike("codigo", this.filter.getCodigo());
	}
	
	private void addDescricao() {
		this.ilike("descricao", this.filter.getDescricao());
	}
	
	private void addDataCriacao() {
		this.addData("dataCriacao", this.filter.getDataCriacao());
	}
	
	private void addDataDesativacao() {
		this.addData("dataDesativacao", this.filter.getDataDesativacao());
	}
	
	private void addRiscoGhe() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("risco", this.filter.getRisco(),
				RiscoGheExampleBuilder.newInstance(this.filter.getRisco()));
	}
}
