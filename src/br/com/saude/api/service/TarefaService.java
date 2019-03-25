package br.com.saude.api.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.saude.api.db.report.AgendaReport;
import br.com.saude.api.db.report.TempoAtendimentoReport;
import br.com.saude.api.generic.CustomValidator;
import br.com.saude.api.generic.GenericService;
import br.com.saude.api.model.business.TarefaBo;
import br.com.saude.api.model.business.validate.TarefaValidator;
import br.com.saude.api.model.entity.filter.TarefaFilter;
import br.com.saude.api.model.entity.po.Tarefa;
import br.com.saude.api.util.RequestInterceptor;

@Path("tarefa")
@RequestInterceptor
public class TarefaService extends GenericService<Tarefa,TarefaFilter,TarefaBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=TarefaValidator.class)
	@Override
	public Response save(Tarefa tarefa) {		
		return super.save(tarefa);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(TarefaFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(TarefaFilter filter) {		
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
	public Response registrar(Tarefa tarefa) {		
		try {
			return Response.ok(getBo().registrar(tarefa)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cancelar")
	public Response cancelar(Tarefa tarefa) {		
		try {
			return Response.ok(getBo().cancelar(tarefa)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/report-agenda")
	public Response reportAgenda(TarefaFilter filter) {		
		try {
			return Response.ok(AgendaReport.getInstance().getList(filter)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/report-tempo-atendimento")
	public Response reportTempoAtendimento(TarefaFilter filter) {		
		try {
			return Response.ok(TempoAtendimentoReport.getInstance().getList(filter)).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
}
