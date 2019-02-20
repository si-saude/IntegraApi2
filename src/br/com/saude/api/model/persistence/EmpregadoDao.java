package br.com.saude.api.model.persistence;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.filter.EmpregadoFilter;
import br.com.saude.api.model.entity.po.Empregado;

public class EmpregadoDao extends GenericDao<Empregado> {
	
	private static EmpregadoDao instance;
	
	private EmpregadoDao() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = empregado -> {
			if(empregado.getCargo() != null)
				Hibernate.initialize(empregado.getCargo());
			if(empregado.getFuncao() != null)
				Hibernate.initialize(empregado.getFuncao());
			if(empregado.getEnfase() != null)
				Hibernate.initialize(empregado.getEnfase());
			if(empregado.getRegime() != null)
				Hibernate.initialize(empregado.getRegime());
			if(empregado.getGerencia() != null)
				Hibernate.initialize(empregado.getGerencia());
			if(empregado.getBase() != null)
				Hibernate.initialize(empregado.getBase());
			if(empregado.getGhe() != null)
				Hibernate.initialize(empregado.getGhe());
			if(empregado.getGhee() != null)
				Hibernate.initialize(empregado.getGhee());
			
			if(Helper.isNotNull(empregado.getGrupoMonitoramentos())) {
				Hibernate.initialize(empregado.getGrupoMonitoramentos());
			}
			
			if(Helper.isNotNull(empregado.getPessoa().getTelefones())) {
				Hibernate.initialize(empregado.getPessoa().getTelefones());
			}
			
			if(empregado.getPessoa().getEndereco() != null) {
				Hibernate.initialize(empregado.getPessoa().getEndereco());
			}
			
			return empregado;
		};
	}
	
	public static EmpregadoDao getInstance() {
		if(instance == null)
			instance = new EmpregadoDao();
		return instance;
	}
	
	@Override
	public Empregado getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
	
	@Override
	protected Criteria finishCriteria(Criteria criteria, GenericExampleBuilder<?, ?> exampleBuilder) {
		EmpregadoFilter filter = (EmpregadoFilter)exampleBuilder.getFilter();
		
		if(Helper.isNotNull(filter.getGerencia())) {
			if(filter.getGerencia().getCodigoCompleto() != null && 
					!filter.getGerencia().getCodigoCompleto().trim().replaceAll("/", "").equals("") ) {
				String[] gerencias = filter.getGerencia().getCodigoCompleto().split("/");
				
				criteria.createAlias("gerencia", "gerencia0", JoinType.LEFT_OUTER_JOIN);
				criteria.createAlias("gerencia0.gerencia", "gerencia1", JoinType.LEFT_OUTER_JOIN);
				criteria.createAlias("gerencia1.gerencia", "gerencia2", JoinType.LEFT_OUTER_JOIN);
				criteria.createAlias("gerencia2.gerencia", "gerencia3", JoinType.LEFT_OUTER_JOIN);
				criteria.createAlias("gerencia3.gerencia", "gerencia4", JoinType.LEFT_OUTER_JOIN);
				criteria.createAlias("gerencia4.gerencia", "gerencia5", JoinType.LEFT_OUTER_JOIN);
				
				Criterion or = null;
				int i = 0;
				for(int x = gerencias.length - 1; x <= 5; x++) {
					Criterion and = null;
					for(int y = i; y < gerencias.length + i; y++) {
						if(and == null) {
							and = Restrictions.ilike("gerencia"+y+".codigo",Helper.filterLike(gerencias[x-y]));
						}else {
							and = Restrictions.and(and, Restrictions.ilike("gerencia"+y+".codigo",Helper.filterLike(gerencias[x-y])));
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
			}else if(filter.getGerencia().getId() > 0) {
				criteria.add(Restrictions.eq("gerencia.id", filter.getGerencia().getId()));
			}
		}
		
		return criteria;
	}
}
