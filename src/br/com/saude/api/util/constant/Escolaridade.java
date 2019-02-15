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
	public final String MEDIO_INCOMPLETO 				= "03 - MÉDIO - INCOMPLETO";
	public final String MEDIO_COMPLETO 				= "04 - MÉDIO - COMPLETO";
	public final String SUPERIOR_INCOMPLETO 				= "05 - SUPERIOR - INCOMPLETO";
	public final String SUPERIOR_COMPLETO 				= "06 - SUPERIOR - COMPLETO";
	public final String POS_GRADUACAO_LATO_SENSO_INCOMPLETO 				= "07 - PÓS GRADUAÇÃO (LATO SENSO) - INCOMPLETO";
	public final String POS_GRADUACAO_LATO_SENSO_COMPLETO 				= "08 - PÓS GRADUAÇÃO (LATO SENSO) - COMPLETO";
	public final String POS_GRADUACAO_STRICTO_SENSO_NIVEL_MESTRADO_INCOMPLETO 				= "09 - PÓS GRADUAÇÃO (STRICTO SENSO, NÍVEL MESTRADO) - INCOMPLETO";
	public final String POS_GRADUACAO_STRICTO_SENSO_NIVEL_MESTRADO_COMPLETO 				= "10 - PÓS GRADUAÇÃO (STRICTO SENSO, NÍVEL MESTRADO) - COMPLETO";
	public final String POS_GRADUACAO_STRICTO_SENSO_NIVEL_DOUTOR_INCOMPLETO 				= "11 - PÓS GRADUAÇÃO (STRICTO SENSO, NÍVEL DOUTOR) - INCOMPLETO";
	public final String POS_GRADUACAO_STRICTO_SENSO_NIVEL_DOUTOR_COMPLETO 				= "12 - PÓS GRADUAÇÃO (STRICTO SENSO, NÍVEL DOUTOR) - COMPLETO";
}
