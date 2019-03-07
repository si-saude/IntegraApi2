package br.com.saude.api.model.business;

import java.util.List;

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
	
	private Atendimento definirReferencias(Atendimento atendimento) {
		atendimento.setCheckin(CheckinBo.getInstance().definirReferencias(atendimento.getCheckin()));
		return atendimento;
	}
	
	public String iniciar(Atendimento atendimento) throws Exception {
		atendimento = definirReferencias(atendimento);
		getDao().iniciar(atendimento);
		return "Atendimento iniciado.";
	}
	
	public String liberar(Atendimento atendimento) throws Exception {
		atendimento = definirReferencias(atendimento);
		getDao().liberar(atendimento);
		return "Empregado liberado.";
	}
	
	public String finalizar(Atendimento atendimento) throws Exception {
		atendimento = definirReferencias(atendimento);
		getDao().finalizar(atendimento);
		return "Atendimento finalizado.";
	}
	
	public String devolver(Atendimento atendimento) throws Exception {
		atendimento.getFila().setStatus(StatusFilaAtendimento.getInstance().INDISPONIVEL);
		atendimento.getCheckin().setStatus(StatusCheckin.getInstance().AGUARDANDO);
		getDao().cancelar(atendimento);
		return "Empregado devolvido para a fila.";
	}
	
	public String registrarAusencia(Atendimento atendimento) throws Exception {
		atendimento.getFila().setStatus(StatusFilaAtendimento.getInstance().DISPONIVEL);
		atendimento.getCheckin().setStatus(StatusCheckin.getInstance().AUSENTE);
		getDao().cancelar(atendimento);
		return "Realizado o Check-out do empregado.";
	}
	
	public List<Atendimento> getListFilasAtendimentoByLocalizacao(Atendimento atendimento) throws Exception {
		return getBuilder(getDao().getListFilasAtendimentoByLocalizacao(
				atendimento.getFila().getLocalizacao().getId())).getEntityList();	
	}
	
	public List<Atendimento> getListAtendimentosAguardandoEmpregadoByLocalizacao(Atendimento atendimento) throws Exception {
		return getBuilder(getDao().getListAtendimentosAguardandoEmpregadoByLocalizacao(
				atendimento.getFila().getLocalizacao().getId())).getEntityList();	
	}
}
