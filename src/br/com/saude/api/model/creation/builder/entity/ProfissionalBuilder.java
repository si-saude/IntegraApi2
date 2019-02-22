package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.ProfissionalFilter;
import br.com.saude.api.model.entity.po.Profissional;

public class ProfissionalBuilder extends GenericEntityBuilder<Profissional,ProfissionalFilter> {
	
	public static ProfissionalBuilder newInstance(Profissional profissional) {
		return new ProfissionalBuilder(profissional);
	}
	
	public static ProfissionalBuilder newInstance(List<Profissional> profissionais) {
		return new ProfissionalBuilder(profissionais);
	}
	
	private ProfissionalBuilder(Profissional profissional) {
		super(profissional);
	}

	private ProfissionalBuilder(List<Profissional> profissionais) {
		super(profissionais);
	}

	@Override
	protected Profissional clone(Profissional profissional) {
		Profissional newProfissional = new Profissional();
		
		newProfissional.setId(profissional.getId());
		newProfissional.setDataAso(profissional.getDataAso());
		newProfissional.setMi(profissional.getMi());
		
		newProfissional.setVersion(profissional.getVersion());
		
		if(profissional.getEmpregado() != null) {
			newProfissional.setEmpregado(EmpregadoBuilder.newInstance(profissional.getEmpregado()).getEntity());
		}
		
		return newProfissional;
	}
	
	public ProfissionalBuilder loadCurriculo() throws Exception {
		return (ProfissionalBuilder) this.loadProperty("curriculo", profissional -> {
			return CurriculoBuilder.newInstance(profissional.getCurriculo()).getEntity();
		});
	}
	
	public ProfissionalBuilder loadRegistro() throws Exception {
		return (ProfissionalBuilder) this.loadProperty("registro", profissional -> {
			return RegistroBuilder.newInstance(profissional.getRegistro()).getEntity();
		});
	}

	public ProfissionalBuilder loadEquipes() throws Exception {
		return (ProfissionalBuilder) this.loadProperty("equipes", profissional -> {
			return EquipeBuilder.newInstance(profissional.getEquipes()).getEntityList();
		});
	}
	
	public ProfissionalBuilder loadServicos() throws Exception {
		return (ProfissionalBuilder) this.loadProperty("servicos", profissional -> {
			return ServicoBuilder.newInstance(profissional.getServicos()).getEntityList();
		});
	}
}
