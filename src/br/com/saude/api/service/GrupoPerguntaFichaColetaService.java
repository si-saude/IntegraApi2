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
import br.com.saude.api.model.business.GrupoPerguntaFichaColetaBo;
import br.com.saude.api.model.business.validate.GrupoPerguntaFichaColetaValidator;
import br.com.saude.api.model.entity.filter.GrupoPerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.GrupoPerguntaFichaColeta;
import br.com.saude.api.util.RequestInterceptor;

@Path("grupo-pergunta-ficha-coleta")
@RequestInterceptor
public class GrupoPerguntaFichaColetaService extends GenericService<GrupoPerguntaFichaColeta,GrupoPerguntaFichaColetaFilter,GrupoPerguntaFichaColetaBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=GrupoPerguntaFichaColetaValidator.class)
	@Override
	public Response save(GrupoPerguntaFichaColeta grupo) {		
		return super.save(grupo);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(GrupoPerguntaFichaColetaFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(GrupoPerguntaFichaColetaFilter filter) {		
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
