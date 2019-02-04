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
import br.com.saude.api.model.business.ImovelBo;
import br.com.saude.api.model.business.validate.ImovelValidator;
import br.com.saude.api.model.entity.filter.ImovelFilter;
import br.com.saude.api.model.entity.po.Imovel;
import br.com.saude.api.util.RequestInterceptor;

@Path("imovel")
@RequestInterceptor
public class ImovelService extends GenericService<Imovel,ImovelFilter,ImovelBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=ImovelValidator.class)
	@Override
	public Response save(Imovel imovel) {		
		return super.save(imovel);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(ImovelFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(ImovelFilter filter) {		
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
