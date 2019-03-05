package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.ItemPerguntaFichaColeta;

public class ItemPerguntaFichaColetaBuilder extends GenericEntityBuilder<ItemPerguntaFichaColeta, GenericFilter> {

	public static ItemPerguntaFichaColetaBuilder newInstance(ItemPerguntaFichaColeta item) {
		return new ItemPerguntaFichaColetaBuilder(item);
	}
	
	public static ItemPerguntaFichaColetaBuilder newInstance(List<ItemPerguntaFichaColeta> items) {
		return new ItemPerguntaFichaColetaBuilder(items);
	}
	
	private ItemPerguntaFichaColetaBuilder(ItemPerguntaFichaColeta item) {
		super(item);
	}
	
	private ItemPerguntaFichaColetaBuilder(List<ItemPerguntaFichaColeta> items) {
		super(items);
	}

	@Override
	protected ItemPerguntaFichaColeta clone(ItemPerguntaFichaColeta item) {
		ItemPerguntaFichaColeta newItemPerguntaFichaColeta = new ItemPerguntaFichaColeta();
		
		newItemPerguntaFichaColeta.setId(item.getId());
		newItemPerguntaFichaColeta.setPath(item.getPath());
		newItemPerguntaFichaColeta.setTitulo(item.getTitulo());
		newItemPerguntaFichaColeta.setOrdem(item.getOrdem());
		newItemPerguntaFichaColeta.setVersion(item.getVersion());
		
		return newItemPerguntaFichaColeta;
	}	

}
