package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.PerguntaFichaColetaFilter;
import br.com.saude.api.model.entity.po.PerguntaFichaColeta;

public class PerguntaFichaColetaExampleBuilder extends GenericExampleBuilder<PerguntaFichaColeta, PerguntaFichaColetaFilter> {

	public static PerguntaFichaColetaExampleBuilder newInstance(PerguntaFichaColetaFilter filter) {
		return new PerguntaFichaColetaExampleBuilder(filter);
	}
	
	private PerguntaFichaColetaExampleBuilder(PerguntaFichaColetaFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addCodigo();
		addPath();
		addTipo();
		addInativo();
		addObrigatorio();
		addGrupo();
	}
	
	private void addCodigo() {
		this.ilike("codigo", this.filter.getCodigo());
	}
	
	private void addPath() {
		this.ilike("path", this.filter.getPath());
	}
	
	private void addTipo() {
		this.ilike("tipo", this.filter.getTipo());
	}
	
	private void addInativo() {
		this.entity.setInativo(this.addBoolean("inativo", this.filter.getInativo()));
	}
	
	private void addObrigatorio() {		
		this.entity.setObrigatorio(this.addBoolean("obrigatorio", this.filter.getObrigatorio()));
	}
	
	private void addGrupo() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("grupo", this.filter.getGrupo(),
				GrupoPerguntaFichaColetaExampleBuilder.newInstance(this.filter.getGrupo()));
	}
}
