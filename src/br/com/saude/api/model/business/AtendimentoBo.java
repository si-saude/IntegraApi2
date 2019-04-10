package br.com.saude.api.model.business;

import java.util.List;
import java.util.Optional;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.AtendimentoBuilder;
import br.com.saude.api.model.creation.builder.example.AtendimentoExampleBuilder;
import br.com.saude.api.model.entity.filter.AtendimentoFilter;
import br.com.saude.api.model.entity.filter.CheckinFilter;
import br.com.saude.api.model.entity.filter.FilaAtendimentoFilter;
import br.com.saude.api.model.entity.po.Atendimento;
import br.com.saude.api.model.entity.po.Checkin;
import br.com.saude.api.model.entity.po.Tarefa;
import br.com.saude.api.model.persistence.AtendimentoDao;
import br.com.saude.api.util.constant.StatusCheckin;
import br.com.saude.api.util.constant.StatusFilaAtendimento;
import br.com.saude.api.util.constant.StatusTarefa;

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
		return "Empregado liberado. " + getProximoAtendimento(atendimento);
	}
	
	public String finalizar(Atendimento atendimento) throws Exception {
		atendimento = definirReferencias(atendimento);
		getDao().finalizar(atendimento);
		return "Atendimento finalizado. " + getProximoAtendimento(atendimento);
	}
	
	public String encaminhar(Atendimento atendimento) throws Exception {
		
		if(atendimento.getCheckin() == null || atendimento.getCheckin().getId() == 0) {
			throw new Exception("É necessário informar o Checkin do Atendimento.");
		} else if (atendimento.getTarefa() == null || atendimento.getTarefa().getId() == 0) {
			throw new Exception("É necessário informar a Equipe do Atendimento.");
		} else if (atendimento.getFila() == null || atendimento.getFila().getId() == 0) {
			throw new Exception("É necessário informar o Profissional do Atendimento.");
		}
		
		getDao().encaminhar(atendimento);
		return "Atendimento criado com sucesso.";
	}
	
	public String encaminharAvulso(Atendimento atendimento) throws Exception {
		
		if (atendimento.getFila() == null || atendimento.getFila().getId() == 0) {
			throw new Exception("É necessário informar o Profissional do Atendimento.");
		}
		
		//VERIFICAR SE HÁ SOLICITAÇÃO PENDENTE/ABERTA PARA EMPREGADO/EQUIPE/SERVICO
		List<Tarefa> tarefas =  TarefaBo.getInstance().getListTarefasByAtendimento(atendimento);
		if(Helper.isNull(tarefas) || tarefas.size() == 0) {
			throw new Exception("Não há solicitação ABERTA ou PENDENTE.");	
		}
		
		Checkin checkin = new Checkin();
		checkin.setLocalizacao(atendimento.getFila().getLocalizacao());
		checkin.setEmpregado(atendimento.getTarefa().getCliente());
		checkin.setServico(atendimento.getTarefa().getServico());
		
		PagedList<Checkin> checkins = CheckinBo.getInstance().getCheckinByCheckin(checkin, Helper.getToday());
		
		if(checkins.getTotal() > 0) {
			//SE HOUVER, OBTER CHECKIN DO EMPREGADO/SERVICO/LOCALIZACAO/DATA
			checkin = checkins.getList().get(0);
		} else {
			//SE NÃO HOUVER, CRIAR SETANDO TODAS AS TAREFAS ABERTA/PENDENTE/CONCLUÍDA
			checkin.setChegada(Helper.getToday());
			checkin.setTarefas(TarefaBo.getInstance().getListTarefasAbertasPendentesConcluidasByAtendimento(atendimento));
		}
		
		//DEFINIR STATUS DO CHECKIN = AUSENTE
		//CHAMAR PROCEDURE PARA CRIAR ATENDIMENTO NO BANCO
		checkin.setAtualizacao(Helper.getNow());
		checkin.setStatus(StatusCheckin.getInstance().AUSENTE);
		checkin = CheckinBo.getInstance().configurarFichaDeColeta(checkin);
		checkin.getTarefas().stream()
			.filter(t -> !t.getStatus().equals(StatusTarefa.getInstance().CANCELADA) && !t.getStatus().equals(StatusTarefa.getInstance().CONCLUIDA))
			.forEach(t -> t.setStatus(StatusTarefa.getInstance().PENDENTE));
		atendimento.setCheckin(checkin);
		
		//DEFINIR TAREFA DO ATENDIMENTO
		Optional<Tarefa> tarefa =  checkin.getTarefas().stream().filter(t -> t.getEquipe().getId() == atendimento.getTarefa().getEquipe().getId())
			.findFirst();
		
		if(!tarefa.isPresent()) {
			throw new Exception("Não foi possível obter a solicitação.");
		}
		
		atendimento.setTarefa(tarefa.get());
		getDao().encaminharAvulso(atendimento);		
		
		return "Atendimento criado com sucesso.";
	}
	
	private String getProximoAtendimento(Atendimento atendimento) throws Exception {
		getDao().atualizar(atendimento);
		AtendimentoFilter filter = new AtendimentoFilter();
		filter.setPageSize(1);
		filter.setCheckin(new CheckinFilter());
		filter.getCheckin().setId(atendimento.getCheckin().getId());
		filter.setFila(new FilaAtendimentoFilter());
		filter.getFila().setStatus(StatusFilaAtendimento.getInstance().AGUARDANDO_EMPREGADO);
		PagedList<Atendimento> list = getList(filter);
		if(list.getTotal() > 0) {
			Atendimento a = list.getList().get(0); 
			return " Próximo atendimento do(a) empregado(a): " 
					+ a.getFila().getProfissional().getEmpregado().getPessoa().getNome() + " - "
					+ a.getTarefa().getEquipe().getNome() + ".";
		}
		return "";
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
