package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class ClassificacaoAtividadeFisica extends GenericConstant {

	private static ClassificacaoAtividadeFisica instance;
	
	private ClassificacaoAtividadeFisica() {
		
	}
	
	public static ClassificacaoAtividadeFisica getInstance() {
		if(instance==null)
			instance = new ClassificacaoAtividadeFisica();
		return instance;
	}
	
	public final String LEVE				= "LEVE";
	public final String MODERADO			= "MODERADO";
	public final String VIGOROSO			= "VIGOROSO";
}
