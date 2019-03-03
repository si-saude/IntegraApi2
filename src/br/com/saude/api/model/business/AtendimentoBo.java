package br.com.saude.api.model.business;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.AtendimentoBuilder;
import br.com.saude.api.model.creation.builder.example.AtendimentoExampleBuilder;
import br.com.saude.api.model.entity.filter.AtendimentoFilter;
import br.com.saude.api.model.entity.po.Atendimento;
import br.com.saude.api.model.persistence.AtendimentoDao;
import br.com.saude.api.util.constant.StatusCheckin;
import br.com.saude.api.util.constant.StatusFilaAtendimento;

public class AtendimentoBo extends GenericBo<Atendimento, AtendimentoFilter, AtendimentoDao, AtendimentoBuilder, 
	AtendimentoExampleBuilder> {

	private static AtendimentoBo instance;
	
	private AtendimentoBo() {
		super();
	}
	
	public static AtendimentoBo getInstance() {
		if(instance == null)
			instance = new AtendimentoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Atendimento> getList(AtendimentoFilter filter) throws Exception {
		return super.getDescOrderedList(filter,"id");
	}
	
	public String iniciar(Atendimento atendimento) throws Exception {
		getDao().iniciar(atendimento.getId());
		return "Atendimento iniciado.";
	}
	
	public String liberar(Atendimento atendimento) throws Exception {
		getDao().liberar(atendimento.getId());
		return "Empregado liberado.";
	}
	
	public String finalizar(Atendimento atendimento) throws Exception {
		getDao().finalizar(atendimento.getId(),atendimento.getFila().getStatus());
		return "Atendimento finalizado.";
	}
	
	public String devolver(Atendimento atendimento) throws Exception {
		getDao().cancelar(atendimento.getId(),
				StatusFilaAtendimento.getInstance().INDISPONIVEL,
				StatusCheckin.getInstance().AGUARDANDO);
		return "Empregado devolvido para a fila.";
	}
	
	public String registrarAusencia(Atendimento atendimento) throws Exception {
		getDao().cancelar(atendimento.getId(),
				StatusFilaAtendimento.getInstance().DISPONIVEL,
				StatusCheckin.getInstance().AUSENTE);
		return "Realizado o Check-out do empregado.";
	}
}
