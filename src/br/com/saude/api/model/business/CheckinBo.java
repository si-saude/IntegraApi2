package br.com.saude.api.model.business;

import br.com.saude.api.generic.DateFilter;
import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.CheckinBuilder;
import br.com.saude.api.model.creation.builder.example.CheckinExampleBuilder;
import br.com.saude.api.model.entity.filter.CheckinFilter;
import br.com.saude.api.model.entity.filter.EmpregadoFilter;
import br.com.saude.api.model.entity.filter.LocalizacaoFilter;
import br.com.saude.api.model.entity.filter.ServicoFilter;
import br.com.saude.api.model.entity.po.Checkin;
import br.com.saude.api.model.persistence.CheckinDao;
import br.com.saude.api.util.constant.StatusCheckin;
import br.com.saude.api.util.constant.StatusTarefa;
import br.com.saude.api.util.constant.TypeFilter;

public class CheckinBo extends GenericBo<Checkin, CheckinFilter, CheckinDao, CheckinBuilder, 
	CheckinExampleBuilder> {

	private static CheckinBo instance;
	
	private CheckinBo() {
		super();
	}
	
	public static CheckinBo getInstance() {
		if(instance == null)
			instance = new CheckinBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<Checkin> getList(CheckinFilter filter) throws Exception {
		return super.getOrderedList(filter,"chegada");
	}
	
	public String registrar(Checkin checkin) throws Exception {
		
		PagedList<Checkin> checkins = getCheckinByCheckin(checkin, Helper.getToday());
		
		if(checkins.getTotal() > 0) {
			String message = "Não é possível realizar o check-in do(a) empregado(a) "
					+ checkin.getEmpregado().getPessoa().getNome()+"."
					+ "Status atual: ";
			
			if(checkins.getList().stream()
				.filter(c->c.getStatus().equals(StatusCheckin.getInstance().AGUARDANDO))
				.count() > 0) {
				throw new Exception(message + StatusCheckin.getInstance().AGUARDANDO);
			} else if(checkins.getList().stream()
				.filter(c->c.getStatus().equals(StatusCheckin.getInstance().EM_ATENDIMENTO))
				.count() > 0) {
				throw new Exception(message + StatusCheckin.getInstance().EM_ATENDIMENTO);
			} else if(checkins.getList().stream()
				.filter(c->c.getStatus().equals(StatusCheckin.getInstance().AUSENTE))
				.count() > 0) {
				checkin = checkins.getList().stream()
						.filter(c->c.getStatus().equals(StatusCheckin.getInstance().AUSENTE))
						.findFirst().get();
			}
		}
		
		checkin.setChegada(Helper.getNow());
		checkin.setAtualizacao(checkin.getChegada());
		checkin.setStatus(StatusCheckin.getInstance().AGUARDANDO);
		checkin.setTarefas(TarefaBo.getInstance().getListTarefasByCheckin(checkin));
		this.save(checkin);
		return "Check-in registrado com sucesso.";
	}
	
	private PagedList<Checkin> getCheckinByCheckin(Checkin checkin, long date) throws Exception {
		CheckinFilter filter = new CheckinFilter();
		filter.setPageSize(Integer.MAX_VALUE);
		filter.setEmpregado(new EmpregadoFilter());
		filter.getEmpregado().setId(checkin.getEmpregado().getId());
		filter.setServico(new ServicoFilter());
		filter.getServico().setId(checkin.getServico().getId());
		filter.setLocalizacao(new LocalizacaoFilter());
		filter.getLocalizacao().setId(checkin.getLocalizacao().getId());
		filter.setChegada(new DateFilter());
		filter.getChegada().setInicio(date);
		filter.getChegada().setFim(Helper.addDays(date, 1));
		filter.getChegada().setTypeFilter(TypeFilter.ENTRE);
		return getList(filter);
	}
	
	public String checkOut(Checkin checkin) throws Exception {
		
		if(checkin.getStatus().equals(StatusCheckin.getInstance().FINALIZADO)) {
			throw new Exception("Não é possível realizar o check-out do(a) empregado(a). "
					+ "Status atual: " + checkin.getStatus());
		}
		
		if(Helper.isNotNull(checkin.getTarefas())) {
			checkin.getTarefas().stream()
			.filter(t -> t.getStatus().equals(StatusTarefa.getInstance().ABERTA))
			.forEach(t -> t.setStatus(StatusTarefa.getInstance().PENDENTE));
		}
		
		checkin.setAtualizacao(Helper.getNow());
		checkin.setStatus(StatusCheckin.getInstance().AUSENTE);
		this.save(checkin);
		return "Check-out registrado com sucesso.";
	}
}
