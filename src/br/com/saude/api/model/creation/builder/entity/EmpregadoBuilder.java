package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.EmpregadoFilter;
import br.com.saude.api.model.entity.po.Empregado;

public class EmpregadoBuilder extends GenericEntityBuilder<Empregado,EmpregadoFilter> {
	
	public static EmpregadoBuilder newInstance(Empregado empregado) {
		return new EmpregadoBuilder(empregado);
	}
	
	public static EmpregadoBuilder newInstance(List<Empregado> empregados) {
		return new EmpregadoBuilder(empregados);
	}
	
	private EmpregadoBuilder(Empregado empregado) {
		super(empregado);
	}

	private EmpregadoBuilder(List<Empregado> empregados) {
		super(empregados);
	}

	@Override
	protected Empregado clone(Empregado empregado) {
		Empregado newEmpregado = new Empregado();
		
		newEmpregado.setId(empregado.getId());
		newEmpregado.setChave(empregado.getChave());
		newEmpregado.setDataAdmissao(empregado.getDataAdmissao());
		newEmpregado.setEmail(empregado.getEmail());
		newEmpregado.setEscolaridade(empregado.getEscolaridade());
		newEmpregado.setEstadoCivil(empregado.getEstadoCivil());
		newEmpregado.setMatricula(empregado.getMatricula());
		newEmpregado.setPis(empregado.getPis());
		newEmpregado.setRamal(empregado.getRamal());
		newEmpregado.setStatus(empregado.getStatus());
		newEmpregado.setVinculo(empregado.getVinculo());
		newEmpregado.setVersion(empregado.getVersion());
		
		if(empregado.getPessoa() != null) {
			newEmpregado.setPessoa(PessoaBuilder.newInstance(empregado.getPessoa()).getEntity());
		}
		
		return newEmpregado;
	}
	
	public EmpregadoBuilder loadCargo() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("cargo", empregado -> {
			return CargoBuilder.newInstance(empregado.getCargo()).getEntity();
		});
	}
	
	public EmpregadoBuilder loadFuncao() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("funcao", empregado -> {
			return FuncaoBuilder.newInstance(empregado.getFuncao()).getEntity();
		});
	}
	
	public EmpregadoBuilder loadEnfase() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("enfase", empregado -> {
			return EnfaseBuilder.newInstance(empregado.getEnfase()).getEntity();
		});
	}
	
	public EmpregadoBuilder loadRegime() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("regime", empregado -> {
			return RegimeBuilder.newInstance(empregado.getRegime()).getEntity();
		});
	}
	
	public EmpregadoBuilder loadGerencia() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("gerencia", empregado -> {
			return GerenciaBuilder.newInstance(empregado.getGerencia()).getEntity();
		});
	}
	
	public EmpregadoBuilder loadBase() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("base", empregado -> {
			return BaseBuilder.newInstance(empregado.getBase()).getEntity();
		});
	}
	
	public EmpregadoBuilder loadGhe() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("ghe", empregado -> {
			return GheBuilder.newInstance(empregado.getGhe()).getEntity();
		});
	}
	
	public EmpregadoBuilder loadGhee() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("ghee", empregado -> {
			return GheeBuilder.newInstance(empregado.getGhee()).getEntity();
		});
	}
	
	public EmpregadoBuilder loadGrupoMonitoramentos() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("grupoMonitoramentos", empregado -> {
			return GrupoMonitoramentoBuilder.newInstance(empregado.getGrupoMonitoramentos()).getEntityList();
		});
	}
	
	public EmpregadoBuilder loadPessoa() throws Exception {
		return (EmpregadoBuilder) this.loadProperty("pessoa", empregado -> {
			try {
				return PessoaBuilder.newInstance(empregado.getPessoa())
						.loadEndereco().loadTelefones().getEntity();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		});
	}
}
