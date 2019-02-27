package br.com.saude.api.service;

import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.saude.api.generic.GenericConstant;
import br.com.saude.api.util.RequestInterceptor;
import br.com.saude.api.util.StringSorter;
import br.com.saude.api.util.constant.Escolaridade;
import br.com.saude.api.util.constant.EstadoCivil;
import br.com.saude.api.util.constant.GrupoServico;
import br.com.saude.api.util.constant.Operador;
import br.com.saude.api.util.constant.Sexo;
import br.com.saude.api.util.constant.StatusCheckin;
import br.com.saude.api.util.constant.StatusEmpregado;
import br.com.saude.api.util.constant.StatusFilaAtendimento;
import br.com.saude.api.util.constant.StatusTarefa;
import br.com.saude.api.util.constant.TipoCriterio;
import br.com.saude.api.util.constant.TipoAlimento;
import br.com.saude.api.util.constant.TipoPerguntaFichaColeta;
import br.com.saude.api.util.constant.TipoQuestao;
import br.com.saude.api.util.constant.TipoQuestionario;
import br.com.saude.api.util.constant.TypeFilter;
import br.com.saude.api.util.constant.Uf;
import br.com.saude.api.util.constant.VinculoEmpregado;

@Path("generic")
@RequestInterceptor
public class UtilService {

	private Map<String,String> getMap(GenericConstant constant, String filter) throws IllegalArgumentException, IllegalAccessException{
		return constant.getList().entrySet().stream() 
		.filter(f-> filter!=null?f.getValue().toLowerCase().contains(filter.toLowerCase()):true)
		.collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
	}
	
	private Object[] getValues(GenericConstant constant, String filter) throws Exception {
		Map<String, String> map = getMap(constant,filter);
		return map.values().toArray();
	}
	
	@GET
	@Path("/escolaridade")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEscolaridade(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(Escolaridade.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/estado-civil")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEstadoCivil(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(EstadoCivil.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/grupo-servico")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrupoServico(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(GrupoServico.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/operador")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOperador(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(Operador.getInstance(), filter);
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/sexo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSexo(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(Sexo.getInstance(), filter);
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/status-checkin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStatusCheckin(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(StatusCheckin.getInstance(), filter);
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/status-empregado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStatusEmpregado(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(StatusEmpregado.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/status-fila-atendimento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStatusFilaAtendimento(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(StatusFilaAtendimento.getInstance(), filter);
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/status-tarefa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStatusTarefa(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(StatusTarefa.getInstance(), filter);
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/tipo-alimento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTipoAlimento(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(TipoAlimento.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/tipo-criterio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTipoCriterio(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(TipoCriterio.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/tipo-pergunta-ficha-coleta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTipoPerguntaFichaColeta(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(TipoPerguntaFichaColeta.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/tipo-questao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTipoQuestao(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(TipoQuestao.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/tipo-questionario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTipoQuestionario(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(TipoQuestionario.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/type-filter")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTypeFilter(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(TypeFilter.getInstance(), filter);
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/uf")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUf(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(Uf.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
	
	@GET
	@Path("/vinculo-empregado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVinculoEmpregado(@QueryParam("filter") String filter) throws Exception {
		Object[] values = this.getValues(VinculoEmpregado.getInstance(), filter);
		values = StringSorter.newInstance(values).sort().get();
		return Response.ok(values).build();
	}
}
