package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.ClinicaFilter;
import br.com.saude.api.model.entity.po.Clinica;

public class ClinicaBuilder extends GenericEntityBuilder<Clinica,ClinicaFilter> {
	
	public static ClinicaBuilder newInstance(Clinica clinica) {
		return new ClinicaBuilder(clinica);
	}
	
	public static ClinicaBuilder newInstance(List<Clinica> perfis) {
		return new ClinicaBuilder(perfis);
	}
	
	private ClinicaBuilder(Clinica clinica) {
		super(clinica);
	}

	private ClinicaBuilder(List<Clinica> perfis) {
		super(perfis);
	}

	@Override
	protected Clinica clone(Clinica clinica) {
		Clinica newClinica = new Clinica();
		
		newClinica.setId(clinica.getId());
		newClinica.setEndereco(clinica.getEndereco());
		newClinica.setNome(clinica.getNome());
		newClinica.setTelefones(clinica.getTelefones());
		newClinica.setUf(clinica.getUf());
		newClinica.setVersion(clinica.getVersion());
		
		return newClinica;
	}
	
	public ClinicaBuilder loadExames() throws Exception {
		return (ClinicaBuilder) this.loadProperty("exames", clinica -> {
			return ExameBuilder.newInstance(clinica.getExames()).getEntityList();
		});
	}
}
