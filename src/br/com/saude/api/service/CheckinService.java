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
import br.com.saude.api.model.business.CheckinBo;
import br.com.saude.api.model.business.validate.CheckinValidator;
import br.com.saude.api.model.entity.filter.CheckinFilter;
import br.com.saude.api.model.entity.po.Checkin;
import br.com.saude.api.util.RequestInterceptor;

@Path("checkin")
@RequestInterceptor
public class CheckinService extends GenericService<Checkin,CheckinFilter,CheckinBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=CheckinValidator.class)
	@Override
	public Response save(Checkin checkin) {		
		return super.save(checkin);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(CheckinFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(CheckinFilter filter) {		
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
	public Response registrar(Checkin checkin) {		
		try {
			return Response.ok(getBo().registrar(checkin)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/checkOut")
	public Response checkOut(Checkin checkin) {		
		try {
			return Response.ok(getBo().checkOut(checkin)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
}
