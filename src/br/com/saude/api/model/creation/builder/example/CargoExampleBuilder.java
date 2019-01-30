package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.CargoFilter;
import br.com.saude.api.model.entity.po.Cargo;

public class CargoExampleBuilder extends GenericExampleBuilder<Cargo, CargoFilter> {

	public static CargoExampleBuilder newInstance(CargoFilter filter) {
		return new CargoExampleBuilder(filter);
	}
	
	private CargoExampleBuilder(CargoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
}
