package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.AtividadeFisicaFilter;
import br.com.saude.api.model.entity.po.AtividadeFisica;

public class AtividadeFisicaBuilder extends GenericEntityBuilder<AtividadeFisica, AtividadeFisicaFilter> {

	public static AtividadeFisicaBuilder newInstance(AtividadeFisica atividadeFisica) {
		return new AtividadeFisicaBuilder(atividadeFisica);
	}
	
	public static AtividadeFisicaBuilder newInstance(List<AtividadeFisica> atividadesFisicas) {
		return new AtividadeFisicaBuilder(atividadesFisicas);
	}
	
	private AtividadeFisicaBuilder(AtividadeFisica atividadeFisica) {
		super(atividadeFisica);
	}
	
	private AtividadeFisicaBuilder(List<AtividadeFisica> atividadesFisicas) {
		super(atividadesFisicas);
	}

	@Override
	protected AtividadeFisica clone(AtividadeFisica atividadeFisica) {
		AtividadeFisica newAtividadeFisica = new AtividadeFisica();
		
		newAtividadeFisica.setId(atividadeFisica.getId());
		newAtividadeFisica.setDescricao(atividadeFisica.getDescricao());
		newAtividadeFisica.setVersion(atividadeFisica.getVersion());
		
		return newAtividadeFisica;
	}	

}
