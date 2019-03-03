package br.com.saude.api.model.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.HibernateHelper;
import br.com.saude.api.model.entity.po.Atendimento;

public class AtendimentoDao extends GenericDao<Atendimento> {

	private static AtendimentoDao instance;
	
	private AtendimentoDao() {
		super();
	}
	
	public static AtendimentoDao getInstance() {
		if(instance == null)
			instance = new AtendimentoDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@SuppressWarnings("deprecation")
	public void iniciar(long id) {
		Session session = HibernateHelper.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.createSQLQuery("select atendimentoIniciar(" + id + ")").uniqueResult();
			transaction.commit();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void liberar(long id) {
		Session session = HibernateHelper.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.createSQLQuery("select atendimentoLiberar(" + id + ")").uniqueResult();
			transaction.commit();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void finalizar(long id, String statusFila) {
		Session session = HibernateHelper.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session
				.createSQLQuery("select atendimentoFinalizar(" + id + ",'" + statusFila + "')")
				.uniqueResult();
			transaction.commit();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void cancelar(long id, String statusFila, String statusCheckin) {
		Session session = HibernateHelper.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session
				.createSQLQuery("select atendimentoCancelar(" + id + ",'" + statusFila + "','" + statusCheckin + "')")
				.uniqueResult();
			transaction.commit();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
	}
}
