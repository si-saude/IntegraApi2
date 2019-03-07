package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class RefereQualidadeAgua extends GenericConstant {

	private static RefereQualidadeAgua instance;
	
	private RefereQualidadeAgua() {
		
	}
	
	public static RefereQualidadeAgua getInstance() {
		if(instance==null)
			instance = new RefereQualidadeAgua();
		return instance;
	}
	
	public static final String BOA 				= "BOA";
	public static final String REGULAR 			= "REGULAR";
	public static final String RUIM 			= "RUIM";

}
