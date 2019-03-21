package br.com.saude.api.db.report;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.HibernateHelper;
import br.com.saude.api.model.entity.dto.AgendaDto;
import br.com.saude.api.model.entity.filter.TarefaFilter;

public class AgendaReport {

	private static AgendaReport instance;
	
	private AgendaReport() {
		
	}
	
	public static AgendaReport getInstance() {
		if(instance == null)
			instance = new AgendaReport();
		return instance;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<AgendaDto> getList(TarefaFilter filter) {
		
		List<AgendaDto> agendas = new ArrayList<AgendaDto>();
		
		String query = "select e.matricula||' - '||p.nome, s.nome, "
				+ " (extract(epoch from date_trunc('day', to_timestamp(t.inicio/1000))) * 1000) as data, "
				+ "t.status, string_agg(eq.abreviacao, ' - ') " + 
				"from tarefa t " + 
				"inner join servico s on t.servico_id = s.id " + 
				"inner join empregado e on t.cliente_id = e.id " + 
				"inner join pessoa p on e.pessoa_id = p.id " + 
				"inner join equipe eq on t.equipe_id = eq.id " +
				"where t.inicio between " + filter.getInicio().getInicio() + 
					" and " + (Helper.addDays(filter.getInicio().getFim(),1) - 1) + 
				" group by e.matricula||' - '||p.nome, s.nome, "
				+ "extract(epoch from date_trunc('day', to_timestamp(t.inicio/1000))) * 1000, "
				+ "t.status " +
				"order by 3";
		
		List<Object[]> list = new ArrayList<Object[]>();
		Session session = HibernateHelper.getSession();
		
		try {
			list = session.createSQLQuery(query).list();
		} catch (Exception ex) {
			throw ex;
		} finally {
			HibernateHelper.close(session);
		}
		
		AgendaDto dto = null;
		
		for (Object[] row : list) {
			dto = new AgendaDto();
			dto.setCliente((String) row[0]);
			dto.setServico((String) row[1]);
			dto.setData(((Double) row[2]).longValue());
			dto.setStatus((String) row[3]);
			dto.setStatus((String) row[3]);
			dto.setEquipes((String) row[4]);
			agendas.add(dto);
		}
		
		return agendas;
	}
}
