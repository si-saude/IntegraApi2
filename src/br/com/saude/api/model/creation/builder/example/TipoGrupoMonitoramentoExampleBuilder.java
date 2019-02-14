package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.TipoGrupoMonitoramentoFilter;
import br.com.saude.api.model.entity.po.TipoGrupoMonitoramento;

public class TipoGrupoMonitoramentoExampleBuilder extends GenericExampleBuilder<TipoGrupoMonitoramento, TipoGrupoMonitoramentoFilter> {

	public static TipoGrupoMonitoramentoExampleBuilder newInstance(TipoGrupoMonitoramentoFilter filter) {
		return new TipoGrupoMonitoramentoExampleBuilder(filter);
	}
	
	private TipoGrupoMonitoramentoExampleBuilder(TipoGrupoMonitoramentoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
}
