package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.ProfissiogramaFilter;
import br.com.saude.api.model.entity.po.Profissiograma;

public class ProfissiogramaBuilder extends GenericEntityBuilder<Profissiograma,ProfissiogramaFilter> {
	
	public static ProfissiogramaBuilder newInstance(Profissiograma profissiograma) {
		return new ProfissiogramaBuilder(profissiograma);
	}
	
	public static ProfissiogramaBuilder newInstance(List<Profissiograma> profissiogramas) {
		return new ProfissiogramaBuilder(profissiogramas);
	}
	
	private ProfissiogramaBuilder(Profissiograma profissiograma) {
		super(profissiograma);
	}

	private ProfissiogramaBuilder(List<Profissiograma> profissiogramas) {
		super(profissiogramas);
	}

	@Override
	protected Profissiograma clone(Profissiograma profissiograma) {
		Profissiograma newProfissiograma = new Profissiograma();
		
		newProfissiograma.setId(profissiograma.getId());
		newProfissiograma.setNome(profissiograma.getNome());
		newProfissiograma.setConcluido(profissiograma.isConcluido());
		newProfissiograma.setVinculo(profissiograma.getVinculo());
		newProfissiograma.setVersion(profissiograma.getVersion());
		
		return newProfissiograma;
	}
	
	public ProfissiogramaBuilder loadProfissiogramaGrupos() throws Exception {
		return (ProfissiogramaBuilder) this.loadProperty("profissiogramaGrupos", profissiograma -> {
			return ProfissiogramaGrupoBuilder
					.newInstance(profissiograma.getProfissiogramaGrupos()).getEntityList();
		});
	}
}
