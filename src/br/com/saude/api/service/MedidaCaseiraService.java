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
import br.com.saude.api.model.business.MedidaCaseiraBo;
import br.com.saude.api.model.business.validate.MedidaCaseiraValidator;
import br.com.saude.api.model.entity.filter.MedidaCaseiraFilter;
import br.com.saude.api.model.entity.po.MedidaCaseira;
import br.com.saude.api.util.RequestInterceptor;

@Path("medida-caseira")
@RequestInterceptor
public class MedidaCaseiraService extends GenericService<MedidaCaseira, MedidaCaseiraFilter, MedidaCaseiraBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=MedidaCaseiraValidator.class)
	@Override
	public Response save(MedidaCaseira medidaCaseira) {		
		return super.save(medidaCaseira);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(MedidaCaseiraFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(MedidaCaseiraFilter filter) {		
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
