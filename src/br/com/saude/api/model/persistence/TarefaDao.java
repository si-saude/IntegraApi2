package br.com.saude.api.model.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.HibernateHelper;
import br.com.saude.api.model.entity.po.Tarefa;
import br.com.saude.api.util.constant.StatusTarefa;

public class TarefaDao extends GenericDao<Tarefa> {

	private static TarefaDao instance;
	
	private TarefaDao() {
		super();
	}
	
	public static TarefaDao getInstance() {
		if(instance == null)
			instance = new TarefaDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = tarefa -> {
			if(tarefa.getCliente() != null) {
				Hibernate.initialize(tarefa.getCliente());
			}
			if(tarefa.getEquipe() != null) {
				Hibernate.initialize(tarefa.getEquipe());
			}
			if(tarefa.getResponsavel() != null) {
				Hibernate.initialize(tarefa.getResponsavel());
			}
			if(tarefa.getServico() != null) {
				Hibernate.initialize(tarefa.getServico());
			}
			return tarefa;
		};
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Tarefa> getListTarefasByCheckin(long empregadoId, long servicoId) {
		Session session = HibernateHelper.getSession();
		List<Tarefa> tarefas;
		try {
			Query<Tarefa> query = session.createQuery("select distinct t from Tarefa t "
								+ "where t.cliente.id = " + empregadoId
								+ "  and t.servico.id = " + servicoId
								+ "  and ((t.status = '"+StatusTarefa.getInstance().ABERTA+"' and t.inicio = "+ Helper.getToday() +") or "
										+ "(t.status = '"+StatusTarefa.getInstance().PENDENTE+"'))");
			tarefas = query.list();
			
			if(Helper.isNotNull(tarefas)) {
				
				Optional<Long> optional = tarefas.stream().filter(t->t.getStatus().equals(StatusTarefa.getInstance().PENDENTE))
						.map(t->t.getInicio()).findFirst();
				
				if(optional.isPresent()) {
					List<Tarefa> concluidas;
					query = session.createQuery("select distinct t from Tarefa t "
							+ "where t.cliente.id = " + empregadoId
							+ "  and t.servico.id = " + servicoId
							+ "  and t.status = '"+StatusTarefa.getInstance().CONCLUIDA+"' "
							+ "  and t.inicio between " + optional.get() + " and " + Helper.getNow());
					
					concluidas = query.list();
					if(Helper.isNotNull(concluidas)) {
						tarefas.addAll(concluidas);
					}
				}
			}
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
		return tarefas;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Tarefa> getListTarefasAbertasPendentesByAtendimento(long empregadoId, long equipeId, long servicoId) {
		Session session = HibernateHelper.getSession();
		List<Tarefa> tarefas;
		try {
			Query<Tarefa> query = session.createQuery("select distinct t from Tarefa t "
								+ "where t.cliente.id = " + empregadoId
								+ "  and t.servico.id = " + servicoId
								+ "  and t.equipe.id = " + equipeId
								+ "  and t.status in ('" + StatusTarefa.getInstance().ABERTA + "','" 
									+ StatusTarefa.getInstance().PENDENTE + "')");
			tarefas = query.list();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
		return tarefas;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Tarefa> getListTarefasAbertasPendentesConcluidasByAtendimento(long empregadoId, long servicoId) {
		Session session = HibernateHelper.getSession();
		List<Tarefa> tarefas;
		try {
			Query<Tarefa> query = session.createQuery("select distinct t from Tarefa t "
								+ "where t.cliente.id = " + empregadoId
								+ "  and t.servico.id = " + servicoId
								+ "  and t.status in ('" + StatusTarefa.getInstance().ABERTA + "','" 
									+ StatusTarefa.getInstance().PENDENTE + "')");
			tarefas = query.list();
			
			if(Helper.isNotNull(tarefas)) {
				
				Optional<Long> optional = tarefas.stream().filter(t->t.getStatus().equals(StatusTarefa.getInstance().PENDENTE))
						.map(t->t.getInicio()).findFirst();
				
				if(optional.isPresent()) {
					List<Tarefa> concluidas;
					query = session.createQuery("select distinct t from Tarefa t "
							+ "where t.cliente.id = " + empregadoId
							+ "  and t.servico.id = " + servicoId
							+ "  and t.status = '"+StatusTarefa.getInstance().CONCLUIDA+"' "
							+ "  and t.inicio between " + optional.get() + " and " + Helper.getNow());
					
					concluidas = query.list();
					if(Helper.isNotNull(concluidas)) {
						tarefas.addAll(concluidas);
					}
				}
			}
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
		return tarefas;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Tarefa> getListTarefasAbertasByData(long empregadoId, long servicoId, long data) {
		Session session = HibernateHelper.getSession();
		List<Tarefa> tarefas;
		try {
			Query<Tarefa> query = session.createQuery("select distinct t from Tarefa t "
								+ "where t.cliente.id = " + empregadoId
								+ "  and t.servico.id = " + servicoId
								+ "  and ((t.status = '" + StatusTarefa.getInstance().ABERTA + "') or"
									  + " (t.status = '" + StatusTarefa.getInstance().PENDENTE + "'))"
									  + "  and t.inicio between " + data + " and " + Helper.addDays(data, 1));
			tarefas = query.list();
			
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
		return tarefas;
	}
}
