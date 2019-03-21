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
import br.com.saude.api.model.business.FilaAtendimentoBo;
import br.com.saude.api.model.business.validate.FilaAtendimentoValidator;
import br.com.saude.api.model.entity.filter.FilaAtendimentoFilter;
import br.com.saude.api.model.entity.po.Atendimento;
import br.com.saude.api.model.entity.po.FilaAtendimento;
import br.com.saude.api.util.RequestInterceptor;

@Path("fila-atendimento")
@RequestInterceptor
public class FilaAtendimentoService extends GenericService<FilaAtendimento,FilaAtendimentoFilter,FilaAtendimentoBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=FilaAtendimentoValidator.class)
	@Override
	public Response save(FilaAtendimento fila) {		
		return super.save(fila);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(FilaAtendimentoFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(FilaAtendimentoFilter filter) {		
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
	@Path("/entrar-ou-voltar")
	public Response entrarOuVoltar(FilaAtendimento fila) {		
		try {
			return Response.ok(getBo().entrarOuVoltar(fila)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/pausar")
	public Response pausar(FilaAtendimento fila) {		
		try {
			return Response.ok(getBo().pausar(fila)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/encerrar")
	public Response encerrar(FilaAtendimento fila) {		
		try {
			return Response.ok(getBo().encerrar(fila)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/get-list-nao-encerrado")
	public Response getListNaoEncerrado(FilaAtendimentoFilter filter) {		
		try {
			return Response.ok(getBo().getListNaoEncerrado(filter)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/get-list-disponivel")
	public Response getListNaoEncerrado(Atendimento atendimento) {		
		try {
			return Response.ok(getBo().getListDisponivel(atendimento)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
}
