package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class TipoQuestao extends GenericConstant  {

	private static TipoQuestao instance;
	
	private TipoQuestao() {
		
	}
	
	public static TipoQuestao getInstance() {
		if(instance == null)
			instance = new TipoQuestao();
		return instance;
	}
	
	public static final String OBJETIVA 				= "OBJETIVA";
	public static final String OBJETIVA_COM_OBSERVAÇÃO	= "OBJETIVA COM OBSERVAÇÃO";
	public static final String SUBJETIVA 				= "SUBJETIVA";
}
