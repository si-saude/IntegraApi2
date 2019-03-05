package br.com.saude.api.model.persistence;

import br.com.saude.api.generic.GenericDao;
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

	}
}
