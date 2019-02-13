package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.MedidaCaseiraFilter;
import br.com.saude.api.model.entity.po.MedidaCaseira;

public class MedidaCaseiraBuilder extends GenericEntityBuilder<MedidaCaseira, MedidaCaseiraFilter> {

	public static MedidaCaseiraBuilder newInstance(MedidaCaseira medidaCaseira) {
		return new MedidaCaseiraBuilder(medidaCaseira);
	}
	
	public static MedidaCaseiraBuilder newInstance(List<MedidaCaseira> medidasCaseiras) {
		return new MedidaCaseiraBuilder(medidasCaseiras);
	}
	
	private MedidaCaseiraBuilder(MedidaCaseira medidaCaseira) {
		super(medidaCaseira);
	}
	
	private MedidaCaseiraBuilder(List<MedidaCaseira> medidasCaseiras) {
		super(medidasCaseiras);
	}

	@Override
	protected MedidaCaseira clone(MedidaCaseira medidaCaseira) {
		MedidaCaseira newMedidaCaseira = new MedidaCaseira();
		
		newMedidaCaseira.setId(medidaCaseira.getId());
		newMedidaCaseira.setDescricao(medidaCaseira.getDescricao());
		newMedidaCaseira.setVersion(medidaCaseira.getVersion());
		
		return newMedidaCaseira;
	}	

}
