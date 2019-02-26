package br.com.saude.api.util.constant;

import br.com.saude.api.generic.GenericConstant;

public class Funcionalidade extends GenericConstant {
	
	private static Funcionalidade instance;
	
	private Funcionalidade() {
		
	}
	
	public static Funcionalidade getInstance() {
		if(instance==null)
			instance = new Funcionalidade();
		return instance;
	}
	
	public static final String ALIMENTO_ADICIONAR 			   		= "ALIMENTO_ADICIONAR";
	public static final String ALIMENTO_EDITAR		 				= "ALIMENTO_EDITAR";
	public static final String ALIMENTO_DETALHAR 					= "ALIMENTO_DETALHAR";
	public static final String ALIMENTO_LISTAR						= "ALIMENTO_LISTAR";
	public static final String ALIMENTO_REMOVER 					= "ALIMENTO_REMOVER";
	
	public static final String ATIVIDADE_FISICA_ADICIONAR 			= "ATIVIDADE-FISICA_ADICIONAR";
	public static final String ATIVIDADE_FISICA_EDITAR		 		= "ATIVIDADE-FISICA_EDITAR";
	public static final String ATIVIDADE_FISICA_DETALHAR 			= "ATIVIDADE-FISICA_DETALHAR";
	public static final String ATIVIDADE_FISICA_LISTAR				= "ATIVIDADE-FISICA_LISTAR";
	public static final String ATIVIDADE_FISICA_REMOVER 			= "ATIVIDADE-FISICA_REMOVER";
	
	public static final String BASE_ADICIONAR 			    		= "BASE_ADICIONAR";
	public static final String BASE_EDITAR		 					= "BASE_EDITAR";
	public static final String BASE_DETALHAR 						= "BASE_DETALHAR";
	public static final String BASE_LISTAR							= "BASE_LISTAR";
	public static final String BASE_REMOVER 						= "BASE_REMOVER";
	
	public static final String CARGO_ADICIONAR 			    		= "CARGO_ADICIONAR";
	public static final String CARGO_EDITAR		 					= "CARGO_EDITAR";
	public static final String CARGO_DETALHAR 						= "CARGO_DETALHAR";
	public static final String CARGO_LISTAR							= "CARGO_LISTAR";
	public static final String CARGO_REMOVER 						= "CARGO_REMOVER";
	
	public static final String CIDADE_ADICIONAR 			    	= "CIDADE_ADICIONAR";
	public static final String CIDADE_EDITAR		 				= "CIDADE_EDITAR";
	public static final String CIDADE_DETALHAR 						= "CIDADE_DETALHAR";
	public static final String CIDADE_LISTAR						= "CIDADE_LISTAR";
	public static final String CIDADE_REMOVER 						= "CIDADE_REMOVER";
	
	public static final String CLINICA_ADICIONAR 			    	= "CLINICA_ADICIONAR";
	public static final String CLINICA_EDITAR		 				= "CLINICA_EDITAR";
	public static final String CLINICA_DETALHAR 					= "CLINICA_DETALHAR";
	public static final String CLINICA_LISTAR						= "CLINICA_LISTAR";
	public static final String CLINICA_REMOVER 						= "CLINICA_REMOVER";
	
	public static final String CRITERIO_ADICIONAR 			    	= "CRITERIO_ADICIONAR";
	public static final String CRITERIO_EDITAR		 				= "CRITERIO_EDITAR";
	public static final String CRITERIO_DETALHAR 					= "CRITERIO_DETALHAR";
	public static final String CRITERIO_LISTAR						= "CRITERIO_LISTAR";
	public static final String CRITERIO_REMOVER 					= "CRITERIO_REMOVER";
	
	public static final String CURSO_ADICIONAR 			    		= "CURSO_ADICIONAR";
	public static final String CURSO_EDITAR		 					= "CURSO_EDITAR";
	public static final String CURSO_DETALHAR 						= "CURSO_DETALHAR";
	public static final String CURSO_LISTAR							= "CURSO_LISTAR";
	public static final String CURSO_REMOVER 						= "CURSO_REMOVER";
	
	public static final String DIAGNOSTICO_ADICIONAR 			    = "DIAGNOSTICO_ADICIONAR";
	public static final String DIAGNOSTICO_EDITAR		 			= "DIAGNOSTICO_EDITAR";
	public static final String DIAGNOSTICO_DETALHAR 				= "DIAGNOSTICO_DETALHAR";
	public static final String DIAGNOSTICO_LISTAR					= "DIAGNOSTICO_LISTAR";
	public static final String DIAGNOSTICO_REMOVER 					= "DIAGNOSTICO_REMOVER";
	
