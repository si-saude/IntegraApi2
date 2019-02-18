package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.QuestionarioBuilder;
import br.com.saude.api.model.creation.builder.example.QuestionarioExampleBuilder;
import br.com.saude.api.model.entity.filter.QuestionarioFilter;
import br.com.saude.api.model.entity.po.Questionario;
import br.com.saude.api.model.persistence.QuestionarioDao;

public class QuestionarioBo extends GenericBo<Questionario, QuestionarioFilter, QuestionarioDao, QuestionarioBuilder, 
	QuestionarioExampleBuilder> {

	private static QuestionarioBo instance;
	
	private QuestionarioBo() {
		super();
	}
	
	public static QuestionarioBo getInstance() {
		if(instance == null)
			instance = new QuestionarioBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadQuestoes();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	@Override
	public PagedList<Questionario> getList(QuestionarioFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
	
	@Override
	public Questionario getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
