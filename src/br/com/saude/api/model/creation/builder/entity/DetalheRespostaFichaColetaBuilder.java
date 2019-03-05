package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.DetalheRespostaFichaColeta;

public class DetalheRespostaFichaColetaBuilder 
	extends GenericEntityBuilder<DetalheRespostaFichaColeta, GenericFilter> {

	public static DetalheRespostaFichaColetaBuilder newInstance(DetalheRespostaFichaColeta detalhe) {
		return new DetalheRespostaFichaColetaBuilder(detalhe);
	}
	
	public static DetalheRespostaFichaColetaBuilder newInstance(List<DetalheRespostaFichaColeta> detalhes) {
		return new DetalheRespostaFichaColetaBuilder(detalhes);
	}
	
	private DetalheRespostaFichaColetaBuilder(DetalheRespostaFichaColeta detalhe) {
		super(detalhe);
	}
	
	private DetalheRespostaFichaColetaBuilder(List<DetalheRespostaFichaColeta> detalhes) {
		super(detalhes);
	}

	@Override
	protected DetalheRespostaFichaColeta clone(DetalheRespostaFichaColeta detalhe) {
		DetalheRespostaFichaColeta newDetalheRespostaFichaColeta = new DetalheRespostaFichaColeta();
		
		newDetalheRespostaFichaColeta.setId(detalhe.getId());
		newDetalheRespostaFichaColeta.setConteudo(detalhe.getConteudo());
		newDetalheRespostaFichaColeta.setOrdem(detalhe.getOrdem());
		newDetalheRespostaFichaColeta.setVersion(detalhe.getVersion());
		
		return newDetalheRespostaFichaColeta;
	}	
}
