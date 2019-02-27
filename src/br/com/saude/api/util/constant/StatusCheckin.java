package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class StatusCheckin extends GenericConstant {

	private static StatusCheckin instance;
	
	private StatusCheckin() {
		
	}
	
	public static StatusCheckin getInstance() {
		if(instance == null)
			instance = new StatusCheckin();
		return instance;
	}
	
	public final String AGUARDANDO 				= "AGUARDANDO";
	public final String AUSENTE 				= "AUSENTE";
	public final String EM_ATENDIMENTO			= "EM ATENDIMENTO";
	public final String FINALIZADO				= "FINALIZADO";
}
