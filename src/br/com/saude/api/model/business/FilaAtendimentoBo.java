package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.FilaAtendimentoBuilder;
import br.com.saude.api.model.creation.builder.example.FilaAtendimentoExampleBuilder;
import br.com.saude.api.model.entity.filter.FilaAtendimentoFilter;
import br.com.saude.api.model.entity.po.FilaAtendimento;
import br.com.saude.api.model.persistence.FilaAtendimentoDao;

public class FilaAtendimentoBo extends GenericBo<FilaAtendimento, FilaAtendimentoFilter, FilaAtendimentoDao, FilaAtendimentoBuilder, 
	FilaAtendimentoExampleBuilder> {

	private static FilaAtendimentoBo instance;
	
	private FilaAtendimentoBo() {
		super();
	}
	
	public static FilaAtendimentoBo getInstance() {
		if(instance == null)
			instance = new FilaAtendimentoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<FilaAtendimento> getList(FilaAtendimentoFilter filter) throws Exception {
		return super.getDescOrderedList(filter,"data");
	}
}
