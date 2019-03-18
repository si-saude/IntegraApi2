package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class Flexibilidade extends GenericConstant {

	private static Flexibilidade instance;
	
	private Flexibilidade() {
		
	}
	
	public static Flexibilidade getInstance() {
		if(instance == null)
			instance = new Flexibilidade();
		return instance;
	}
	
	public final String EXCELENTE 			= "EXCELENTE";
	public final String ACIMA_DA_MEDIA 		= "ACIMA DA M�DIA";
	public final String MEDIA 				= "M�DIA";
	public final String ABAIXO_DA_MEDIA		= "ABAIXO DA M�DIA";
	public final String RUIM				= "RUIM";
	public final String NAO_APLICAVEL		= "N�O APLIC�VEL";
}
