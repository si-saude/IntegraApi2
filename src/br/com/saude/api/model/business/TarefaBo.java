package br.com.saude.api.model.business;

import java.util.ArrayList;
import java.util.List;

import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.TarefaBuilder;
import br.com.saude.api.model.creation.builder.example.TarefaExampleBuilder;
import br.com.saude.api.model.entity.filter.EmpregadoFilter;
import br.com.saude.api.model.entity.filter.ServicoFilter;
import br.com.saude.api.model.entity.filter.TarefaFilter;
import br.com.saude.api.model.entity.po.Atendimento;
import br.com.saude.api.model.entity.po.Checkin;
import br.com.saude.api.model.entity.po.Empregado;
import br.com.saude.api.model.entity.po.Equipe;
import br.com.saude.api.model.entity.po.Servico;
import br.com.saude.api.model.entity.po.Tarefa;
import br.com.saude.api.model.persistence.TarefaDao;
import br.com.saude.api.util.constant.GrupoServico;
import br.com.saude.api.util.constant.StatusTarefa;

public class TarefaBo extends GenericBo<Tarefa, TarefaFilter, TarefaDao, TarefaBuilder, 
	TarefaExampleBuilder> {

	private static TarefaBo instance;
	
	private TarefaBo() {
		super();
	}
	
	public static TarefaBo getInstance() {
		if(instance == null)
			instance = new TarefaBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Tarefa> getList(TarefaFilter filter) throws Exception {
		return super.getDescOrderedList(filter,"inicio");
	}
	
	public String registrar(Tarefa tarefa) throws Exception {
		
		if(!validarServico(tarefa)) {
			throw new Exception("Não foi possível obter o Serviço.");
		}
		
		if(!validarCliente(tarefa)) {
			throw new Exception("Não foi possível obter o Cliente.");
		}
		
		if(!validarData(tarefa)) {
			throw new Exception("Não foi possível obter a Data.");
		}
		
		tarefa = getServico(tarefa);
		
		List<Tarefa> solicitacao = configurarSolicitacao(tarefa);
		if(solicitacao.size() == 0) {
			throw new Exception("Não foi possível definir a(s) tarefa(s) da solicitação.");
		}
		saveList(solicitacao);
		
		return "Solicitação registrada com sucesso.";
	}
	
	private boolean validarServico(Tarefa tarefa) {
		Servico servico = tarefa.getServico();
		if(servico == null || servico.getId() == 0) {
			return false;
		}
		return true;
	}
	
	private boolean validarCliente(Tarefa tarefa) {
		Empregado cliente = tarefa.getCliente();
		if(cliente == null || cliente.getId() == 0) {
			return false;
		}
		return true;
	}
	
	private boolean validarData(Tarefa tarefa) {
		if(tarefa.getInicio() == 0) {
			return false;
		}
		return true;
	}
	
	private Tarefa getServico(Tarefa tarefa) throws Exception {
		tarefa.setServico(ServicoBo.getInstance().getById(tarefa.getServico().getId()));
		return tarefa;
	}	
	
	private List<Tarefa> configurarSolicitacao(Tarefa tarefa) throws Exception {
		List<Tarefa> solicitacao = new ArrayList<Tarefa>();
		Tarefa newTarefa = null;
		for(Equipe equipe : tarefa.getServico().getEquipes()) {
			newTarefa = new Tarefa();
			newTarefa.setServico(tarefa.getServico());
			newTarefa.setCliente(tarefa.getCliente());
			newTarefa.setEquipe(equipe);
			newTarefa.setInicio(tarefa.getInicio());
			newTarefa.setAtualizacao(Helper.getNow());
			newTarefa.setStatus(StatusTarefa.getInstance().ABERTA);
			solicitacao.add(newTarefa);
		}
		
		solicitacao = aplicarRegrasDeNegocio(tarefa, solicitacao);
		
		return solicitacao;
	}
	
	private List<Tarefa> aplicarRegrasDeNegocio(Tarefa tarefa, List<Tarefa> solicitacao) throws Exception {
		switch(tarefa.getServico().getGrupo()) {
			case GrupoServico.ATENDIMENTO_OCUPACIONAL:
				switch(tarefa.getServico().getCodigo()) {
					case "0003":
						solicitacao = validarExamePeriodico(tarefa, solicitacao);
						break;
				}
				break;
		}
		return solicitacao;
	}
	
	private List<Tarefa> validarExamePeriodico(Tarefa tarefa, List<Tarefa> solicitacao) throws Exception {
		String message = "Não é possível solicitar " + tarefa.getServico().getNome() + " pois o empregado " +
				tarefa.getCliente().getPessoa().getNome() + " possui solicitação [replace] para o dia ";
		
		PagedList<Tarefa> pagedList; 
		TarefaFilter filter = new TarefaFilter();
		filter.setPageSize(1);
		filter.setCliente(new EmpregadoFilter());
		filter.getCliente().setId(tarefa.getCliente().getId());
		filter.setServico(new ServicoFilter());
		filter.getServico().setId(tarefa.getServico().getId());
		filter.setStatus(StatusTarefa.getInstance().ABERTA);
		
		pagedList = getList(filter); 
		if(pagedList.getTotal() > 0) {
			throw new Exception(message.replace("[replace]", "em aberto")
					+ Helper.toStringDate(pagedList.getList().get(0).getInicio()) + ".");
		}
		
		filter.setStatus(StatusTarefa.getInstance().CONFIRMADA);
		pagedList = getList(filter); 
		if(pagedList.getTotal() > 0) {
			throw new Exception(message.replace("[replace]", "confirmada")
					+ Helper.toStringDate(pagedList.getList().get(0).getInicio()) + ".");
		}
		
		filter.setStatus(StatusTarefa.getInstance().PENDENTE);
		pagedList = getList(filter); 
		if(pagedList.getTotal() > 0) {
			throw new Exception(message.replace("[replace]", "pendente")
					+ Helper.toStringDate(pagedList.getList().get(0).getInicio()) + ".");
		}
		
		Empregado empregado = EmpregadoBo.getInstance().getById(tarefa.getCliente().getId());
		if(empregado.getGerencia().isAusentePeriodico()) {
			solicitacao.removeIf(t->t.getEquipe().getAbreviacao().equals("HIG"));
		}
		return solicitacao;
	}
	
	public List<Tarefa> getListTarefasByCheckin(Checkin checkin) throws Exception {
		return getBuilder(getDao().getListTarefasByCheckin(checkin.getEmpregado().getId(), 
				checkin.getServico().getId())).getEntityList();
	}
	
	public List<Tarefa> getListTarefasByAtendimento(Atendimento atendimento) throws Exception {
		return getBuilder(getDao().getListTarefasAbertasPendentesByAtendimento(
				atendimento.getTarefa().getCliente().getId(), 
				atendimento.getTarefa().getEquipe().getId(),
				atendimento.getTarefa().getServico().getId())).getEntityList();
	}
	
	public List<Tarefa> getListTarefasAbertasPendentesConcluidasByAtendimento(Atendimento atendimento) throws Exception {
		return getBuilder(getDao().getListTarefasAbertasPendentesConcluidasByAtendimento(
				atendimento.getTarefa().getCliente().getId(), 
				atendimento.getTarefa().getServico().getId())).getEntityList();
	}
}
