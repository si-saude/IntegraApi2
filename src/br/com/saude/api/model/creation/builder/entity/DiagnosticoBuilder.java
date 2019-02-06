package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.DiagnosticoFilter;
import br.com.saude.api.model.entity.po.Diagnostico;

public class DiagnosticoBuilder extends GenericEntityBuilder<Diagnostico, DiagnosticoFilter> {

	public static DiagnosticoBuilder newInstance(Diagnostico diagnostico) {
		return new DiagnosticoBuilder(diagnostico);
	}
	
	public static DiagnosticoBuilder newInstance(List<Diagnostico> diagnosticos) {
		return new DiagnosticoBuilder(diagnosticos);
	}
	
	private DiagnosticoBuilder(Diagnostico diagnostico) {
		super(diagnostico);
	}
	
	private DiagnosticoBuilder(List<Diagnostico> diagnosticos) {
		super(diagnosticos);
	}

	@Override
	protected Diagnostico clone(Diagnostico diagnostico) {
		Diagnostico newDiagnostico = new Diagnostico();
		
		newDiagnostico.setId(diagnostico.getId());
		newDiagnostico.setDescricao(diagnostico.getDescricao());
		newDiagnostico.setCodigo(diagnostico.getCodigo());
		newDiagnostico.setInativo(diagnostico.isInativo());
		newDiagnostico.setVersion(diagnostico.getVersion());
		
		if(diagnostico.getEixo() != null)
			newDiagnostico.setEixo(EixoBuilder.newInstance(diagnostico.getEixo()).getEntity());
		
		return newDiagnostico;
	}	
}
