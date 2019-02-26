package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.CheckinFilter;
import br.com.saude.api.model.entity.po.Checkin;

public class CheckinExampleBuilder extends GenericExampleBuilder<Checkin, CheckinFilter> {

	public static CheckinExampleBuilder newInstance(CheckinFilter filter) {
		return new CheckinExampleBuilder(filter);
	}
	
	private CheckinExampleBuilder(CheckinFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addStatus();
		addServico();
		addEmpregado();
		addChegada();
		addLocalizacao();
	}
	
	private void addStatus() {
		this.ilike("status", this.filter.getStatus());
	}
	
	private void addChegada() {
		this.addData("chegada", this.filter.getChegada());
	}
	
	private void addServico() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("servico", this.filter.getServico(),
				ServicoExampleBuilder.newInstance(this.filter.getServico()));
	}
	
	private void addEmpregado() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("empregado", this.filter.getEmpregado(),
				EmpregadoExampleBuilder.newInstance(this.filter.getEmpregado()));
	}
	
	private void addLocalizacao() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("localizacao", this.filter.getEmpregado(),
				LocalizacaoExampleBuilder.newInstance(this.filter.getLocalizacao()));
	}
}
