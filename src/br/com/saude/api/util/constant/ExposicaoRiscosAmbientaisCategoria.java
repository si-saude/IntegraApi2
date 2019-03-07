package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class ExposicaoRiscosAmbientaisCategoria extends GenericConstant {

	private static ExposicaoRiscosAmbientaisCategoria instance;
	
	private ExposicaoRiscosAmbientaisCategoria() {
		
	}
	
	public static ExposicaoRiscosAmbientaisCategoria getInstance() {
		if(instance==null)
			instance = new ExposicaoRiscosAmbientaisCategoria();
		return instance;
	}
	
	public static final String IRRELEVANTE 		= "IRRELEVANTE";
	public static final String CRITICA 			= "CR�TICA";
	public static final String NAO_TOLERAVEL 	= "N�O TOLER�VEL";
	public static final String DE_ATENCAO 		= "DE ATEN��O";

}
