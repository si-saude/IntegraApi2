package br.com.saude.api.model.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
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
			session.createSQLQuery("select atendimentoLiberar(" + atendimento.getId() + ","+Helper.getNow()+")").uniqueResult();
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
						",'" + atendimento.getFila().getStatus() + "'," + Helper.getNow() +")")
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
						"','" + atendimento.getCheckin().getStatus() + "'," + Helper.getNow() +")")
				.uniqueResult();
			transaction.commit();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> getListAtendimentosAguardandoEmpregadoByLocalizacao(long localizacaoId) {
		Session session = HibernateHelper.getSession();
		List<Atendimento> atendimentos;
		try {
			Query<Atendimento> query = session
					.createQuery("select distinct a from Atendimento a "
								+ "inner join a.fila as f "
								+ "where f.status = '" + StatusFilaAtendimento.getInstance().AGUARDANDO_EMPREGADO
								+ "'  and f.localizacao.id = " + localizacaoId
								+ "  and f.data = " + Helper.getToday());
			atendimentos = query.list();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
		return atendimentos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> getListFilasAtendimentoByLocalizacao(long localizacaoId) {
		Session session = HibernateHelper.getSession();
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();
		try {
			Query<Object[]> query = session
					.createQuery("select a, f from Atendimento a "
								+ "right join a.fila as f "
								+ "where f.localizacao.id = " + localizacaoId
								+ "  and f.data = " + Helper.getToday());
			List<Object[]> result = query.list();
			if(Helper.isNotNull(result)) {
				for(Object[] r : result) {
					Atendimento a;
					if(r[0] != null) {
						a = (Atendimento)r[0]; 
					} else {
						a = new Atendimento();
						a.setFila((FilaAtendimento)r[1]);
					}
					atendimentos.add(a);
				}
			}
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
		return atendimentos;
	}
}
