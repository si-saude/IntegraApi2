package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.AvaliacaoAtendimento;

public class AvaliacaoAtendimentoDao extends GenericDao<AvaliacaoAtendimento> {

	private static AvaliacaoAtendimentoDao instance;
	
	private AvaliacaoAtendimentoDao() {
		super();
	}
	
	public static AvaliacaoAtendimentoDao getInstance() {
		if(instance == null)
			instance = new AvaliacaoAtendimentoDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = avaliacao -> {
			if(Helper.isNotNull(avaliacao.getRespostas())) {
				Hibernate.initialize(avaliacao.getRespostas());
			}
			return avaliacao;
		};
	}
	
	@Override
	public AvaliacaoAtendimento getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
