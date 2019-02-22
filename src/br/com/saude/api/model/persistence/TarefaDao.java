package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;

import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.model.entity.po.Tarefa;

public class TarefaDao extends GenericDao<Tarefa> {

	private static TarefaDao instance;
	
	private TarefaDao() {
		super();
	}
	
	public static TarefaDao getInstance() {
		if(instance == null)
			instance = new TarefaDao();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = tarefa -> {
			if(tarefa.getCliente() != null) {
				Hibernate.initialize(tarefa.getCliente());
			}
			if(tarefa.getEquipe() != null) {
				Hibernate.initialize(tarefa.getEquipe());
			}
			if(tarefa.getResponsavel() != null) {
				Hibernate.initialize(tarefa.getResponsavel());
			}
			if(tarefa.getServico() != null) {
				Hibernate.initialize(tarefa.getServico());
			}
			return tarefa;
		};
	}
}
