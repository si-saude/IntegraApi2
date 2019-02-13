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
import br.com.saude.api.util.constant.Operador;
import br.com.saude.api.util.constant.Sexo;
import br.com.saude.api.util.constant.TipoCriterio;
import br.com.saude.api.util.constant.TipoAlimento;
import br.com.saude.api.util.constant.TypeFilter;
import br.com.saude.api.util.constant.Uf;

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
}
