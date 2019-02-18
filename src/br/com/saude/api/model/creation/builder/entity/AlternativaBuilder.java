package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.Alternativa;

public class AlternativaBuilder extends GenericEntityBuilder<Alternativa, GenericFilter> {

	public static AlternativaBuilder newInstance(Alternativa alternativa) {
		return new AlternativaBuilder(alternativa);
	}
	
	public static AlternativaBuilder newInstance(List<Alternativa> alternativas) {
		return new AlternativaBuilder(alternativas);
	}
	
	private AlternativaBuilder(Alternativa alternativa) {
		super(alternativa);
	}
	
	private AlternativaBuilder(List<Alternativa> alternativas) {
		super(alternativas);
	}

	@Override
	protected Alternativa clone(Alternativa alternativa) {
		Alternativa newAlternativa = new Alternativa();
		
		newAlternativa.setId(alternativa.getId());
		newAlternativa.setCodigo(alternativa.getCodigo());
		newAlternativa.setCodigoAnterior(alternativa.getCodigoAnterior());
		newAlternativa.setCodigoProximo(alternativa.getCodigoProximo());
		newAlternativa.setTitulo(alternativa.getTitulo());
		newAlternativa.setVersion(alternativa.getVersion());
		
		return newAlternativa;
	}	

}
