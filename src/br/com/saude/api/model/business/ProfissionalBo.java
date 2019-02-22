package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.ProfissionalBuilder;
import br.com.saude.api.model.creation.builder.example.ProfissionalExampleBuilder;
import br.com.saude.api.model.entity.filter.ProfissionalFilter;
import br.com.saude.api.model.entity.po.Profissional;
import br.com.saude.api.model.persistence.ProfissionalDao;

public class ProfissionalBo extends GenericBo<Profissional, ProfissionalFilter, ProfissionalDao, ProfissionalBuilder, 
	ProfissionalExampleBuilder> {

	private static ProfissionalBo instance;
	
	private ProfissionalBo() {
		super();
	}
	
	public static ProfissionalBo getInstance() {
		if(instance == null)
			instance = new ProfissionalBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadCurriculo().loadRegistro().loadEquipes().loadServicos();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	@Override
	public PagedList<Profissional> getList(ProfissionalFilter filter) throws Exception {
		return super.getOrderedList(filter,"empregado.matricula");
	}
	
	@Override
	public Profissional getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
	
	@Override
	public Profissional save(Profissional profissional) throws Exception {
		if(Helper.isNotNull(profissional.getCurriculo().getCurriculoCursos())) {
			profissional.getCurriculo().getCurriculoCursos().forEach(i->i.setCurriculo(profissional.getCurriculo()));
		}
		
		return super.save(profissional);
	}
}
