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
import br.com.saude.api.model.business.EixoBo;
import br.com.saude.api.model.business.validate.EixoValidator;
import br.com.saude.api.model.entity.filter.EixoFilter;
import br.com.saude.api.model.entity.po.Eixo;
import br.com.saude.api.util.RequestInterceptor;

@Path("eixo")
@RequestInterceptor
public class EixoService extends GenericService<Eixo,EixoFilter,EixoBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=EixoValidator.class)
	@Override
	public Response save(Eixo eixo) {		
		return super.save(eixo);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(EixoFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(EixoFilter filter) {		
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
}
