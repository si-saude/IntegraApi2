package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.DiagnosticoFilter;
import br.com.saude.api.model.entity.po.Diagnostico;

public class DiagnosticoExampleBuilder extends GenericExampleBuilder<Diagnostico, DiagnosticoFilter> {

	public static DiagnosticoExampleBuilder newInstance(DiagnosticoFilter filter) {
		return new DiagnosticoExampleBuilder(filter);
	}
	
	private DiagnosticoExampleBuilder(DiagnosticoFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addCodigo();
		addDescricao();
		addInativo();
		addEixo();
	}
	
	private void addInativo() {
		this.addBoolean("inativo", this.filter.getInativo());
	}
	
	private void addCodigo() {
		this.ilike("codigo", this.filter.getCodigo());
	}
	
	private void addDescricao() {
		this.ilike("descricao", this.filter.getDescricao());
	}
	
	private void addEixo() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("eixo", this.filter.getEixo(),
				EixoExampleBuilder.newInstance(this.filter.getEixo()));
	}
}
