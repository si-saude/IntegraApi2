package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.MedidaCaseiraFilter;
import br.com.saude.api.model.entity.po.MedidaCaseira;

public class MedidaCaseiraExampleBuilder extends GenericExampleBuilder<MedidaCaseira, MedidaCaseiraFilter> {

	public static MedidaCaseiraExampleBuilder newInstance(MedidaCaseiraFilter filter) {
		return new MedidaCaseiraExampleBuilder(filter);
	}
	
	private MedidaCaseiraExampleBuilder(MedidaCaseiraFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addDescricao();
	}
	
	private void addDescricao() {
		this.ilike("descricao", this.filter.getDescricao());
	}
	
}
