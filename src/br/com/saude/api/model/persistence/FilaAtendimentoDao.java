package br.com.saude.api.model.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.HibernateHelper;
import br.com.saude.api.model.entity.po.FilaAtendimento;

public class FilaAtendimentoDao extends GenericDao<FilaAtendimento> {

	private static FilaAtendimentoDao instance;
	
	private FilaAtendimentoDao() {
		super();
	}
	
	public static FilaAtendimentoDao getInstance() {
		if(instance == null)
			instance = new FilaAtendimentoDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<FilaAtendimento> getListDisponivel(long localizacaoId, long equipeId) {
		Session session = HibernateHelper.getSession();
		List<FilaAtendimento> filas;
		
		try {
			Query<FilaAtendimento> query = session.createQuery("select distinct f from FilaAtendimento f "
															+ "inner join f.profissional as p "
															+ "inner join p.equipes as e "
															+ "where f.localizacao.id = " + localizacaoId
															+ "  and f.status = 'DISPONÍVEL' "
															+ "  and f.data = " + Helper.getToday()
															+ "  and e.id = " + equipeId);
			filas = query.list();
		}catch (Exception ex) {
			throw ex;
		}
		finally {
			HibernateHelper.close(session);
		}
		return filas;
	}
}
