package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.FilaAtendimentoFilter;
import br.com.saude.api.model.entity.po.FilaAtendimento;

public class FilaAtendimentoBuilder extends GenericEntityBuilder<FilaAtendimento, FilaAtendimentoFilter> {

	public static FilaAtendimentoBuilder newInstance(FilaAtendimento fila) {
		return new FilaAtendimentoBuilder(fila);
	}
	
	public static FilaAtendimentoBuilder newInstance(List<FilaAtendimento> filas) {
		return new FilaAtendimentoBuilder(filas);
	}
	
	private FilaAtendimentoBuilder(FilaAtendimento fila) {
		super(fila);
	}
	
	private FilaAtendimentoBuilder(List<FilaAtendimento> filas) {
		super(filas);
	}

	@Override
	protected FilaAtendimento clone(FilaAtendimento fila) {
		FilaAtendimento newFilaAtendimento = new FilaAtendimento();
		
		newFilaAtendimento.setId(fila.getId());
		newFilaAtendimento.setData(fila.getData());
		newFilaAtendimento.setStatus(fila.getStatus());
		newFilaAtendimento.setVersion(fila.getVersion());
		
		if(fila.getProfissional() != null) {
			newFilaAtendimento.setProfissional(ProfissionalBuilder
					.newInstance(fila.getProfissional()).getEntity());
		}
		
		if(fila.getLocalizacao() != null) {
			newFilaAtendimento.setLocalizacao(LocalizacaoBuilder
					.newInstance(fila.getLocalizacao()).getEntity());
		}
		
		return newFilaAtendimento;
	}	

}
