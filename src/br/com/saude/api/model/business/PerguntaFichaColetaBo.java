package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.PerguntaFichaColetaBuilder;
import br.com.saude.api.model.creation.builder.example.PerguntaFichaColetaExampleBuilder;
import br.com.saude.api.model.entity.filter.PerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.PerguntaFichaColeta;
import br.com.saude.api.model.persistence.PerguntaFichaColetaDao;

public class PerguntaFichaColetaBo extends GenericBo<PerguntaFichaColeta, PerguntaFichaColetaFilter, PerguntaFichaColetaDao, 
										PerguntaFichaColetaBuilder, PerguntaFichaColetaExampleBuilder>{
	
	private static PerguntaFichaColetaBo instance;
	
	private PerguntaFichaColetaBo() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {

	}
	
	public static PerguntaFichaColetaBo getInstance() {
		if(instance == null)
			instance = new PerguntaFichaColetaBo();
		return instance;
	}
	
	@Override
	public PerguntaFichaColeta save(PerguntaFichaColeta pergunta) throws Exception {
		if(Helper.isNotNull(pergunta.getItens())) {
			pergunta.getItens().forEach(i -> i.setPergunta(pergunta));
		}
		return super.save(pergunta);
	}
	
	@Override
	public PagedList<PerguntaFichaColeta> getList(PerguntaFichaColetaFilter filter) throws Exception {
		return super.getOrderedList(filter,"codigo");
	}
}
