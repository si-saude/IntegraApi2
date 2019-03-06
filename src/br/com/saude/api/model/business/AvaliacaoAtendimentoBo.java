package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.AvaliacaoAtendimentoBuilder;
import br.com.saude.api.model.creation.builder.example.AvaliacaoAtendimentoExampleBuilder;
import br.com.saude.api.model.entity.filter.AvaliacaoAtendimentoFilter;
import br.com.saude.api.model.entity.po.AvaliacaoAtendimento;
import br.com.saude.api.model.persistence.AvaliacaoAtendimentoDao;
import br.com.saude.api.util.constant.StatusAvaliacaoAtendimento;

public class AvaliacaoAtendimentoBo extends GenericBo<AvaliacaoAtendimento, AvaliacaoAtendimentoFilter, AvaliacaoAtendimentoDao, AvaliacaoAtendimentoBuilder, 
	AvaliacaoAtendimentoExampleBuilder> {

	private static AvaliacaoAtendimentoBo instance;
	
	private AvaliacaoAtendimentoBo() {
		super();
	}
	
	public static AvaliacaoAtendimentoBo getInstance() {
		if(instance == null)
			instance = new AvaliacaoAtendimentoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		this.functionLoadAll = builder -> {
			try {
				return builder.loadRespostas();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		};
	}
	
	public String registrar(AvaliacaoAtendimento avaliacao) throws Exception {
		if(Helper.isNull(avaliacao.getRespostas()) || avaliacao.getRespostas().size() == 0) {
			throw new Exception("Não é possível registrar a Avaliação sem respostas.");
		}
		
		avaliacao.getRespostas().forEach(r -> {
			r.setAvaliacao(avaliacao);
			if(Helper.isNotNull(r.getItens())) {
				r.getItens().forEach(i -> i.setResposta(r));
			}
		});
		avaliacao.setStatus(StatusAvaliacaoAtendimento.getInstance().FINALIZADA);
		this.save(avaliacao);
		return "Avaliação registrada com sucesso.";
	}
	
	@Override
	public PagedList<AvaliacaoAtendimento> getList(AvaliacaoAtendimentoFilter filter) throws Exception {
		return super.getOrderedList(filter,"checkin.chegada");
	}
	
	@Override
	public AvaliacaoAtendimento getById(Object id) throws Exception {
		return super.getById(id, this.functionLoadAll);
	}
}
