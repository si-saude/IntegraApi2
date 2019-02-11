package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.TipoPerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.TipoPerguntaFichaColeta;

public class TipoPerguntaFichaColetaBuilder extends GenericEntityBuilder<TipoPerguntaFichaColeta, TipoPerguntaFichaColetaFilter> {

	public static TipoPerguntaFichaColetaBuilder newInstance(TipoPerguntaFichaColeta tipo) {
		return new TipoPerguntaFichaColetaBuilder(tipo);
	}
	
	public static TipoPerguntaFichaColetaBuilder newInstance(List<TipoPerguntaFichaColeta> tipos) {
		return new TipoPerguntaFichaColetaBuilder(tipos);
	}
	
	private TipoPerguntaFichaColetaBuilder(TipoPerguntaFichaColeta tipo) {
		super(tipo);
	}
	
	private TipoPerguntaFichaColetaBuilder(List<TipoPerguntaFichaColeta> tipos) {
		super(tipos);
	}

	@Override
	protected TipoPerguntaFichaColeta clone(TipoPerguntaFichaColeta tipo) {
		TipoPerguntaFichaColeta newTipoPerguntaFichaColeta = new TipoPerguntaFichaColeta();
		
		newTipoPerguntaFichaColeta.setId(tipo.getId());
		newTipoPerguntaFichaColeta.setNome(tipo.getNome());
		newTipoPerguntaFichaColeta.setVersion(tipo.getVersion());
		
		return newTipoPerguntaFichaColeta;
	}	

}
