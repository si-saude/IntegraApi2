package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.ItemRespostaFichaColeta;

public class ItemRespostaFichaColetaBuilder 
	extends GenericEntityBuilder<ItemRespostaFichaColeta, GenericFilter> {

	public static ItemRespostaFichaColetaBuilder newInstance(ItemRespostaFichaColeta item) {
		return new ItemRespostaFichaColetaBuilder(item);
	}
	
	public static ItemRespostaFichaColetaBuilder newInstance(List<ItemRespostaFichaColeta> itens) {
		return new ItemRespostaFichaColetaBuilder(itens);
	}
	
	private ItemRespostaFichaColetaBuilder(ItemRespostaFichaColeta item) {
		super(item);
	}
	
	private ItemRespostaFichaColetaBuilder(List<ItemRespostaFichaColeta> itens) {
		super(itens);
	}

	@Override
	protected ItemRespostaFichaColeta clone(ItemRespostaFichaColeta item) {
		ItemRespostaFichaColeta newItemRespostaFichaColeta = new ItemRespostaFichaColeta();
		
		newItemRespostaFichaColeta.setId(item.getId());
		newItemRespostaFichaColeta.setVersion(item.getVersion());
		
		if(Helper.isNotNull(item.getDetalhes())) {
			newItemRespostaFichaColeta.setDetalhes(DetalheRespostaFichaColetaBuilder
					.newInstance(item.getDetalhes()).getEntityList());
		}
		
		return newItemRespostaFichaColeta;
	}	

}
