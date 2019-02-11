package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.TipoPerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.TipoPerguntaFichaColeta;

public class TipoPerguntaFichaColetaExampleBuilder extends GenericExampleBuilder<TipoPerguntaFichaColeta, TipoPerguntaFichaColetaFilter> {

	public static TipoPerguntaFichaColetaExampleBuilder newInstance(TipoPerguntaFichaColetaFilter filter) {
		return new TipoPerguntaFichaColetaExampleBuilder(filter);
	}
	
	private TipoPerguntaFichaColetaExampleBuilder(TipoPerguntaFichaColetaFilter filter) {
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
