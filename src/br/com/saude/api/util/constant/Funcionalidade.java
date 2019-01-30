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
	
	public static final String PERFIL_ADICIONAR 			    	= "PERFIL_ADICIONAR";
	public static final String PERFIL_EDITAR		 				= "PERFIL_EDITAR";
	public static final String PERFIL_DETALHAR 						= "PERFIL_DETALHAR";
	public static final String PERFIL_LISTAR						= "PERFIL_LISTAR";
	public static final String PERFIL_REMOVER 						= "PERFIL_REMOVER";
	
	public static final String USUARIO_ADICIONAR 			    	= "USUARIO_ADICIONAR";
	public static final String USUARIO_EDITAR		 				= "USUARIO_EDITAR";
	public static final String USUARIO_DETALHAR 					= "USUARIO_DETALHAR";
	public static final String USUARIO_LISTAR						= "USUARIO_LISTAR";
	public static final String USUARIO_REMOVER 						= "USUARIO_REMOVER";
}
