package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.ServicoFilter;
import br.com.saude.api.model.entity.po.Servico;

public class ServicoExampleBuilder extends GenericExampleBuilder<Servico, ServicoFilter> {

	public static ServicoExampleBuilder newInstance(ServicoFilter filter) {
		return new ServicoExampleBuilder(filter);
	}
	
	private ServicoExampleBuilder(ServicoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addCodigo();
		addNome();
		addGrupo();
		addInativo();
		addPublico();
	}
	
	private void addInativo() {
		this.entity.setInativo(this.addBoolean("inativo", this.filter.getInativo()));
	}
	
	private void addPublico() {
		this.entity.setPublico(this.addBoolean("publico", this.filter.getPublico()));
	}
	
	private void addCodigo() {
		this.ilike("codigo", this.filter.getCodigo());
	}
	
	private void addNome() {
		this.ilike("nome", this.filter.getNome());
	}
	
	private void addGrupo() {
		this.ilike("grupo", this.filter.getGrupo());
	}
}
