package br.com.saude.api.model.persistence;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.MedidaCaseira;

public class MedidaCaseiraDao extends GenericDao<MedidaCaseira> {

	private static MedidaCaseiraDao instance;
	
	private MedidaCaseiraDao() {
		super();
	}
	
	public static MedidaCaseiraDao getInstance() {
		if(instance == null)
			instance = new MedidaCaseiraDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
}
