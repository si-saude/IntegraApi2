package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class GrupoServico extends GenericConstant {

	private static GrupoServico instance;
	
	private GrupoServico() {
		
	}
	
	public static GrupoServico getInstance() {
		if(instance == null)
			instance = new GrupoServico();
		return instance;
	}
	
	public static final String ATENDIMENTO 						= "ATENDIMENTO";
	public static final String ATENDIMENTO_OCUPACIONAL 			= "ATENDIMENTO OCUPACIONAL";
	public static final String ATENDIMENTO_PROGRAMA_SAUDE		= "ATENDIMENTO DE PROGRAMAS DE SA�DE";
	public static final String PRONTO_ATENDIMENTO 				= "PRONTO ATENDIMENTO";
	public static final String HOMOLOGACAO_ATESTADO				= "HOMOLOGA��O DE ATESTADO";
	public static final String EDUCACAO_SAUDE					= "EDUCA��O EM SA�DE";
	public static final String GESTAO 							= "GEST�O";
	public static final String INSPECAO 						= "INSPE��O";
	public static final String MONITORAMENTO 					= "MONITORAMENTO";
	public static final String PAGAMENTO 						= "PAGAMENTO";
	public static final String PARECER 							= "PARECER";
	public static final String TRANSPORTE 						= "REQUISI��O DE TRANSPORTE";
	public static final String SAUDE_OPERACIONAL 	 			= "SA�DE OPERACIONAL";
}
