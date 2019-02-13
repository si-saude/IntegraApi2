package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.GrupoPerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.GrupoPerguntaFichaColeta;

public class GrupoPerguntaFichaColetaExampleBuilder extends GenericExampleBuilder<GrupoPerguntaFichaColeta, GrupoPerguntaFichaColetaFilter> {

	public static GrupoPerguntaFichaColetaExampleBuilder newInstance(GrupoPerguntaFichaColetaFilter filter) {
		return new GrupoPerguntaFichaColetaExampleBuilder(filter);
	}
	
	private GrupoPerguntaFichaColetaExampleBuilder(GrupoPerguntaFichaColetaFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
}
