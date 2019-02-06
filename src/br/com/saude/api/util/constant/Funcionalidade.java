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
	
	public static final String GHE_ADICIONAR 			    		= "GHE_ADICIONAR";
	public static final String GHE_EDITAR		 					= "GHE_EDITAR";
	public static final String GHE_DETALHAR 						= "GHE_DETALHAR";
	public static final String GHE_LISTAR							= "GHE_LISTAR";
	public static final String GHE_REMOVER 							= "GHE_REMOVER";
	
	public static final String PERFIL_ADICIONAR 			    	= "PERFIL_ADICIONAR";
	public static final String PERFIL_EDITAR		 				= "PERFIL_EDITAR";
	public static final String PERFIL_DETALHAR 						= "PERFIL_DETALHAR";
	public static final String PERFIL_LISTAR						= "PERFIL_LISTAR";
	public static final String PERFIL_REMOVER 						= "PERFIL_REMOVER";
	
	public static final String RISCO_GHE_ADICIONAR 			    	= "RISCO-GHE_ADICIONAR";
	public static final String RISCO_GHE_EDITAR		 				= "RISCO-GHE_EDITAR";
	public static final String RISCO_GHE_DETALHAR 					= "RISCO-GHE_DETALHAR";
	public static final String RISCO_GHE_LISTAR						= "RISCO-GHE_LISTAR";
	public static final String RISCO_GHE_REMOVER 					= "RISCO-GHE_REMOVER";
	
	public static final String USUARIO_ADICIONAR 			    	= "USUARIO_ADICIONAR";
	public static final String USUARIO_EDITAR		 				= "USUARIO_EDITAR";
	public static final String USUARIO_DETALHAR 					= "USUARIO_DETALHAR";
	public static final String USUARIO_LISTAR						= "USUARIO_LISTAR";
	public static final String USUARIO_REMOVER 						= "USUARIO_REMOVER";
}
