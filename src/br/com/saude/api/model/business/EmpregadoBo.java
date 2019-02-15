package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.EmpregadoBuilder;
import br.com.saude.api.model.creation.builder.example.EmpregadoExampleBuilder;
import br.com.saude.api.model.entity.filter.EmpregadoFilter;
import br.com.saude.api.model.entity.po.Empregado;
import br.com.saude.api.model.persistence.EmpregadoDao;

public class EmpregadoBo extends GenericBo<Empregado, EmpregadoFilter, EmpregadoDao, EmpregadoBuilder, 
	EmpregadoExampleBuilder> {

	private static EmpregadoBo instance;
	
	private EmpregadoBo() {
		super();
	}
	
	public static EmpregadoBo getInstance() {
		if(instance == null)
			instance = new EmpregadoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadBase().loadCargo().loadEnfase().loadFuncao()
						.loadGerencia().loadGhe().loadGhee().loadGrupoMonitoramentos()
						.loadPessoa().loadRegime();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	@Override
	public PagedList<Empregado> getList(EmpregadoFilter filter) throws Exception {
		return super.getOrderedList(filter,"matricula");
	}
	
	@Override
	public Empregado getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
