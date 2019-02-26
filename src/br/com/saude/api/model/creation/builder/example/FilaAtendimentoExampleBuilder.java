package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.FilaAtendimentoFilter;
import br.com.saude.api.model.entity.po.FilaAtendimento;

public class FilaAtendimentoExampleBuilder extends GenericExampleBuilder<FilaAtendimento, FilaAtendimentoFilter> {

	public static FilaAtendimentoExampleBuilder newInstance(FilaAtendimentoFilter filter) {
		return new FilaAtendimentoExampleBuilder(filter);
	}
	
	private FilaAtendimentoExampleBuilder(FilaAtendimentoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addData();
		addProfissional();
		addLocalizacao();
	}
	
	private void addData() {
		this.addData("data", this.filter.getData());
	}
	
	private void addProfissional() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("profissional", this.filter.getProfissional(),
				ProfissionalExampleBuilder.newInstance(this.filter.getProfissional()));
	}
	
	private void addLocalizacao() throws InstantiationException, IllegalAccessException {
		this.addLeftJoinGenericFilter("localizacao", this.filter.getLocalizacao(),
				LocalizacaoExampleBuilder.newInstance(this.filter.getLocalizacao()));
	}
}
