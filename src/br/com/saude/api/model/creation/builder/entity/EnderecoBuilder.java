package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.GenericFilter;
import br.com.saude.api.model.entity.po.Endereco;

public class EnderecoBuilder extends GenericEntityBuilder<Endereco, GenericFilter> {

	public static EnderecoBuilder newInstance(Endereco endereco) {
		return new EnderecoBuilder(endereco);
	}
	
	public static EnderecoBuilder newInstance(List<Endereco> enderecos) {
		return new EnderecoBuilder(enderecos);
	}
	
	private EnderecoBuilder(Endereco endereco) {
		super(endereco);
	}
	
	private EnderecoBuilder(List<Endereco> enderecos) {
		super(enderecos);
	}

	@Override
	protected Endereco clone(Endereco endereco) {
		Endereco newEndereco = new Endereco();
		
		newEndereco.setId(endereco.getId());
		newEndereco.setBairro(endereco.getBairro());
		newEndereco.setCep(endereco.getCep());
		newEndereco.setComplemento(endereco.getComplemento());
		newEndereco.setLogradouro(endereco.getLogradouro());
		newEndereco.setNumero(endereco.getNumero());
		newEndereco.setVersion(endereco.getVersion());
		
		if(endereco.getCidade() != null) {
			newEndereco.setCidade(CidadeBuilder.newInstance(endereco.getCidade()).getEntity());
		}
		
		return newEndereco;
	}	

}
