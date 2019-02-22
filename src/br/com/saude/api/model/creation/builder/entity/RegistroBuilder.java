package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.Registro;

public class RegistroBuilder extends GenericEntityBuilder<Registro, GenericFilter> {

	public static RegistroBuilder newInstance(Registro registro) {
		return new RegistroBuilder(registro);
	}
	
	public static RegistroBuilder newInstance(List<Registro> registros) {
		return new RegistroBuilder(registros);
	}
	
	private RegistroBuilder(Registro registro) {
		super(registro);
	}
	
	private RegistroBuilder(List<Registro> registros) {
		super(registros);
	}

	@Override
	protected Registro clone(Registro registro) {
		Registro newRegistro = new Registro();
		
		newRegistro.setId(registro.getId());
		newRegistro.setConselho(registro.getConselho());
		newRegistro.setUf(registro.getUf());
		newRegistro.setNumero(registro.getNumero());
		newRegistro.setVencimento(registro.getVencimento());
		newRegistro.setVersion(registro.getVersion());
		
		return newRegistro;
	}	

}
