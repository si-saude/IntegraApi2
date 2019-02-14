package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.TipoGrupoMonitoramentoFilter;
import br.com.saude.api.model.entity.po.TipoGrupoMonitoramento;

public class TipoGrupoMonitoramentoBuilder extends GenericEntityBuilder<TipoGrupoMonitoramento, TipoGrupoMonitoramentoFilter> {

	public static TipoGrupoMonitoramentoBuilder newInstance(TipoGrupoMonitoramento tipoGrupoMonitoramento) {
		return new TipoGrupoMonitoramentoBuilder(tipoGrupoMonitoramento);
	}
	
	public static TipoGrupoMonitoramentoBuilder newInstance(List<TipoGrupoMonitoramento> tiposGrupoMonitoramento) {
		return new TipoGrupoMonitoramentoBuilder(tiposGrupoMonitoramento);
	}
	
	private TipoGrupoMonitoramentoBuilder(TipoGrupoMonitoramento tipoGrupoMonitoramento) {
		super(tipoGrupoMonitoramento);
	}
	
	private TipoGrupoMonitoramentoBuilder(List<TipoGrupoMonitoramento> tiposGrupoMonitoramento) {
		super(tiposGrupoMonitoramento);
	}

	@Override
	protected TipoGrupoMonitoramento clone(TipoGrupoMonitoramento tipoGrupoMonitoramento) {
		TipoGrupoMonitoramento newTipoGrupoMonitoramento = new TipoGrupoMonitoramento();
		
		newTipoGrupoMonitoramento.setId(tipoGrupoMonitoramento.getId());
		newTipoGrupoMonitoramento.setNome(tipoGrupoMonitoramento.getNome());
		newTipoGrupoMonitoramento.setDescricao(tipoGrupoMonitoramento.getDescricao());
		newTipoGrupoMonitoramento.setVersion(tipoGrupoMonitoramento.getVersion());
		
		return newTipoGrupoMonitoramento;
	}	

}
