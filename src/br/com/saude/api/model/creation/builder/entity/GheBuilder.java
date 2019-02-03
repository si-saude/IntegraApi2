package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.GheFilter;
import br.com.saude.api.model.entity.po.Ghe;

public class GheBuilder extends GenericEntityBuilder<Ghe, GheFilter> {

	public static GheBuilder newInstance(Ghe ghe) {
		return new GheBuilder(ghe);
	}
	
	public static GheBuilder newInstance(List<Ghe> ghes) {
		return new GheBuilder(ghes);
	}
	
	private GheBuilder(Ghe ghe) {
		super(ghe);
	}
	
	private GheBuilder(List<Ghe> ghes) {
		super(ghes);
	}

	@Override
	protected Ghe clone(Ghe ghe) {
		Ghe newGhe = new Ghe();
		
		newGhe.setId(ghe.getId());
		newGhe.setNome(ghe.getNome());
		newGhe.setCodigo(ghe.getCodigo());
		newGhe.setDuracaoJornada(ghe.getDuracaoJornada());
		newGhe.setDataCriacao(ghe.getDataCriacao());
		newGhe.setDataDesativacao(ghe.getDataDesativacao());
		newGhe.setDescricao(ghe.getDescricao());
		newGhe.setDescricaoAmbiente(ghe.getDescricaoAmbiente());
		newGhe.setDescricaoTarefas(ghe.getDescricaoTarefas());
		newGhe.setVersion(ghe.getVersion());
		
		if(ghe.getRisco() != null)
			newGhe.setRisco(RiscoGheBuilder.newInstance(ghe.getRisco()).getEntity());
		
		return newGhe;
	}	

}
