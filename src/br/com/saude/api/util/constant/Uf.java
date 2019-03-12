package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class Uf extends GenericConstant {
	private static Uf instance;
	
	private Uf() {
		
	}
	
	public static Uf getInstance() {
		if(instance==null)
			instance = new Uf();
		return instance;
	}
	
	public final String AC			= "AC";
	public final String AL			= "AL";
	public final String AP			= "AP";
	public final String AM			= "AM";
	public final String BA			= "BA";
	public final String CE			= "CE";
	public final String DF			= "DF";
	public final String ES 			= "ES";
	public final String GO 			= "GO";
	public final String MA			= "MA";
	public final String MG 			= "MG";
	public final String MT 			= "MT";
	public final String MS 			= "MS";
	public final String PA 			= "PA";
	public final String PB			= "PB";
	public final String PE 			= "PE";
	public final String PI			= "PI";
	public final String PR			= "PR";
	public final String RJ			= "RJ";
	public final String RN			= "RN";
	public final String RS 			= "RS";
	public final String RO 			= "RO";
	public final String RR 			= "RR";
	public final String SC 			= "SC";
	public final String SE			= "SE";
	public final String SP 			= "SP";
	public final String TO 			= "TO";
	public final String N_A			= "N/A";
}
