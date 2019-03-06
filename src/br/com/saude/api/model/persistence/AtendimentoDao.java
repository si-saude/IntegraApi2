package br.com.saude.api.model.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.HibernateHelper;
import br.com.saude.api.model.entity.po.Atendimento;
import br.com.saude.api.model.entity.po.Checkin;
import br.com.saude.api.model.entity.po.FilaAtendimento;
import br.com.saude.api.util.constant.StatusFilaAtendimento;

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
	public void iniciar(Atendimento atendimento) {
		Session session = HibernateHelper.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.merge(atendimento);
			session.createSQLQuery("select atendimentoIniciar(" + atendimento.getId() + ")").uniqueResult();
			transaction.commit();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void liberar(Atendimento atendimento) {
		Session session = HibernateHelper.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.merge(atendimento);
			session.createSQLQuery("select atendimentoLiberar(" + atendimento.getId() + ")").uniqueResult();
			transaction.commit();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void finalizar(Atendimento atendimento) {
		Session session = HibernateHelper.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			
			FilaAtendimento fila = session.get(FilaAtendimento.class, atendimento.getFila().getId());
			if(fila.getStatus().equals(StatusFilaAtendimento.getInstance().LANCAMENTO_DE_INFORMACOES)) {
				atendimento.setCheckin(session.get(Checkin.class, atendimento.getCheckin().getId()));
			}
			
			session.merge(atendimento);
			session
				.createSQLQuery("select atendimentoFinalizar(" + atendimento.getId() + 
						",'" + atendimento.getFila().getStatus() + "')")
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
	public void cancelar(Atendimento atendimento) {
		Session session = HibernateHelper.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session
				.createSQLQuery("select atendimentoCancelar(" + atendimento.getId() + 
						",'" + atendimento.getFila().getStatus() + 
						"','" + atendimento.getCheckin().getStatus() + "')")
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
