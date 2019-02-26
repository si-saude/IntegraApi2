package br.com.saude.api.model.persistence;

import java.util.List;
import java.util.Objects;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.saude.api.generic.GenericDao;
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
								+ "inner join t.cliente as c "
								+ "where c.id = "+Objects.toString(empregadoId)
								+ "  and t.status in ('ABERTA','PENDENTE') "
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
