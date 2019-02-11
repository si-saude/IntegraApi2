package br.com.saude.api.model.persistence;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.GrupoPerguntaFichaColeta;

public class GrupoPerguntaFichaColetaDao extends GenericDao<GrupoPerguntaFichaColeta> {

	private static GrupoPerguntaFichaColetaDao instance;
	
	private GrupoPerguntaFichaColetaDao() {
		super();
	}
	
	public static GrupoPerguntaFichaColetaDao getInstance() {
		if(instance == null)
			instance = new GrupoPerguntaFichaColetaDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
}
