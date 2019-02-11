package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.PerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.PerguntaFichaColeta;

public class PerguntaFichaColetaBuilder extends GenericEntityBuilder<PerguntaFichaColeta,PerguntaFichaColetaFilter> {
	
	public static PerguntaFichaColetaBuilder newInstance(PerguntaFichaColeta pergunta) {
		return new PerguntaFichaColetaBuilder(pergunta);
	}
	
	public static PerguntaFichaColetaBuilder newInstance(List<PerguntaFichaColeta> perfis) {
		return new PerguntaFichaColetaBuilder(perfis);
	}
	
	private PerguntaFichaColetaBuilder(PerguntaFichaColeta pergunta) {
		super(pergunta);
	}

	private PerguntaFichaColetaBuilder(List<PerguntaFichaColeta> perfis) {
		super(perfis);
	}

	@Override
	protected PerguntaFichaColeta clone(PerguntaFichaColeta pergunta) {
		PerguntaFichaColeta newPerguntaFichaColeta = new PerguntaFichaColeta();
		
		newPerguntaFichaColeta.setId(pergunta.getId());
		newPerguntaFichaColeta.setCodigo(pergunta.getCodigo());
		newPerguntaFichaColeta.setDescricao(pergunta.getDescricao());
		newPerguntaFichaColeta.setInativo(pergunta.isInativo());
		newPerguntaFichaColeta.setPath(pergunta.getPath());
		newPerguntaFichaColeta.setTipo(pergunta.getTipo());
		newPerguntaFichaColeta.setVersion(pergunta.getVersion());
		
		if(pergunta.getGrupo() != null) {
			newPerguntaFichaColeta.setGrupo(GrupoPerguntaFichaColetaBuilder
					.newInstance(pergunta.getGrupo()).getEntity());
		}
		
		return newPerguntaFichaColeta;
	}
	
	public PerguntaFichaColetaBuilder loadEquipes() throws Exception {
		return (PerguntaFichaColetaBuilder) this.loadProperty("equipes", pergunta -> {
			return EquipeBuilder.newInstance(pergunta.getEquipes()).getEntityList();
		});
	}
	
	public PerguntaFichaColetaBuilder loadItens() throws Exception {
		return (PerguntaFichaColetaBuilder) this.loadProperty("itens", pergunta -> {
			return ItemPerguntaFichaColetaBuilder.newInstance(pergunta.getItens()).getEntityList();
		});
	}
}
