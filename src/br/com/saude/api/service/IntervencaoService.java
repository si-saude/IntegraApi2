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
import br.com.saude.api.model.business.IntervencaoBo;
import br.com.saude.api.model.business.validate.IntervencaoValidator;
import br.com.saude.api.model.entity.filter.IntervencaoFilter;
import br.com.saude.api.model.entity.po.Intervencao;
import br.com.saude.api.util.RequestInterceptor;

@Path("intervencao")
@RequestInterceptor
public class IntervencaoService extends GenericService<Intervencao,IntervencaoFilter,IntervencaoBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=IntervencaoValidator.class)
	@Override
	public Response save(Intervencao intervencao) {		
		return super.save(intervencao);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(IntervencaoFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(IntervencaoFilter filter) {		
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
