package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.ProfissiogramaExame;

public class ProfissiogramaExameBuilder extends GenericEntityBuilder<ProfissiogramaExame, GenericFilter> {

	public static ProfissiogramaExameBuilder newInstance(ProfissiogramaExame profissiogramaExame) {
		return new ProfissiogramaExameBuilder(profissiogramaExame);
	}
	
	public static ProfissiogramaExameBuilder newInstance(List<ProfissiogramaExame> profissiogramaExames) {
		return new ProfissiogramaExameBuilder(profissiogramaExames);
	}
	
	private ProfissiogramaExameBuilder(ProfissiogramaExame profissiogramaExame) {
		super(profissiogramaExame);
	}
	
	private ProfissiogramaExameBuilder(List<ProfissiogramaExame> profissiogramaExames) {
		super(profissiogramaExames);
	}

	@Override
	protected ProfissiogramaExame clone(ProfissiogramaExame profissiogramaExame) {
		ProfissiogramaExame newProfissiogramaExame = new ProfissiogramaExame();
		
		newProfissiogramaExame.setId(profissiogramaExame.getId());
		newProfissiogramaExame.setOpcional(profissiogramaExame.isOpcional());
		newProfissiogramaExame.setVersion(profissiogramaExame.getVersion());
		
		if(profissiogramaExame.getExame() != null) {
			newProfissiogramaExame.setExame(ExameBuilder.newInstance(profissiogramaExame.getExame()).getEntity());
		}
		
		if(Helper.isNotNull(profissiogramaExame.getCriterios())) {
			newProfissiogramaExame.setCriterios(
					CriterioBuilder.newInstance(profissiogramaExame.getCriterios()).getEntityList());
		}
		
		return newProfissiogramaExame;
	}	

}
