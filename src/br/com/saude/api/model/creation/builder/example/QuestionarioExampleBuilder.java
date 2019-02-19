package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.QuestionarioFilter;
import br.com.saude.api.model.entity.po.Questionario;

public class QuestionarioExampleBuilder extends GenericExampleBuilder<Questionario, QuestionarioFilter> {

	public static QuestionarioExampleBuilder newInstance(QuestionarioFilter filter) {
		return new QuestionarioExampleBuilder(filter);
	}
	
	private QuestionarioExampleBuilder(QuestionarioFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addNome();
		addTipo();
		addInativo();
	}
	
	private void addInativo() {
		this.entity.setInativo(this.addBoolean("inativo", this.filter.getInativo()));
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addTipo() {
		this.ilike("tipo", this.filter.getTipo());
	}
}
