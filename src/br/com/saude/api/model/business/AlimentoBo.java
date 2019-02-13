package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.AlimentoBuilder;
import br.com.saude.api.model.creation.builder.example.AlimentoExampleBuilder;
import br.com.saude.api.model.entity.filter.AlimentoFilter;
import br.com.saude.api.model.entity.po.Alimento;
import br.com.saude.api.model.persistence.AlimentoDao;

public class AlimentoBo extends GenericBo<Alimento, AlimentoFilter, AlimentoDao, AlimentoBuilder, 
AlimentoExampleBuilder> {

	private static AlimentoBo instance;
	
	private AlimentoBo() {
		super();
	}
	
	public static AlimentoBo getInstance() {
		if(instance == null)
			instance = new AlimentoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadAlimentosMedidaCaseira().loadSubstituicoes();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	@Override
	public Alimento getById(Object id) throws Exception {
		return this.getById(id, this.functionLoadAll);
	}

	@Override
	public PagedList<Alimento> getList(AlimentoFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
	
	@Override
	public Alimento save(Alimento alimento) throws Exception {
		if(Helper.isNotNull(alimento.getAlimentosMedidaCaseira())) {
			alimento.getAlimentosMedidaCaseira().forEach(i->i.setAlimento(alimento));
		}
		
		return super.save(alimento);
	}
}
