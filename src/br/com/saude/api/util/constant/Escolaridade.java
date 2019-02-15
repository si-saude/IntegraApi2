package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class Escolaridade extends GenericConstant  {
	
	private static Escolaridade instance;
	
	private Escolaridade() {
		
	}
	
	public static Escolaridade getInstance() {
		if(instance==null)
			instance = new Escolaridade();
		return instance;
	}
	
	public final String FUNDAMENTAL_INCOMPLETO 				= "01 - FUNDAMENTAL - INCOMPLETO";
	public final String FUNDAMENTAL_COMPLETO 				= "02 - FUNDAMENTAL - COMPLETO";
	public final String MEDIO_INCOMPLETO 				= "03 - M�DIO - INCOMPLETO";
	public final String MEDIO_COMPLETO 				= "04 - M�DIO - COMPLETO";
	public final String SUPERIOR_INCOMPLETO 				= "05 - SUPERIOR - INCOMPLETO";
	public final String SUPERIOR_COMPLETO 				= "06 - SUPERIOR - COMPLETO";
	public final String POS_GRADUACAO_LATO_SENSO_INCOMPLETO 				= "07 - P�S GRADUA��O (LATO SENSO) - INCOMPLETO";
	public final String POS_GRADUACAO_LATO_SENSO_COMPLETO 				= "08 - P�S GRADUA��O (LATO SENSO) - COMPLETO";
	public final String POS_GRADUACAO_STRICTO_SENSO_NIVEL_MESTRADO_INCOMPLETO 				= "09 - P�S GRADUA��O (STRICTO SENSO, N�VEL MESTRADO) - INCOMPLETO";
	public final String POS_GRADUACAO_STRICTO_SENSO_NIVEL_MESTRADO_COMPLETO 				= "10 - P�S GRADUA��O (STRICTO SENSO, N�VEL MESTRADO) - COMPLETO";
	public final String POS_GRADUACAO_STRICTO_SENSO_NIVEL_DOUTOR_INCOMPLETO 				= "11 - P�S GRADUA��O (STRICTO SENSO, N�VEL DOUTOR) - INCOMPLETO";
	public final String POS_GRADUACAO_STRICTO_SENSO_NIVEL_DOUTOR_COMPLETO 				= "12 - P�S GRADUA��O (STRICTO SENSO, N�VEL DOUTOR) - COMPLETO";
}
