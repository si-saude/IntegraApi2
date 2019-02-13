package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.GrupoPerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.GrupoPerguntaFichaColeta;

public class GrupoPerguntaFichaColetaBuilder extends GenericEntityBuilder<GrupoPerguntaFichaColeta, GrupoPerguntaFichaColetaFilter> {

	public static GrupoPerguntaFichaColetaBuilder newInstance(GrupoPerguntaFichaColeta grupo) {
		return new GrupoPerguntaFichaColetaBuilder(grupo);
	}
	
	public static GrupoPerguntaFichaColetaBuilder newInstance(List<GrupoPerguntaFichaColeta> grupos) {
		return new GrupoPerguntaFichaColetaBuilder(grupos);
	}
	
	private GrupoPerguntaFichaColetaBuilder(GrupoPerguntaFichaColeta grupo) {
		super(grupo);
	}
	
	private GrupoPerguntaFichaColetaBuilder(List<GrupoPerguntaFichaColeta> grupos) {
		super(grupos);
	}

	@Override
	protected GrupoPerguntaFichaColeta clone(GrupoPerguntaFichaColeta grupo) {
		GrupoPerguntaFichaColeta newGrupoPerguntaFichaColeta = new GrupoPerguntaFichaColeta();
		
		newGrupoPerguntaFichaColeta.setId(grupo.getId());
		newGrupoPerguntaFichaColeta.setNome(grupo.getNome());
		newGrupoPerguntaFichaColeta.setOrdem(grupo.getOrdem());
		newGrupoPerguntaFichaColeta.setVersion(grupo.getVersion());
		
		return newGrupoPerguntaFichaColeta;
	}	

}
