package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.RegraAtendimentoBuilder;
import br.com.saude.api.model.creation.builder.example.RegraAtendimentoExampleBuilder;
import br.com.saude.api.model.entity.filter.RegraAtendimentoFilter;
import br.com.saude.api.model.entity.po.RegraAtendimento;
import br.com.saude.api.model.persistence.RegraAtendimentoDao;

public class RegraAtendimentoBo extends GenericBo<RegraAtendimento, RegraAtendimentoFilter, RegraAtendimentoDao, 
										RegraAtendimentoBuilder, RegraAtendimentoExampleBuilder>{
	
	private static RegraAtendimentoBo instance;
	
	private RegraAtendimentoBo() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadRegraAtendimentoEquipes();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	public static RegraAtendimentoBo getInstance() {
		if(instance == null)
			instance = new RegraAtendimentoBo();
		return instance;
	}
	
	@Override
	public RegraAtendimento getById(Object id) throws Exception {		
		return this.getById(id, this.functionLoadAll);
	}
	
	@Override
	public RegraAtendimento save(RegraAtendimento regra) throws Exception {
		if(Helper.isNotNull(regra.getRegraAtendimentoEquipes())) {
			regra.getRegraAtendimentoEquipes().forEach(r -> {
				r.setRegraAtendimento(regra);
				if(Helper.isNotNull(r.getDependencias())) {
					r.getDependencias().forEach(d -> d.setRegraAtendimentoEquipe(r));
				}
			});
		}
		return super.save(regra);
	}
	
	@Override
	public PagedList<RegraAtendimento> getList(RegraAtendimentoFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
}
