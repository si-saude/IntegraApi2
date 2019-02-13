package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.RegraAtendimento;

public class RegraAtendimentoDao extends GenericDao<RegraAtendimento> {

	private static RegraAtendimentoDao instance;
	
	private RegraAtendimentoDao() {
		super();
	}
	
	public static RegraAtendimentoDao getInstance() {
		if(instance == null)
			instance = new RegraAtendimentoDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = regra -> {
			if(Helper.isNotNull(regra.getRegraAtendimentoEquipes())) {
				Hibernate.initialize(regra.getRegraAtendimentoEquipes());
			}
			return regra;
		};
	}
	
	@Override
	public RegraAtendimento getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
