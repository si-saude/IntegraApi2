package br.com.saude.api.model.persistence;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.HibernateHelper;
import br.com.saude.api.model.entity.po.Servico;

public class ServicoDao extends GenericDao<Servico> {
	
	private static ServicoDao instance;
	
	private ServicoDao() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = servico -> {
			if(servico.getEquipes() != null)
				Hibernate.initialize(servico.getEquipes());
			return servico;
		};
	}
	
	public static ServicoDao getInstance() {
		if(instance == null)
			instance = new ServicoDao();
		return instance;
	}
	
	@Override
	public Servico getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Servico> getListExisteTarefaAbertaPendenteByEmpregado(long empregadoId) {
		Session session = HibernateHelper.getSession();
		List<Servico> servicos;
		try {
			Query<Servico> query = session.createQuery("select distinct s from Tarefa t "
								+ "inner join t.servico as s "
								+ "where t.cliente.id = " + empregadoId
								+ "  and ((t.status = 'ABERTA' and t.inicio = " + Helper.getToday()+") or "
										+ "(t.status = 'PENDENTE'))"
								+ "order by s.nome");
			servicos = query.list();
			
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
		return servicos;
	}
}
