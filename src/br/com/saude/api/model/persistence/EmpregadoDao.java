package br.com.saude.api.model.persistence;

import org.hibernate.Hibernate;
import br.com.saude.api.generic.GenericDao;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.po.Empregado;

public class EmpregadoDao extends GenericDao<Empregado> {
	
	private static EmpregadoDao instance;
	
	private EmpregadoDao() {
		super();
	}
	
	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = empregado -> {
			if(empregado.getCargo() != null)
				Hibernate.initialize(empregado.getCargo());
			if(empregado.getFuncao() != null)
				Hibernate.initialize(empregado.getFuncao());
			if(empregado.getEnfase() != null)
				Hibernate.initialize(empregado.getEnfase());
			if(empregado.getRegime() != null)
				Hibernate.initialize(empregado.getRegime());
			if(empregado.getGerencia() != null)
				Hibernate.initialize(empregado.getGerencia());
			if(empregado.getBase() != null)
				Hibernate.initialize(empregado.getBase());
			if(empregado.getGhe() != null)
				Hibernate.initialize(empregado.getGhe());
			if(empregado.getGhee() != null)
				Hibernate.initialize(empregado.getGhee());
			
			if(Helper.isNotNull(empregado.getGrupoMonitoramentos())) {
				Hibernate.initialize(empregado.getGrupoMonitoramentos());
			}
			
			if(Helper.isNotNull(empregado.getPessoa().getTelefones())) {
				Hibernate.initialize(empregado.getPessoa().getTelefones());
			}
			
			if(empregado.getPessoa().getEndereco() != null) {
				Hibernate.initialize(empregado.getPessoa().getEndereco());
			}
			
			return empregado;
		};
	}
	
	public static EmpregadoDao getInstance() {
		if(instance == null)
			instance = new EmpregadoDao();
		return instance;
	}
	
	@Override
	public Empregado getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
