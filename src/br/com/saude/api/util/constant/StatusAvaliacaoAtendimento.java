package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class StatusAvaliacaoAtendimento extends GenericConstant {

	private static StatusAvaliacaoAtendimento instance;
	
	private StatusAvaliacaoAtendimento() {
		
	}
	
	public static StatusAvaliacaoAtendimento getInstance() {
		if(instance == null)
			instance = new StatusAvaliacaoAtendimento();
		return instance;
	}
	
	public final String PENDENTE 				= "PENDENTE";
	public final String INICIADA 				= "INICIADA";
	public final String FINALIZADA				= "FINALIZADA";
}
