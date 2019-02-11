package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.TipoPerguntaFichaColetaBuilder;
import br.com.saude.api.model.creation.builder.example.TipoPerguntaFichaColetaExampleBuilder;
import br.com.saude.api.model.entity.filter.TipoPerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.TipoPerguntaFichaColeta;
import br.com.saude.api.model.persistence.TipoPerguntaFichaColetaDao;

public class TipoPerguntaFichaColetaBo extends GenericBo<TipoPerguntaFichaColeta, TipoPerguntaFichaColetaFilter, TipoPerguntaFichaColetaDao, TipoPerguntaFichaColetaBuilder, 
	TipoPerguntaFichaColetaExampleBuilder> {

	private static TipoPerguntaFichaColetaBo instance;
	
	private TipoPerguntaFichaColetaBo() {
		super();
	}
	
	public static TipoPerguntaFichaColetaBo getInstance() {
		if(instance == null)
			instance = new TipoPerguntaFichaColetaBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<TipoPerguntaFichaColeta> getList(TipoPerguntaFichaColetaFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
}
