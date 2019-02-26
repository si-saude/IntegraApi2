package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.ProfissiogramaGrupo;

public class ProfissiogramaGrupoBuilder extends GenericEntityBuilder<ProfissiogramaGrupo, GenericFilter> {

	public static ProfissiogramaGrupoBuilder newInstance(ProfissiogramaGrupo profissiogramaGrupo) {
		return new ProfissiogramaGrupoBuilder(profissiogramaGrupo);
	}

	public static ProfissiogramaGrupoBuilder newInstance(List<ProfissiogramaGrupo> profissiogramaGrupos) {
		return new ProfissiogramaGrupoBuilder(profissiogramaGrupos);
	}

	private ProfissiogramaGrupoBuilder(ProfissiogramaGrupo profissiogramaGrupo) {
		super(profissiogramaGrupo);
	}

	private ProfissiogramaGrupoBuilder(List<ProfissiogramaGrupo> profissiogramaGrupos) {
		super(profissiogramaGrupos);
	}

	@Override
	protected ProfissiogramaGrupo clone(ProfissiogramaGrupo profissiogramaGrupo) {
		ProfissiogramaGrupo newProfissiogramaGrupo = new ProfissiogramaGrupo();

		newProfissiogramaGrupo.setId(profissiogramaGrupo.getId());
		newProfissiogramaGrupo.setVersion(profissiogramaGrupo.getVersion());

		if (profissiogramaGrupo.getGrupoMonitoramento() != null) {
			newProfissiogramaGrupo.setGrupoMonitoramento(
					GrupoMonitoramentoBuilder.newInstance(profissiogramaGrupo.getGrupoMonitoramento()).getEntity());
		}
		
		if(Helper.isNotNull(profissiogramaGrupo.getProfissiogramaExames())) {
			newProfissiogramaGrupo.setProfissiogramaExames(ProfissiogramaExameBuilder
					.newInstance(profissiogramaGrupo.getProfissiogramaExames()).getEntityList());
		}
		
		return newProfissiogramaGrupo;

	}
}
