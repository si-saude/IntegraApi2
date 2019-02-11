package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.GrupoPerguntaFichaColetaBuilder;
import br.com.saude.api.model.creation.builder.example.GrupoPerguntaFichaColetaExampleBuilder;
import br.com.saude.api.model.entity.filter.GrupoPerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.GrupoPerguntaFichaColeta;
import br.com.saude.api.model.persistence.GrupoPerguntaFichaColetaDao;

public class GrupoPerguntaFichaColetaBo extends GenericBo<GrupoPerguntaFichaColeta, GrupoPerguntaFichaColetaFilter, GrupoPerguntaFichaColetaDao, GrupoPerguntaFichaColetaBuilder, 
	GrupoPerguntaFichaColetaExampleBuilder> {

	private static GrupoPerguntaFichaColetaBo instance;
	
	private GrupoPerguntaFichaColetaBo() {
		super();
	}
	
	public static GrupoPerguntaFichaColetaBo getInstance() {
		if(instance == null)
			instance = new GrupoPerguntaFichaColetaBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<GrupoPerguntaFichaColeta> getList(GrupoPerguntaFichaColetaFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
}
