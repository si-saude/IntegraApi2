package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.GheeFilter;
import br.com.saude.api.model.entity.po.Ghee;

public class GheeBuilder extends GenericEntityBuilder<Ghee, GheeFilter> {

	public static GheeBuilder newInstance(Ghee ghee) {
		return new GheeBuilder(ghee);
	}
	
	public static GheeBuilder newInstance(List<Ghee> ghees) {
		return new GheeBuilder(ghees);
	}
	
	private GheeBuilder(Ghee ghee) {
		super(ghee);
	}
	
	private GheeBuilder(List<Ghee> ghees) {
		super(ghees);
	}

	@Override
	protected Ghee clone(Ghee ghee) {
		Ghee newGhee = new Ghee();
		
		newGhee.setId(ghee.getId());
		newGhee.setNome(ghee.getNome());
		newGhee.setCodigo(ghee.getCodigo());
		newGhee.setDataCriacao(ghee.getDataCriacao());
		newGhee.setDataDesativacao(ghee.getDataDesativacao());
		newGhee.setDescricao(ghee.getDescricao());
		newGhee.setVersion(ghee.getVersion());
		
		return newGhee;
	}	

}
