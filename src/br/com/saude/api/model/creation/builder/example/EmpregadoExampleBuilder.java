package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.EmpregadoFilter;
import br.com.saude.api.model.entity.po.Empregado;

public class EmpregadoExampleBuilder extends GenericExampleBuilder<Empregado, EmpregadoFilter> {

	public static EmpregadoExampleBuilder newInstance(EmpregadoFilter filter) {
		return new EmpregadoExampleBuilder(filter);
	}
	
	private EmpregadoExampleBuilder(EmpregadoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addChave();
		addMatricula();
		addPessoa();
		addStatus();
		addVinculo();
		addMatriculaNome();
		addCargo();
		addFuncao();
		addEnfase();
		addRegime();
		addBase();
		addGhe();
		addGhee();
	}
	
	private void addChave() {
		this.ilike("chave", this.filter.getChave());
	}
	
	private void addMatricula() {
		this.ilike("matricula", this.filter.getMatricula());
	}
	
	private void addStatus() {
		this.ilike("status", this.filter.getStatus());
	}
	
	private void addVinculo() {
		this.ilike("vinculo", this.filter.getVinculo());
	}
	
	private void addMatriculaNome() {
		this.ilike("matriculaNome", this.filter.getMatriculaNome());
	}
	
	private void addPessoa() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("pessoa", this.filter.getPessoa(),
				PessoaExampleBuilder.newInstance(this.filter.getPessoa()));
	}
	
	private void addCargo() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("cargo", this.filter.getCargo(),
				CargoExampleBuilder.newInstance(this.filter.getCargo()));
	}
	
	private void addFuncao() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("funcao", this.filter.getFuncao(),
				FuncaoExampleBuilder.newInstance(this.filter.getFuncao()));
	}
	
	private void addEnfase() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("enfase", this.filter.getEnfase(),
				EnfaseExampleBuilder.newInstance(this.filter.getEnfase()));
	}
	
	private void addRegime() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("regime", this.filter.getRegime(),
				RegimeExampleBuilder.newInstance(this.filter.getRegime()));
	}
	
	private void addBase() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("base", this.filter.getBase(),
				BaseExampleBuilder.newInstance(this.filter.getBase()));
	}
	
	private void addGhe() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("ghe", this.filter.getGhe(),
				GheExampleBuilder.newInstance(this.filter.getGhe()));
	}
	
	private void addGhee() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("ghee", this.filter.getGhee(),
				GheeExampleBuilder.newInstance(this.filter.getGhee()));
	}
}
