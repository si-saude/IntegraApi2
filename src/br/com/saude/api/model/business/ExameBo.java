package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.ExameBuilder;
import br.com.saude.api.model.creation.builder.example.ExameExampleBuilder;
import br.com.saude.api.model.entity.filter.ExameFilter;
import br.com.saude.api.model.entity.po.Exame;
import br.com.saude.api.model.persistence.ExameDao;

public class ExameBo extends GenericBo<Exame, ExameFilter, ExameDao, 
										ExameBuilder, ExameExampleBuilder>{
	
	private static ExameBo instance;
	
	private ExameBo() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadCampos();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	public static ExameBo getInstance() {
		if(instance == null)
			instance = new ExameBo();
		return instance;
	}
	
	@Override
	public Exame getById(Object id) throws Exception {
		return this.getById(id, this.functionLoadAll);
	}
	
	@Override
	public PagedList<Exame> getList(ExameFilter filter) throws Exception {
		return super.getOrderedList(filter,"descricao");
	}
	
	@Override
	public Exame save(Exame exame) throws Exception {
		if(Helper.isNotNull(exame.getCampoExames()))
			exame.getCampoExames().forEach(c->c.setExame(exame));
		return super.save(exame);
	}
}
