package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.GrupoMonitoramentoBuilder;
import br.com.saude.api.model.creation.builder.example.GrupoMonitoramentoExampleBuilder;
import br.com.saude.api.model.entity.filter.GrupoMonitoramentoFilter;
import br.com.saude.api.model.entity.po.GrupoMonitoramento;
import br.com.saude.api.model.persistence.GrupoMonitoramentoDao;

public class GrupoMonitoramentoBo extends GenericBo<GrupoMonitoramento, GrupoMonitoramentoFilter, GrupoMonitoramentoDao, GrupoMonitoramentoBuilder, 
	GrupoMonitoramentoExampleBuilder> {

	private static GrupoMonitoramentoBo instance;
	
	private GrupoMonitoramentoBo() {
		super();
	}
	
	public static GrupoMonitoramentoBo getInstance() {
		if(instance == null)
			instance = new GrupoMonitoramentoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadTipoGrupoMonitoramento().loadAvaliacoes();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	@Override
	public PagedList<GrupoMonitoramento> getList(GrupoMonitoramentoFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
	
	@Override
	public GrupoMonitoramento getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
	
	@Override
	public GrupoMonitoramento save(GrupoMonitoramento grupoMonitoramento) throws Exception {
		if(Helper.isNotNull(grupoMonitoramento.getAvaliacoes())) {
			grupoMonitoramento.getAvaliacoes().forEach(i->i.setGrupoMonitoramento(grupoMonitoramento));
		}
		return super.save(grupoMonitoramento);
	}
}
