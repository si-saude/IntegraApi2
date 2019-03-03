package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.Triagem;

public class TriagemBuilder extends GenericEntityBuilder<Triagem, GenericFilter> {

	public static TriagemBuilder newInstance(Triagem triagem) {
		return new TriagemBuilder(triagem);
	}
	
	public static TriagemBuilder newInstance(List<Triagem> triagens) {
		return new TriagemBuilder(triagens);
	}
	
	private TriagemBuilder(Triagem triagem) {
		super(triagem);
	}
	
	private TriagemBuilder(List<Triagem> triagens) {
		super(triagens);
	}

	@Override
	protected Triagem clone(Triagem triagem) {
		Triagem newTriagem = new Triagem();
		
		newTriagem.setId(triagem.getId());
		newTriagem.setCodigo(triagem.getCodigo());
		newTriagem.setIndice(triagem.getIndice());
		newTriagem.setVersion(triagem.getVersion());
		
		if(triagem.getIndicador() != null)
			newTriagem.setIndicador(IndicadorSastBuilder.newInstance(triagem.getIndicador()).getEntity());
		
		return newTriagem;
	}	
}
