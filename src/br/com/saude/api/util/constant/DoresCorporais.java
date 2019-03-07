package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class DoresCorporais extends GenericConstant {

	private static DoresCorporais instance;
	
	private DoresCorporais() {
		
	}
	
	public static DoresCorporais getInstance() {
		if(instance == null)
			instance = new DoresCorporais();
		return instance;
	}
	
	public final String INSUPORTAVEL 		= "INSURPORTÁVEL";
	public final String SEVERO 				= "SEVERO";
	public final String MODERADO 			= "MODERADO";
	public final String PEQUENO 			= "PEQUENO";
	public final String AUSENTE 			= "AUSENTE";

}
