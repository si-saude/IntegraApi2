package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.DiagnosticoBuilder;
import br.com.saude.api.model.creation.builder.example.DiagnosticoExampleBuilder;
import br.com.saude.api.model.entity.filter.DiagnosticoFilter;
import br.com.saude.api.model.entity.po.Diagnostico;
import br.com.saude.api.model.persistence.DiagnosticoDao;

public class DiagnosticoBo extends GenericBo<Diagnostico, DiagnosticoFilter, DiagnosticoDao, DiagnosticoBuilder, 
	DiagnosticoExampleBuilder> {

	private static DiagnosticoBo instance;
	
	private DiagnosticoBo() {
		super();
	}
	
	public static DiagnosticoBo getInstance() {
		if(instance == null)
			instance = new DiagnosticoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Diagnostico> getList(DiagnosticoFilter filter) throws Exception {
		return super.getOrderedList(filter,"codigo");
	}
}
