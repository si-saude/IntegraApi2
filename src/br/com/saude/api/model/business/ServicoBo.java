package br.com.saude.api.model.business;

import java.util.List;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.ServicoBuilder;
import br.com.saude.api.model.creation.builder.example.ServicoExampleBuilder;
import br.com.saude.api.model.entity.filter.ServicoFilter;
import br.com.saude.api.model.entity.po.Servico;
import br.com.saude.api.model.persistence.ServicoDao;

public class ServicoBo extends GenericBo<Servico, ServicoFilter, ServicoDao, 
										ServicoBuilder, ServicoExampleBuilder>{
	
	private static ServicoBo instance;
	
	private ServicoBo() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadEquipes();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	public static ServicoBo getInstance() {
		if(instance == null)
			instance = new ServicoBo();
		return instance;
	}
	
	@Override
	public Servico getById(Object id) throws Exception {
		return this.getById(id, this.functionLoadAll);
	}
	
	@Override
	public PagedList<Servico> getList(ServicoFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
	
	public List<Servico> getListExisteTarefaAbertaPendenteByEmpregado(long empregadoId) throws Exception {
		return getBuilder(getDao().getListExisteTarefaAbertaPendenteByEmpregado(empregadoId)).getEntityList();
	}
}
