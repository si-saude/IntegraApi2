package br.com.saude.api.model.creation.builder.example;

import br.com.saude.api.generic.GenericExampleBuilder;
import br.com.saude.api.model.entity.filter.TarefaFilter;
import br.com.saude.api.model.entity.po.Tarefa;

public class TarefaExampleBuilder extends GenericExampleBuilder<Tarefa, TarefaFilter> {

	public static TarefaExampleBuilder newInstance(TarefaFilter filter) {
		return new TarefaExampleBuilder(filter);
	}
	
	private TarefaExampleBuilder(TarefaFilter filter) {
		super(filter);
	}

	@Override
	protected void createExample() throws InstantiationException, IllegalAccessException {
		addStatus();
		addEquipe();
		addServico();
		addCliente();
		addResponsavel();
	}
	
	private void addStatus() {
		this.ilike("status", this.filter.getStatus());
	}
	
	private void addEquipe() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("equipe", this.filter.getEquipe(),
				EquipeExampleBuilder.newInstance(this.filter.getEquipe()));
	}
	
	private void addServico() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("servico", this.filter.getServico(),
				ServicoExampleBuilder.newInstance(this.filter.getServico()));
	}
	
	private void addCliente() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("cliente", this.filter.getCliente(),
				EmpregadoExampleBuilder.newInstance(this.filter.getCliente()));
	}
	
	private void addResponsavel() throws InstantiationException, IllegalAccessException {
		this.addGenericFilter("responsavel", this.filter.getResponsavel(),
				ProfissionalExampleBuilder.newInstance(this.filter.getResponsavel()));
	}
}
