package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.PerguntaFichaColeta;

public class PerguntaFichaColetaDao extends GenericDao<PerguntaFichaColeta> {

	private static PerguntaFichaColetaDao instance;
	
	private PerguntaFichaColetaDao() {
		super();
	}
	
	public static PerguntaFichaColetaDao getInstance() {
		if(instance == null)
			instance = new PerguntaFichaColetaDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = pergunta -> {
			if(Helper.isNotNull(pergunta.getItens()))
				Hibernate.initialize(pergunta.getItens());
			if(Helper.isNotNull(pergunta.getEquipes()))
				Hibernate.initialize(pergunta.getEquipes());
			return pergunta;
		};
	}
	
	@Override
	public PerguntaFichaColeta getById(Object id) throws Exception {
		return super.getById(id,this.functionLoadAll);
	}
}
