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
import br.com.saude.api.model.business.TipoPerguntaFichaColetaBo;
import br.com.saude.api.model.business.validate.TipoPerguntaFichaColetaValidator;
import br.com.saude.api.model.entity.filter.TipoPerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.TipoPerguntaFichaColeta;
import br.com.saude.api.util.RequestInterceptor;

@Path("tipo-pergunta-ficha-coleta")
@RequestInterceptor
public class TipoPerguntaFichaColetaService extends GenericService<TipoPerguntaFichaColeta,TipoPerguntaFichaColetaFilter,TipoPerguntaFichaColetaBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=TipoPerguntaFichaColetaValidator.class)
	@Override
	public Response save(TipoPerguntaFichaColeta tipo) {		
		return super.save(tipo);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(TipoPerguntaFichaColetaFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(TipoPerguntaFichaColetaFilter filter) {		
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
