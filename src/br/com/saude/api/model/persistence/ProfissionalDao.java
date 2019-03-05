package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.entity.po.Profissional;

public class ProfissionalDao extends GenericDao<Profissional> {
	
	private static ProfissionalDao instance;
	
	private ProfissionalDao() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = profissional -> {
			
			if(profissional.getCurriculo() != null)
				Hibernate.initialize(profissional.getCurriculo());
			
			if(profissional.getRegistro() != null)
				Hibernate.initialize(profissional.getRegistro());
			
			if(Helper.isNotNull(profissional.getEquipes())) {
				Hibernate.initialize(profissional.getEquipes());
			}
			
			if(Helper.isNotNull(profissional.getServicos())) {
				Hibernate.initialize(profissional.getServicos());
			}

			return profissional;
		};
		
		this.functionLoad = profissional -> {
			if(Helper.isNotNull(profissional.getEquipes())) {
				Hibernate.initialize(profissional.getEquipes());
			}
			return profissional;
		};
	}
	
	public static ProfissionalDao getInstance() {
		if(instance == null)
			instance = new ProfissionalDao();
		return instance;
	}
	
	@Override
	public Profissional getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
	
	public PagedList<Profissional> getListEquipes(GenericExampleBuilder<?, ?> exampleBuilder) throws Exception {
		return super.getList(exampleBuilder, this.functionLoad);
	}
}
