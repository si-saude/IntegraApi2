package br.com.saude.api.db.report;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.HibernateHelper;
import br.com.saude.api.model.entity.dto.TempoAtendimentoDto;
import br.com.saude.api.model.entity.filter.TarefaFilter;

public class TempoAtendimentoReport {

	private static TempoAtendimentoReport instance;
	
	private TempoAtendimentoReport() {
		
	}
	
	public static TempoAtendimentoReport getInstance() {
		if(instance == null)
			instance = new TempoAtendimentoReport();
		return instance;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<TempoAtendimentoDto> getList(TarefaFilter filter) {
		
		List<TempoAtendimentoDto> tempoAtendimentos = new ArrayList<TempoAtendimentoDto>();
		
		String query = "select empregado, equipe, profissional, inicio, fim, duracao, " + 
				"chegada, coalesce(saida,0) as saida, status, " + 
				"    CASE WHEN coalesce(saida,0) != 0 " + 
				"        THEN (saida - chegada) " + 
				"        ELSE 0 END as tempo_total " + 
				"from ( " + 
				"    select p.nome as empregado, " + 
				"        eq.nome as equipe, " + 
				"        PP.NOME as profissional, " + 
				"        t.inicio, " + 
				"        t.fim, " + 
				"        (t.fim - t.inicio)/1000/60 as duracao, " + 
				"        c.chegada, " + 
				"        (select tt.fim " + 
				"        from tarefa tt " + 
				"        inner join checkin_tarefa ct2 on tt.id = ct2.tarefa_id " + 
				"        inner join atendimento a on a.tarefa_id = tt.id " + 
				"        where ct2.checkin_id = c.id " + 
				"          and a.acolhimento = true) as saida, " + 
				"          c.status " + 
				"    from tarefa t " + 
				"    inner join empregado e on t.cliente_id = e.id " + 
				"    inner join pessoa p on e.pessoa_id = p.id " + 
				"    inner join equipe eq on t.equipe_id = eq.id " + 
				"    inner join profissional pro on pro.id = t.responsavel_id " + 
				"    inner join empregado pe on pe.id = pro.empregado_id " + 
				"    inner join pessoa pp on pp.id = pe.pessoa_id " + 
				"    inner join checkin_tarefa ct on ct.tarefa_id = t.id " + 
				"    inner join checkin c on c.id = ct.checkin_id " + 
				"    where (t.fim - t.inicio) > 0 " + 
				"      and c.chegada between " + filter.getInicio().getInicio() +
				" and " + (Helper.addDays(filter.getInicio().getFim(),1) - 1) +
				")x " + 
				"order by empregado, inicio";
		
		List<Object[]> list = new ArrayList<Object[]>();
		Session session = HibernateHelper.getSession();
		
		try {
			list = session.createSQLQuery(query).list();
		} catch (Exception ex) {
			throw ex;
		} finally {
			HibernateHelper.close(session);
		}
		
		TempoAtendimentoDto dto = null;
		
		for (Object[] row : list) {
			dto = new TempoAtendimentoDto();
			dto.setEmpregado((String) row[0]);
			dto.setEquipe((String) row[1]);
			dto.setProfissional((String) row[2]);
			dto.setInicio(((BigInteger) row[3]).longValue());
			dto.setFim(((BigInteger) row[4]).longValue());
			dto.setDuracao(((BigInteger) row[5]).longValue());
			dto.setChegada(((BigInteger) row[6]).longValue());
			dto.setSaida(((BigInteger) row[7]).longValue());
			dto.setStatus((String) row[8]);
			dto.setTempoTotal(((BigInteger) row[9]).longValue());
			tempoAtendimentos.add(dto);
		}
		
		return tempoAtendimentos;
	}
}
