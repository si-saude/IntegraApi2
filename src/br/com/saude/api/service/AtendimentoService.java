package br.com.saude.api.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.saude.api.generic.CustomValidator;
import br.com.saude.api.generic.GenericService;
import br.com.saude.api.model.business.AtendimentoBo;
import br.com.saude.api.model.business.validate.AtendimentoValidator;
import br.com.saude.api.model.entity.filter.AtendimentoFilter;
import br.com.saude.api.model.entity.po.Atendimento;
import br.com.saude.api.util.RequestInterceptor;

@Path("atendimento")
@RequestInterceptor
public class AtendimentoService extends GenericService<Atendimento,AtendimentoFilter,AtendimentoBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=AtendimentoValidator.class)
	@Override
	public Response save(Atendimento atendimento) {		
		return super.save(atendimento);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(AtendimentoFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(AtendimentoFilter filter) {		
		return super.getSelectList(filter);
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("id") String id) throws Exception {
		return super.get(id);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response delete(Object id) {
		return super.delete(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/iniciar")
	public Response iniciar(Atendimento atendimento) {		
		try {
			return Response.ok(getBo().iniciar(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/liberar")
	public Response liberar(Atendimento atendimento) {		
		try {
			return Response.ok(getBo().liberar(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/finalizar")
	public Response finalizar(Atendimento atendimento) {		
		try {
			return Response.ok(getBo().finalizar(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/devolver")
	public Response devolver(Atendimento atendimento) {		
		try {
			return Response.ok(getBo().devolver(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/registrar-ausencia")
	public Response registrarAusencia(Atendimento atendimento) {		
		try {
			return Response.ok(getBo().registrarAusencia(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/encaminhar")
	public Response encaminhar(Atendimento atendimento) {		
		try {
			return Response.ok(getBo().encaminhar(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/encaminhar-avulso")
	public Response encaminharAvulso(Atendimento atendimento) {		
		try {
			return Response.ok(getBo().encaminharAvulso(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/get-list-atendimentos-aguardando-empregado-by-localizacao")
	public Response getListAtendimentosAguardandoEmpregadoByLocalizacao(Atendimento atendimento) {		
		try {
			return Response.ok(getBo()
				.getListAtendimentosAguardandoEmpregadoByLocalizacao(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/get-list-filas-atendimento-by-localizacao")
	public Response getListFilasAtendimentoByLocalizacao(Atendimento atendimento) {		
		try {
			return Response.ok(getBo()
				.getListFilasAtendimentoByLocalizacao(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
}
