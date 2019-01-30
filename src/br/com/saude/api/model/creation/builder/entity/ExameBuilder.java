package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.ExameFilter;
import br.com.saude.api.model.entity.po.Exame;

public class ExameBuilder extends GenericEntityBuilder<Exame,ExameFilter> {
	
	public static ExameBuilder newInstance(Exame exame) {
		return new ExameBuilder(exame);
	}
	
	public static ExameBuilder newInstance(List<Exame> exames) {
		return new ExameBuilder(exames);
	}
	
	private ExameBuilder(Exame exame) {
		super(exame);
	}

	private ExameBuilder(List<Exame> exames) {
		super(exames);
	}

	@Override
	protected Exame clone(Exame exame) {
		Exame newExame = new Exame();
		
		newExame.setId(exame.getId());
		newExame.setCodigo(exame.getCodigo());
		newExame.setDescricao(exame.getDescricao());
		newExame.setExigeRelatorio(exame.isExigeRelatorio());
		newExame.setOpcional(exame.isOpcional());
		newExame.setOrdem(exame.getOrdem());
		newExame.setVersion(exame.getVersion());
		
		return newExame;
	}
	
	public ExameBuilder loadCampos() throws Exception {
		return (ExameBuilder) this.loadProperty("campoExames", exame -> {
			return CampoExameBuilder.newInstance(exame.getCampoExames()).getEntityList();
		});
	}
}
