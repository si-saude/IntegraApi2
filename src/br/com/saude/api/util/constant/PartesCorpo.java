package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class PartesCorpo extends GenericConstant {
	
	private static PartesCorpo instance;
	
	private PartesCorpo() {
		
	}
	
	public static PartesCorpo getInstance() {
		if(instance==null)
			instance = new PartesCorpo();
		return instance;
	}
	
	public static final String CABECA  				= "CABE�A";
	public static final String PESCOCO  			= "PESCO�O";
	public static final String CERVICAL  			= "CERVICAL";
	public static final String DORSAL  				= "DORSAL";
	public static final String LOMBAR  				= "LOMBAR";
	public static final String OMBRO  				= "OMBRO";
	public static final String BRACO  				= "BRA�O";
	public static final String COTOVELO  			= "COTOVELO";
	public static final String ANTEBRACO 			= "ANTEBRA�O";
	public static final String PUNHO  				= "PUNHO";
	public static final String MAO  				= "M�O";
	public static final String PEITORAL  			= "PEITORAL";
	public static final String TORAX  				= "T�RAX";
	public static final String ABDOMEN  			= "ABDOMEN";
	public static final String QUADRIL  			= "QUADRIL";
	public static final String COXA  				= "COXA";
	public static final String JOELHO  				= "JOELHO";
	public static final String PANTURRILHA  		= "PANTURRILHA";
	public static final String TORNOZELO  			= "TORNOZELO";
	public static final String PE  					= "P�";
}
