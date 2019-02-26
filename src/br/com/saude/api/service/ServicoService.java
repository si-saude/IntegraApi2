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
import br.com.saude.api.model.business.ServicoBo;
import br.com.saude.api.model.business.validate.ServicoValidator;
import br.com.saude.api.model.entity.filter.ServicoFilter;
import br.com.saude.api.model.entity.po.Servico;
import br.com.saude.api.util.RequestInterceptor;

@Path("servico")
@RequestInterceptor
public class ServicoService extends GenericService<Servico,ServicoFilter,ServicoBo> {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CustomValidator(validatorClass=ServicoValidator.class)
	@Override
	public Response save(Servico servico) {		
		return super.save(servico);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response getList(ServicoFilter filter) {		
		return super.getList(filter);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/selectList")
	public Response getSelectList(ServicoFilter filter) {		
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
	@Path("/get-list-existe-tarefa-aberta-pendente-by-empregado")
	public Response getListExisteTarefaAbertaPendenteByEmpregado(String empregadoId) {		
		try {
			return Response.ok(getBo()
				.getListExisteTarefaAbertaPendenteByEmpregado(new Long(empregadoId))).build();
		}catch (Exception e) {
			return returnNotAcceptable(e);
		}
	}
}
