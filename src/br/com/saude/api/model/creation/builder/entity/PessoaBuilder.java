package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.PessoaFilter;
import br.com.saude.api.model.entity.po.Pessoa;

public class PessoaBuilder extends GenericEntityBuilder<Pessoa,PessoaFilter> {
	
	public static PessoaBuilder newInstance(Pessoa pessoa) {
		return new PessoaBuilder(pessoa);
	}
	
	public static PessoaBuilder newInstance(List<Pessoa> pessoas) {
		return new PessoaBuilder(pessoas);
	}
	
	private PessoaBuilder(Pessoa pessoa) {
		super(pessoa);
	}

	private PessoaBuilder(List<Pessoa> pessoas) {
		super(pessoas);
	}

	@Override
	protected Pessoa clone(Pessoa pessoa) {
		Pessoa newPessoa = new Pessoa();
		
		newPessoa.setId(pessoa.getId());
		newPessoa.setCpf(pessoa.getCpf());
		newPessoa.setDataNascimento(pessoa.getDataNascimento());
		newPessoa.setIdade(pessoa.getIdade());
		newPessoa.setNome(pessoa.getNome());
		newPessoa.setRg(pessoa.getRg());
		newPessoa.setSexo(pessoa.getSexo());
		newPessoa.setVersion(pessoa.getVersion());
		
		return newPessoa;
	}
	
	public PessoaBuilder loadTelefones() throws Exception {
		return (PessoaBuilder) this.loadProperty("telefones", pessoa -> {
			return TelefoneBuilder.newInstance(pessoa.getTelefones()).getEntityList();
		});
	}
	
	public PessoaBuilder loadEndereco() throws Exception {
		return (PessoaBuilder) this.loadProperty("endereco", pessoa -> {
			return EnderecoBuilder.newInstance(pessoa.getEndereco()).getEntity();
		});
	}
}
