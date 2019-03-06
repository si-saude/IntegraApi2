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
import br.com.saude.api.model.business.AvaliacaoAtendimentoBo;
import br.com.saude.api.model.business.validate.AvaliacaoAtendimentoValidator;
import br.com.saude.api.model.entity.filter.AvaliacaoAtendimentoFilter;
import br.com.saude.api.model.entity.po.AvaliacaoAtendimento;
import br.com.saude.api.util.RequestInterceptor;

@Path("avaliacao-atendimento")
@RequestInterceptor
public class AvaliacaoAtendimentoService extends GenericService<AvaliacaoAtendimento,AvaliacaoAtendimentoFilter,AvaliacaoAtendimentoBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=AvaliacaoAtendimentoValidator.class)
	@Override
	public Response save(AvaliacaoAtendimento avaliacao) {		
		return super.save(avaliacao);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(AvaliacaoAtendimentoFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(AvaliacaoAtendimentoFilter filter) {		
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
	@Path("/registrar")
	public Response registrar(AvaliacaoAtendimento avaliacao) {		
		try {
			return Response.ok(getBo().registrar(avaliacao)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
}
