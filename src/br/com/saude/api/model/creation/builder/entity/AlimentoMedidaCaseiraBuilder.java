package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.AlimentoMedidaCaseira;

public class AlimentoMedidaCaseiraBuilder extends GenericEntityBuilder<AlimentoMedidaCaseira, GenericFilter> {

	public static AlimentoMedidaCaseiraBuilder newInstance(AlimentoMedidaCaseira alimentoMedidaCaseira) {
		return new AlimentoMedidaCaseiraBuilder(alimentoMedidaCaseira);
	}

	public static AlimentoMedidaCaseiraBuilder newInstance(List<AlimentoMedidaCaseira> alimentosMedidaCaseira) {
		return new AlimentoMedidaCaseiraBuilder(alimentosMedidaCaseira);
	}

	private AlimentoMedidaCaseiraBuilder(AlimentoMedidaCaseira alimentoMedidaCaseira) {
		super(alimentoMedidaCaseira);
	}

	private AlimentoMedidaCaseiraBuilder(List<AlimentoMedidaCaseira> alimentosMedidaCaseira) {
		super(alimentosMedidaCaseira);
	}

	@Override
	protected AlimentoMedidaCaseira clone(AlimentoMedidaCaseira alimentoMedidaCaseira) {
		AlimentoMedidaCaseira newAlimentoMedidaCaseira = new AlimentoMedidaCaseira();

		newAlimentoMedidaCaseira.setId(alimentoMedidaCaseira.getId());
		newAlimentoMedidaCaseira.setQuantidade(alimentoMedidaCaseira.getQuantidade());
		newAlimentoMedidaCaseira.setReferencia(alimentoMedidaCaseira.getReferencia());
		newAlimentoMedidaCaseira.setVersion(alimentoMedidaCaseira.getVersion());

		if(alimentoMedidaCaseira.getMedidaCaseira() != null)
			newAlimentoMedidaCaseira.setMedidaCaseira(MedidaCaseiraBuilder.newInstance(alimentoMedidaCaseira.getMedidaCaseira()).getEntity());
		
		return newAlimentoMedidaCaseira;
	}
}
