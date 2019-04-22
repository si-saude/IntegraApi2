package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class TipoAtendimentoAvaliacaoFisica extends GenericConstant {

	private static TipoAtendimentoAvaliacaoFisica instance;
	
	private TipoAtendimentoAvaliacaoFisica() {
		
	}
	
	public static TipoAtendimentoAvaliacaoFisica getInstance() {
		if(instance==null)
			instance = new TipoAtendimentoAvaliacaoFisica();
		return instance;
	}
	
	public final String ORIENTADA 			= "ORIENTADA";
	public final String REALIZADA			= "REALIZADA";
}
