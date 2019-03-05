package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class SimNao extends GenericConstant  {

	private static SimNao instance;
	
	private SimNao() {
		
	}
	
	public static SimNao getInstance() {
		if(instance==null)
			instance = new SimNao();
		return instance;
	}
	
	public final String NAO			= "NÃO";
	public final String SIM			= "SIM";
}
