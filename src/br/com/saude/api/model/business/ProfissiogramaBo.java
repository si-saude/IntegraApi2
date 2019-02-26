package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.ProfissiogramaBuilder;
import br.com.saude.api.model.creation.builder.example.ProfissiogramaExampleBuilder;
import br.com.saude.api.model.entity.filter.ProfissiogramaFilter;
import br.com.saude.api.model.entity.po.Profissiograma;
import br.com.saude.api.model.persistence.ProfissiogramaDao;

public class ProfissiogramaBo extends GenericBo<Profissiograma, ProfissiogramaFilter, ProfissiogramaDao, 
										ProfissiogramaBuilder, ProfissiogramaExampleBuilder>{
	
	private static ProfissiogramaBo instance;
	
	private ProfissiogramaBo() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadProfissiogramaGrupos();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	public static ProfissiogramaBo getInstance() {
		if(instance == null)
			instance = new ProfissiogramaBo();
		return instance;
	}
	
	@Override
	public Profissiograma getById(Object id) throws Exception {		
		return this.getById(id, this.functionLoadAll);
	}
	
	@Override
	public Profissiograma save(Profissiograma profissiograma) throws Exception {
		if(Helper.isNotNull(profissiograma.getProfissiogramaGrupos())) {
			
			profissiograma.getProfissiogramaGrupos().forEach(profissiogramaGrupo -> {
				profissiogramaGrupo.setProfissiograma(profissiograma);
				
				profissiogramaGrupo.getProfissiogramaExames().forEach(profissiogramaExame -> {
					profissiogramaExame.setProfissiogramaGrupo(profissiogramaGrupo);
				});
			});
		}
		return super.save(profissiograma);
	}
	
	@Override
	public PagedList<Profissiograma> getList(ProfissiogramaFilter filter) throws Exception {
		return super.getOrderedList(filter,"nome");
	}
}
