package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.RegraAtendimentoFilter;
import br.com.saude.api.model.entity.po.RegraAtendimento;

public class RegraAtendimentoBuilder extends GenericEntityBuilder<RegraAtendimento, RegraAtendimentoFilter> {

	public static RegraAtendimentoBuilder newInstance(RegraAtendimento regra) {
		return new RegraAtendimentoBuilder(regra);
	}
	
	public static RegraAtendimentoBuilder newInstance(List<RegraAtendimento> regras) {
		return new RegraAtendimentoBuilder(regras);
	}
	
	private RegraAtendimentoBuilder(RegraAtendimento regra) {
		super(regra);
	}
	
	private RegraAtendimentoBuilder(List<RegraAtendimento> regras) {
		super(regras);
	}

	@Override
	protected RegraAtendimento clone(RegraAtendimento regra) {
		RegraAtendimento newRegraAtendimento = new RegraAtendimento();
		
		newRegraAtendimento.setId(regra.getId());
		newRegraAtendimento.setNome(regra.getNome());
		newRegraAtendimento.setVersion(regra.getVersion());
		
		return newRegraAtendimento;
	}
	
	public RegraAtendimentoBuilder loadRegraAtendimentoEquipes() throws Exception {
		return (RegraAtendimentoBuilder) this.loadProperty("regraAtendimentoEquipes", regra -> {
			return RegraAtendimentoEquipeBuilder.newInstance(regra.getRegraAtendimentoEquipes()).getEntityList();
		});
	}

}
