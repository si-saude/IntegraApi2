package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;
import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Questionario;

public class QuestionarioDao extends GenericDao<Questionario> {
	
	private static QuestionarioDao instance;
	
	private QuestionarioDao() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = questionario -> {
			if(Helper.isNotNull(questionario.getQuestoes()))
				Hibernate.initialize(questionario.getQuestoes());
			return questionario;
		};
	}
	
	public static QuestionarioDao getInstance() {
		if(instance == null)
			instance = new QuestionarioDao();
		return instance;
	}
	
	@Override
	public Questionario getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
