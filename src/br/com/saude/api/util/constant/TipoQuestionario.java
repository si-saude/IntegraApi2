package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class TipoQuestionario extends GenericConstant  {

	private static TipoQuestionario instance;
	
	private TipoQuestionario() {
		
	}
	
	public static TipoQuestionario getInstance() {
		if(instance == null)
			instance = new TipoQuestionario();
		return instance;
	}
	
	public static final String PESQUISA_SATISFACAO 				= "PESQUISA DE SATISFAÇÃO";
}