	public static final String EIXO_ADICIONAR 			    		= "EIXO_ADICIONAR";
	public static final String EIXO_EDITAR		 					= "EIXO_EDITAR";
	public static final String EIXO_DETALHAR 						= "EIXO_DETALHAR";
	public static final String EIXO_LISTAR							= "EIXO_LISTAR";
	public static final String EIXO_REMOVER 						= "EIXO_REMOVER";
	
	public static final String EMPREGADO_ADICIONAR 			    	= "EMPREGADO_ADICIONAR";
	public static final String EMPREGADO_EDITAR		 				= "EMPREGADO_EDITAR";
	public static final String EMPREGADO_DETALHAR 					= "EMPREGADO_DETALHAR";
	public static final String EMPREGADO_LISTAR						= "EMPREGADO_LISTAR";
	public static final String EMPREGADO_REMOVER 					= "EMPREGADO_REMOVER";
	
	public static final String ENFASE_ADICIONAR 			    	= "ENFASE_ADICIONAR";
	public static final String ENFASE_EDITAR		 				= "ENFASE_EDITAR";
	public static final String ENFASE_DETALHAR 						= "ENFASE_DETALHAR";
	public static final String ENFASE_LISTAR						= "ENFASE_LISTAR";
	public static final String ENFASE_REMOVER 						= "ENFASE_REMOVER";
	
	public static final String EQUIPE_ADICIONAR 			    	= "EQUIPE_ADICIONAR";
	public static final String EQUIPE_EDITAR		 				= "EQUIPE_EDITAR";
	public static final String EQUIPE_DETALHAR 						= "EQUIPE_DETALHAR";
	public static final String EQUIPE_LISTAR						= "EQUIPE_LISTAR";
	public static final String EQUIPE_REMOVER 						= "EQUIPE_REMOVER";
	
	public static final String EXAME_ADICIONAR 			    		= "EXAME_ADICIONAR";
	public static final String EXAME_EDITAR		 					= "EXAME_EDITAR";
	public static final String EXAME_DETALHAR 						= "EXAME_DETALHAR";
	public static final String EXAME_LISTAR							= "EXAME_LISTAR";
	public static final String EXAME_REMOVER 						= "EXAME_REMOVER";
	
	public static final String GERENCIA_ADICIONAR 			    	= "GERENCIA_ADICIONAR";
	public static final String GERENCIA_EDITAR		 				= "GERENCIA_EDITAR";
	public static final String GERENCIA_DETALHAR 					= "GERENCIA_DETALHAR";
	public static final String GERENCIA_LISTAR						= "GERENCIA_LISTAR";
	public static final String GERENCIA_REMOVER 					= "GERENCIA_REMOVER";
	
	public static final String GRUPO_PERGUNTA_FICHA_COLETA_ADICIONAR= "GRUPO-PERGUNTA-FICHA-COLETA_ADICIONAR";
	public static final String GRUPO_PERGUNTA_FICHA_COLETA_EDITAR	= "GRUPO-PERGUNTA-FICHA-COLETA_EDITAR";
	public static final String GRUPO_PERGUNTA_FICHA_COLETA_DETALHAR = "GRUPO-PERGUNTA-FICHA-COLETA_DETALHAR";
	public static final String GRUPO_PERGUNTA_FICHA_COLETA_LISTAR	= "GRUPO-PERGUNTA-FICHA-COLETA_LISTAR";
	public static final String GRUPO_PERGUNTA_FICHA_COLETA_REMOVER 	= "GRUPO-PERGUNTA-FICHA-COLETA_REMOVER";
	
	public static final String IMOVEL_ADICIONAR 			    	= "IMOVEL_ADICIONAR";
	public static final String IMOVEL_EDITAR		 				= "IMOVEL_EDITAR";
	public static final String IMOVEL_DETALHAR 						= "IMOVEL_DETALHAR";
	public static final String IMOVEL_LISTAR						= "IMOVEL_LISTAR";
	public static final String IMOVEL_REMOVER 						= "IMOVEL_REMOVER";
	
	public static final String INDICADOR_SAST_ADICIONAR 			= "INDICADOR-SAST_ADICIONAR";
	public static final String INDICADOR_SAST_EDITAR		 		= "INDICADOR-SAST_EDITAR";
	public static final String INDICADOR_SAST_DETALHAR 				= "INDICADOR-SAST_DETALHAR";
	public static final String INDICADOR_SAST_LISTAR				= "INDICADOR-SAST_LISTAR";
	public static final String INDICADOR_SAST_REMOVER 				= "INDICADOR-SAST_REMOVER";
	
	public static final String INTERVENCAO_ADICIONAR 			    = "INTERVENCAO_ADICIONAR";
	public static final String INTERVENCAO_EDITAR		 			= "INTERVENCAO_EDITAR";
	public static final String INTERVENCAO_DETALHAR 				= "INTERVENCAO_DETALHAR";
	public static final String INTERVENCAO_LISTAR					= "INTERVENCAO_LISTAR";
	public static final String INTERVENCAO_REMOVER 					= "INTERVENCAO_REMOVER";
	
