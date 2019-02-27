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
		
		Checkin checkinAux = getCheckinByCheckin(checkin, Helper.getToday());
		if(checkinAux != null) {
			if(Helper.isStringIn(checkinAux.getStatus(), new String[] {
					StatusCheckin.getInstance().AGUARDANDO, StatusCheckin.getInstance().EM_ATENDIMENTO
			})) {
				throw new Exception("Não é possível realizar o check-in do(a) empregado(a). "
						+ "Status atual: " + checkinAux.getStatus());
			} else if (checkinAux.getStatus().equals(StatusCheckin.getInstance().AUSENTE)) {
				checkin = getBuilder(checkinAux).getEntity();
			}
		}
		
		checkin.setChegada(Helper.getNow());
		checkin.setAtualizacao(checkin.getChegada());
		checkin.setStatus(StatusCheckin.getInstance().AGUARDANDO);
		checkin.setTarefas(TarefaBo.getInstance().getListTarefasByCheckin(checkin));
		this.save(checkin);
		return "Check-in registrado com sucesso.";
	}
	
	private Checkin getCheckinByCheckin(Checkin checkin, long date) throws Exception {
		CheckinFilter filter = new CheckinFilter();
		filter.setPageSize(1);
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
		PagedList<Checkin> list = getList(filter);
		return list.getTotal() > 0 ? list.getList().get(0) : null;
	}
}
