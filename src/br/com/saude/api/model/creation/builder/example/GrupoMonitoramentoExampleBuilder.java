package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.GrupoMonitoramentoFilter;
import br.com.saude.api.model.entity.po.GrupoMonitoramento;

public class GrupoMonitoramentoExampleBuilder extends GenericExampleBuilder<GrupoMonitoramento, GrupoMonitoramentoFilter> {

	public static GrupoMonitoramentoExampleBuilder newInstance(GrupoMonitoramentoFilter filter) {
		return new GrupoMonitoramentoExampleBuilder(filter);
	}
	
	private GrupoMonitoramentoExampleBuilder(GrupoMonitoramentoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addRecorrente();
		addRelatorio();
		addAuditoriaAso();
		addTipoGrupoMonitoramento();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addRecorrente() {
		this.entity.setRecorrente(this.addBoolean("recorrente", this.filter.getRecorrente()));
	}
	
	private void addRelatorio() {
		this.entity.setRelatorio(this.addBoolean("relatorio", this.filter.getRelatorio()));
	}
	
	private void addAuditoriaAso() {
		this.entity.setAuditoriaAso(this.addBoolean("auditoriaAso", this.filter.getAuditoriaAso()));
	}
	
	private void addTipoGrupoMonitoramento() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("tipoGrupoMonitoramento", this.filter.getTipoGrupoMonitoramento(),
				TipoGrupoMonitoramentoExampleBuilder.newInstance(this.filter.getTipoGrupoMonitoramento()));
	}
}
