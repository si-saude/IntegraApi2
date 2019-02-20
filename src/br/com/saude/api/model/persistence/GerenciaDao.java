package br.com.saude.api.model.persistence;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.filter.GerenciaFilter;
import br.com.saude.api.model.entity.po.Gerencia;

public class GerenciaDao extends GenericDao<Gerencia> {

	private static GerenciaDao instance;
	
	private GerenciaDao() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		
	}
	
	public static GerenciaDao getInstance() {
		if(instance==null)
			instance = new GerenciaDao();
		return instance;
	}
	
	@Override
	protected Criteria finishCriteria(Criteria criteria, GenericExampleBuilder<?, ?> gerenciaExampleBuilder) {
		
		GerenciaFilter filter = (GerenciaFilter) gerenciaExampleBuilder.getFilter();
		
		if(filter.getCodigoCompleto() != null && 
				!filter.getCodigoCompleto().trim().replaceAll("/", "").equals("") ) {
			String[] gerencias = filter.getCodigoCompleto().split("/");
			
			criteria.createAlias("gerencia", "gerencia1", JoinType.LEFT_OUTER_JOIN);
			criteria.createAlias("gerencia1.gerencia", "gerencia2", JoinType.LEFT_OUTER_JOIN);
			criteria.createAlias("gerencia2.gerencia", "gerencia3", JoinType.LEFT_OUTER_JOIN);
			criteria.createAlias("gerencia3.gerencia", "gerencia4", JoinType.LEFT_OUTER_JOIN);
			criteria.createAlias("gerencia4.gerencia", "gerencia5", JoinType.LEFT_OUTER_JOIN);
			criteria.createAlias("gerencia5.gerencia", "gerencia6", JoinType.LEFT_OUTER_JOIN);
			
			Criterion or = null;
			int i = 0;
			for(int x = gerencias.length - 1; x <= 6; x++) {
				Criterion and = null;
				for(int y = i; y < gerencias.length + i; y++) {
					if(and == null) {
						and = Restrictions.ilike(checarCondicao("gerencia"+y),Helper.filterLike(gerencias[x-y]));
					}else {
						and = Restrictions.and(and, Restrictions.ilike(checarCondicao("gerencia"+y),Helper.filterLike(gerencias[x-y])));
					}
				}
				
				if(or == null) {
					or = and;
				}else {
					or = Restrictions.or(or, and);
				}
				i++;
			}
			
			criteria.add(or);
		}
		
		return criteria;
	}
	
	private String checarCondicao(String condicao) {
		if(condicao.contains("0"))
			return "codigo";
		return condicao+".codigo";
	}
}
