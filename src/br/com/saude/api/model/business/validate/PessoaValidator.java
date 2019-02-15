package br.com.saude.api.model.business.validate;

import br.com.saude.api.generic.GenericValidator;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Pessoa;

public class PessoaValidator extends GenericValidator<Pessoa> {
	
	@Override
	public void validate(Pessoa pessoa) throws Exception {
		super.validate(pessoa);
		
		if(pessoa.getEndereco() != null) {
			new EnderecoValidator().validate(pessoa.getEndereco());
		}
		
		if(Helper.isNotNull(pessoa.getTelefones())) {
			new TelefoneValidator().validate(pessoa.getTelefones());
		}
	}
}
