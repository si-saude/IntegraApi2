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
	
	public final String BA			= "BA";
	public final String ES 			= "ES";
	public final String N_A			= "N/A";
}