	public static final String LOCALIZACAO_ADICIONAR 			    = "LOCALIZACAO_ADICIONAR";
	public static final String LOCALIZACAO_EDITAR		 			= "LOCALIZACAO_EDITAR";
	public static final String LOCALIZACAO_DETALHAR 				= "LOCALIZACAO_DETALHAR";
	public static final String LOCALIZACAO_LISTAR					= "LOCALIZACAO_LISTAR";
	public static final String LOCALIZACAO_REMOVER 					= "LOCALIZACAO_REMOVER";
	
	public static final String FUNCAO_ADICIONAR 			    	= "FUNCAO_ADICIONAR";
	public static final String FUNCAO_EDITAR		 				= "FUNCAO_EDITAR";
	public static final String FUNCAO_DETALHAR 						= "FUNCAO_DETALHAR";
	public static final String FUNCAO_LISTAR						= "FUNCAO_LISTAR";
	public static final String FUNCAO_REMOVER 						= "FUNCAO_REMOVER";
	
	public static final String GHE_ADICIONAR 			    		= "GHE_ADICIONAR";
	public static final String GHE_EDITAR		 					= "GHE_EDITAR";
	public static final String GHE_DETALHAR 						= "GHE_DETALHAR";
	public static final String GHE_LISTAR							= "GHE_LISTAR";
	public static final String GHE_REMOVER 							= "GHE_REMOVER";
	
	public static final String GHEE_ADICIONAR 			    		= "GHEE_ADICIONAR";
	public static final String GHEE_EDITAR		 					= "GHEE_EDITAR";
	public static final String GHEE_DETALHAR 						= "GHEE_DETALHAR";
	public static final String GHEE_LISTAR							= "GHEE_LISTAR";
	public static final String GHEE_REMOVER 						= "GHEE_REMOVER";
	
	public static final String GRUPO_MONITORAMENTO_ADICIONAR		= "GRUPO-MONITORAMENTO_ADICIONAR";
	public static final String GRUPO_MONITORAMENTO_EDITAR	 		= "GRUPO-MONITORAMENTO_EDITAR";
	public static final String GRUPO_MONITORAMENTO_DETALHAR			= "GRUPO-MONITORAMENTO_DETALHAR";
	public static final String GRUPO_MONITORAMENTO_LISTAR			= "GRUPO-MONITORAMENTO_LISTAR";
	public static final String GRUPO_MONITORAMENTO_REMOVER 			= "GRUPO-MONITORAMENTO_REMOVER";
	
	public static final String MEDIDA_CASEIRA_ADICIONAR 			= "MEDIDA-CASEIRA_ADICIONAR";
	public static final String MEDIDA_CASEIRA_EDITAR		 		= "MEDIDA-CASEIRA_EDITAR";
	public static final String MEDIDA_CASEIRA_DETALHAR 				= "MEDIDA-CASEIRA_DETALHAR";
	public static final String MEDIDA_CASEIRA_LISTAR				= "MEDIDA-CASEIRA_LISTAR";
	public static final String MEDIDA_CASEIRA_REMOVER 				= "MEDIDA-CASEIRA_REMOVER";
	
	public static final String PERFIL_ADICIONAR 			    	= "PERFIL_ADICIONAR";
	public static final String PERFIL_EDITAR		 				= "PERFIL_EDITAR";
	public static final String PERFIL_DETALHAR 						= "PERFIL_DETALHAR";
	public static final String PERFIL_LISTAR						= "PERFIL_LISTAR";
	public static final String PERFIL_REMOVER 						= "PERFIL_REMOVER";
	
	public static final String PERGUNTA_FICHA_COLETA_ADICIONAR 		= "PERGUNTA-FICHA-COLETA_ADICIONAR";
	public static final String PERGUNTA_FICHA_COLETA_EDITAR		 	= "PERGUNTA-FICHA-COLETA_EDITAR";
	public static final String PERGUNTA_FICHA_COLETA_DETALHAR 		= "PERGUNTA-FICHA-COLETA_DETALHAR";
	public static final String PERGUNTA_FICHA_COLETA_LISTAR			= "PERGUNTA-FICHA-COLETA_LISTAR";
	public static final String PERGUNTA_FICHA_COLETA_REMOVER 		= "PERGUNTA-FICHA-COLETA_REMOVER";
	
	public static final String PROFISSIONAL_ADICIONAR 			    = "PROFISSIONAL_ADICIONAR";
	public static final String PROFISSIONAL_EDITAR		 			= "PROFISSIONAL_EDITAR";
	public static final String PROFISSIONAL_DETALHAR 				= "PROFISSIONAL_DETALHAR";
	public static final String PROFISSIONAL_LISTAR					= "PROFISSIONAL_LISTAR";
	public static final String PROFISSIONAL_REMOVER 				= "PROFISSIONAL_REMOVER";
	
