package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Profissiograma;

public class ProfissiogramaDao extends GenericDao<Profissiograma> {

	private static ProfissiogramaDao instance;
	
	private ProfissiogramaDao() {
		super();
	}
	
	public static ProfissiogramaDao getInstance() {
		if(instance == null)
			instance = new ProfissiogramaDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = profissiograma -> {
			if(Helper.isNotNull(profissiograma.getProfissiogramaGrupos())) {
				Hibernate.initialize(profissiograma.getProfissiogramaGrupos());
			}
			return profissiograma;
		};
	}
	
	@Override
	public Profissiograma getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
