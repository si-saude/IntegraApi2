package br.com.saude.api.model.persistence;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.TipoPerguntaFichaColeta;

public class TipoPerguntaFichaColetaDao extends GenericDao<TipoPerguntaFichaColeta> {

	private static TipoPerguntaFichaColetaDao instance;
	
	private TipoPerguntaFichaColetaDao() {
		super();
	}
	
	public static TipoPerguntaFichaColetaDao getInstance() {
		if(instance == null)
			instance = new TipoPerguntaFichaColetaDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
}
