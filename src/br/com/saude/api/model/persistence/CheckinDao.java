package br.com.saude.api.model.persistence;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.Checkin;

public class CheckinDao extends GenericDao<Checkin> {

	private static CheckinDao instance;
	
	private CheckinDao() {
		super();
	}
	
	public static CheckinDao getInstance() {
		if(instance == null)
			instance = new CheckinDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {

	}
}