	public static final String QUESTIONARIO_ADICIONAR 			    = "QUESTIONARIO_ADICIONAR";
	public static final String QUESTIONARIO_EDITAR		 			= "QUESTIONARIO_EDITAR";
	public static final String QUESTIONARIO_DETALHAR 				= "QUESTIONARIO_DETALHAR";
	public static final String QUESTIONARIO_LISTAR					= "QUESTIONARIO_LISTAR";
	public static final String QUESTIONARIO_REMOVER 				= "QUESTIONARIO_REMOVER";
	
	public static final String REGIME_ADICIONAR 			    	= "REGIME_ADICIONAR";
	public static final String REGIME_EDITAR		 				= "REGIME_EDITAR";
	public static final String REGIME_DETALHAR 						= "REGIME_DETALHAR";
	public static final String REGIME_LISTAR						= "REGIME_LISTAR";
	public static final String REGIME_REMOVER 						= "REGIME_REMOVER";
	
	public static final String REGRA_ATENDIMENTO_ADICIONAR 			= "REGRA-ATENDIMENTO_ADICIONAR";
	public static final String REGRA_ATENDIMENTO_EDITAR		 		= "REGRA-ATENDIMENTO_EDITAR";
	public static final String REGRA_ATENDIMENTO_DETALHAR 			= "REGRA-ATENDIMENTO_DETALHAR";
	public static final String REGRA_ATENDIMENTO_LISTAR				= "REGRA-ATENDIMENTO_LISTAR";
	public static final String REGRA_ATENDIMENTO_REMOVER 			= "REGRA-ATENDIMENTO_REMOVER";
	
	public static final String REQUISITO_ASO_ADICIONAR 				= "REQUISITO-ASO_ADICIONAR";
	public static final String REQUISITO_ASO_EDITAR		 			= "REQUISITO-ASO_EDITAR";
	public static final String REQUISITO_ASO_DETALHAR 				= "REQUISITO-ASO_DETALHAR";
	public static final String REQUISITO_ASO_LISTAR					= "REQUISITO-ASO_LISTAR";
	public static final String REQUISITO_ASO_REMOVER 				= "REQUISITO-ASO_REMOVER";
	
	public static final String RISCO_GHE_ADICIONAR 			    	= "RISCO-GHE_ADICIONAR";
	public static final String RISCO_GHE_EDITAR		 				= "RISCO-GHE_EDITAR";
	public static final String RISCO_GHE_DETALHAR 					= "RISCO-GHE_DETALHAR";
	public static final String RISCO_GHE_LISTAR						= "RISCO-GHE_LISTAR";
	public static final String RISCO_GHE_REMOVER 					= "RISCO-GHE_REMOVER";
	
	public static final String SERVICO_ADICIONAR 			    	= "SERVICO_ADICIONAR";
	public static final String SERVICO_EDITAR		 				= "SERVICO_EDITAR";
	public static final String SERVICO_DETALHAR 					= "SERVICO_DETALHAR";
	public static final String SERVICO_LISTAR						= "SERVICO_LISTAR";
	public static final String SERVICO_REMOVER 						= "SERVICO_REMOVER";
	
	public static final String TIPO_GRUPO_MONITORAMENTO_ADICIONAR 	= "TIPO-GRUPO-MONITORAMENTO_ADICIONAR";
	public static final String TIPO_GRUPO_MONITORAMENTO_EDITAR 		= "TIPO-GRUPO-MONITORAMENTO_EDITAR";
	public static final String TIPO_GRUPO_MONITORAMENTO_DETALHAR	= "TIPO-GRUPO-MONITORAMENTO_DETALHAR";
	public static final String TIPO_GRUPO_MONITORAMENTO_LISTAR		= "TIPO-GRUPO-MONITORAMENTO_LISTAR";
	public static final String TIPO_GRUPO_MONITORAMENTO_REMOVER 	= "TIPO-GRUPO-MONITORAMENTO_REMOVER";
	
	public static final String USUARIO_ADICIONAR 			    	= "USUARIO_ADICIONAR";
	public static final String USUARIO_EDITAR		 				= "USUARIO_EDITAR";
	public static final String USUARIO_DETALHAR 					= "USUARIO_DETALHAR";
	public static final String USUARIO_LISTAR						= "USUARIO_LISTAR";
	public static final String USUARIO_REMOVER 						= "USUARIO_REMOVER";
	
	
	
	public static final String CHECKIN_CHECKIN 			    		= "CHECKIN_CHECKIN";
	
	public static final String SOLICITACAO_SOLICITAR 			    = "SOLICITACAO_SOLICITAR";
}
