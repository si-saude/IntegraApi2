package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.IndicadorSastFilter;
import br.com.saude.api.model.entity.po.IndicadorSast;

public class IndicadorSastExampleBuilder extends GenericExampleBuilder<IndicadorSast, IndicadorSastFilter> {

	public static IndicadorSastExampleBuilder newInstance(IndicadorSastFilter filter) {
		return new IndicadorSastExampleBuilder(filter);
	}
	
	private IndicadorSastExampleBuilder(IndicadorSastFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addCodigo();
		addNome();
		addAusenteCalculoInterdisciplinar();
		addInativo();
		addObrigatorio();
		addEquipe();
	}
	
	private void addCodigo() {
		this.ilike("codigo", this.filter.getCodigo());
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addAusenteCalculoInterdisciplinar() {
		this.addBoolean("cusenteCalculoInterdisciplinar", this.filter.getAusenteCalculoInterdisciplinar());
	}
	
	private void addInativo() {
		this.addBoolean("inativo", this.filter.getInativo());
	}
	
	private void addObrigatorio() {
		this.addBoolean("obrigatorio", this.filter.getObrigatorio());
	}
	
	private void addEquipe() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("equipe", this.filter.getEquipe(),
				EquipeExampleBuilder.newInstance(this.filter.getEquipe()));
	}
}
