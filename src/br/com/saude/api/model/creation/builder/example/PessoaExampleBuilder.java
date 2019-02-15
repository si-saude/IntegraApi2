package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.PessoaFilter;
import br.com.saude.api.model.entity.po.Pessoa;

public class PessoaExampleBuilder extends GenericExampleBuilder<Pessoa, PessoaFilter> {

	public static PessoaExampleBuilder newInstance(PessoaFilter filter) {
		return new PessoaExampleBuilder(filter);
	}
	
	private PessoaExampleBuilder(PessoaFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addCpf();
		addDataNascimento();
		addSexo();
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addCpf() {
		this.ilike("cpf", this.filter.getCpf());
	}
	
	private void addSexo() {
		this.ilike("sexo", this.filter.getSexo());
	}
	
	private void addDataNascimento() {
		this.addData("dataNascimento", this.filter.getDataNascimento());
	}
}
