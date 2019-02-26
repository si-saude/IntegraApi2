package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class StatusFilaAtendimento  extends GenericConstant {

	private static StatusFilaAtendimento instance;
	
	private StatusFilaAtendimento() {
		
	}
	
	public static StatusFilaAtendimento getInstance() {
		if(instance == null)
			instance = new StatusFilaAtendimento();
		return instance;
	}
	
	public final String DISPONIVEL 					= "DISPON�VEL";
	public final String INDISPONIVEL 				= "INDISPON�VEL";
	public final String AGUARDANDO_EMPREGADO		= "AGUARDANDO EMPREGADO";
	public final String EM_ATENDIMENTO				= "EM ATENDIMENTO";
	public final String LANCAMENTO_DE_INFORMACOES	= "LAN�AMENTO DE INFORMA��ES";
}
