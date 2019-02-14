package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.GrupoMonitoramentoFilter;
import br.com.saude.api.model.entity.po.GrupoMonitoramento;

public class GrupoMonitoramentoBuilder extends GenericEntityBuilder<GrupoMonitoramento, GrupoMonitoramentoFilter> {

	public static GrupoMonitoramentoBuilder newInstance(GrupoMonitoramento grupoMonitoramento) {
		return new GrupoMonitoramentoBuilder(grupoMonitoramento);
	}
	
	public static GrupoMonitoramentoBuilder newInstance(List<GrupoMonitoramento> gruposMonitoramento) {
		return new GrupoMonitoramentoBuilder(gruposMonitoramento);
	}
	
	private GrupoMonitoramentoBuilder(GrupoMonitoramento grupoMonitoramento) {
		super(grupoMonitoramento);
	}
	
	private GrupoMonitoramentoBuilder(List<GrupoMonitoramento> gruposMonitoramento) {
		super(gruposMonitoramento);
	}

	@Override
	protected GrupoMonitoramento clone(GrupoMonitoramento grupoMonitoramento) {
		GrupoMonitoramento newGrupoMonitoramento = new GrupoMonitoramento();
		
		newGrupoMonitoramento.setId(grupoMonitoramento.getId());
		newGrupoMonitoramento.setNome(grupoMonitoramento.getNome());
		newGrupoMonitoramento.setTipoGrupoMonitoramento(grupoMonitoramento.getTipoGrupoMonitoramento());
		newGrupoMonitoramento.setRecorrente(grupoMonitoramento.isRecorrente());
		newGrupoMonitoramento.setRelatorio(grupoMonitoramento.isRelatorio());
		newGrupoMonitoramento.setAuditoriaAso(grupoMonitoramento.isAuditoriaAso());
		newGrupoMonitoramento.setVersion(grupoMonitoramento.getVersion());
		
		return newGrupoMonitoramento;
	}	
	
	public GrupoMonitoramentoBuilder loadTipoGrupoMonitoramento() throws Exception {
		return (GrupoMonitoramentoBuilder) this.loadProperty("tipoGrupoMonitoramento", grupoMonitoramento -> {
			return TipoGrupoMonitoramentoBuilder.newInstance(grupoMonitoramento.getTipoGrupoMonitoramento()).getEntity();
		});
	}
	
	public GrupoMonitoramentoBuilder loadAvaliacoes() throws Exception {
		return (GrupoMonitoramentoBuilder) this.loadProperty("avaliacoes", grupoMonitoramento -> {
			return AvaliacaoBuilder.newInstance(grupoMonitoramento.getAvaliacoes()).getEntityList();
		});
	}
}
