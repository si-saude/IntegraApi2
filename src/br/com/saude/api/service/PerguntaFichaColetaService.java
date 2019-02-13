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
import br.com.saude.api.model.business.PerguntaFichaColetaBo;
import br.com.saude.api.model.business.validate.PerguntaFichaColetaValidator;
import br.com.saude.api.model.entity.filter.PerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.PerguntaFichaColeta;
import br.com.saude.api.util.RequestInterceptor;

@Path("pergunta-ficha-coleta")
@RequestInterceptor
public class PerguntaFichaColetaService extends GenericService<PerguntaFichaColeta,PerguntaFichaColetaFilter,PerguntaFichaColetaBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=PerguntaFichaColetaValidator.class)
	@Override
	public Response save(PerguntaFichaColeta pergunta) {		
		return super.save(pergunta);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(PerguntaFichaColetaFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(PerguntaFichaColetaFilter filter) {		
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
