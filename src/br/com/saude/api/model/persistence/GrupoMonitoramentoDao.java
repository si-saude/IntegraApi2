package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;
import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.GrupoMonitoramento;

public class GrupoMonitoramentoDao extends GenericDao<GrupoMonitoramento> {
	
	private static GrupoMonitoramentoDao instance;
	
	private GrupoMonitoramentoDao() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = grupoMonitoramento -> {
			if(grupoMonitoramento.getTipoGrupoMonitoramento() != null)
				Hibernate.initialize(grupoMonitoramento.getTipoGrupoMonitoramento());
			
			if(Helper.isNotNull(grupoMonitoramento.getAvaliacoes()))
				Hibernate.initialize(grupoMonitoramento.getAvaliacoes());
			
			return grupoMonitoramento;
		};
	}
	
	public static GrupoMonitoramentoDao getInstance() {
		if(instance == null)
			instance = new GrupoMonitoramentoDao();
		return instance;
	}
	
	@Override
	public GrupoMonitoramento getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
