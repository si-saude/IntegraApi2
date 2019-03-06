package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.ItemRespostaAvaliacaoAtendimento;

public class ItemRespostaAvaliacaoAtendimentoBuilder 
	extends GenericEntityBuilder<ItemRespostaAvaliacaoAtendimento, GenericFilter> {

	public static ItemRespostaAvaliacaoAtendimentoBuilder newInstance(ItemRespostaAvaliacaoAtendimento item) {
		return new ItemRespostaAvaliacaoAtendimentoBuilder(item);
	}
	
	public static ItemRespostaAvaliacaoAtendimentoBuilder newInstance(List<ItemRespostaAvaliacaoAtendimento> itens) {
		return new ItemRespostaAvaliacaoAtendimentoBuilder(itens);
	}
	
	private ItemRespostaAvaliacaoAtendimentoBuilder(ItemRespostaAvaliacaoAtendimento item) {
		super(item);
	}
	
	private ItemRespostaAvaliacaoAtendimentoBuilder(List<ItemRespostaAvaliacaoAtendimento> itens) {
		super(itens);
	}

	@Override
	protected ItemRespostaAvaliacaoAtendimento clone(ItemRespostaAvaliacaoAtendimento item) {
		ItemRespostaAvaliacaoAtendimento newItemRespostaAvaliacaoAtendimento = new ItemRespostaAvaliacaoAtendimento();
		
		newItemRespostaAvaliacaoAtendimento.setId(item.getId());
		newItemRespostaAvaliacaoAtendimento.setConteudo(item.getConteudo());
		newItemRespostaAvaliacaoAtendimento.setVersion(item.getVersion());
		
		return newItemRespostaAvaliacaoAtendimento;
	}	

}
