package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.CargoFilter;
import br.com.saude.api.model.entity.po.Cargo;

public class CargoBuilder extends GenericEntityBuilder<Cargo, CargoFilter> {

	public static CargoBuilder newInstance(Cargo Cargo) {
		return new CargoBuilder(Cargo);
	}
	
	public static CargoBuilder newInstance(List<Cargo> Cargos) {
		return new CargoBuilder(Cargos);
	}
	
	private CargoBuilder(Cargo Cargo) {
		super(Cargo);
	}
	
	private CargoBuilder(List<Cargo> Cargos) {
		super(Cargos);
	}

	@Override
	protected Cargo clone(Cargo cargo) {
		Cargo newCargo = new Cargo();
		
		newCargo.setId(cargo.getId());
		newCargo.setNome(cargo.getNome());
		newCargo.setVersion(cargo.getVersion());
		
		return newCargo;
	}
	
	public CargoBuilder loadCursos() throws Exception {
		return (CargoBuilder) this.loadProperty("cursos", cargo -> {
			return CursoBuilder.newInstance(cargo.getCursos()).getEntityList();
		});
	}
}
