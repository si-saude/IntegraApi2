package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.ImovelBuilder;
import br.com.saude.api.model.creation.builder.example.ImovelExampleBuilder;
import br.com.saude.api.model.entity.filter.ImovelFilter;
import br.com.saude.api.model.entity.po.Imovel;
import br.com.saude.api.model.persistence.ImovelDao;

public class ImovelBo extends GenericBo<Imovel, ImovelFilter, ImovelDao, ImovelBuilder, 
	ImovelExampleBuilder> {

	private static ImovelBo instance;
	
	private ImovelBo() {
		super();
	}
	
	public static ImovelBo getInstance() {
		if(instance == null)
			instance = new ImovelBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadBase();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	@Override
	public PagedList<Imovel> getList(ImovelFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
	
	@Override
	public Imovel getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
