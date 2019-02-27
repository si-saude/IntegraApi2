package br.com.saude.api.model.persistence;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.HibernateHelper;
import br.com.saude.api.model.entity.po.Tarefa;

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
								+ "  and ((t.status = 'ABERTA' and t.inicio = " + Helper.getToday()+") or "
										+ "(t.status = 'PENDENTE'))");
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
