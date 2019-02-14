package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;
import br.com.saude.api.generic.GenericDao;
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
}
