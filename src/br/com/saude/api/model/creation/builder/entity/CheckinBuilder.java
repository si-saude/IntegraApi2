package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.model.entity.filter.CheckinFilter;
import br.com.saude.api.model.entity.po.Checkin;

public class CheckinBuilder extends GenericEntityBuilder<Checkin, CheckinFilter> {

	public static CheckinBuilder newInstance(Checkin checkin) {
		return new CheckinBuilder(checkin);
	}
	
	public static CheckinBuilder newInstance(List<Checkin> checkins) {
		return new CheckinBuilder(checkins);
	}
	
	private CheckinBuilder(Checkin checkin) {
		super(checkin);
	}
	
	private CheckinBuilder(List<Checkin> checkins) {
		super(checkins);
	}

	@Override
	protected Checkin clone(Checkin checkin) {
		Checkin newCheckin = new Checkin();
		
		newCheckin.setId(checkin.getId());
		newCheckin.setAtualizacao(checkin.getAtualizacao());
		newCheckin.setChegada(checkin.getChegada());
		newCheckin.setStatus(checkin.getStatus());
		newCheckin.setVersion(checkin.getVersion());

		if(checkin.getEmpregado() != null)
			newCheckin.setEmpregado(EmpregadoBuilder.newInstance(checkin.getEmpregado()).getEntity());
		
		if(checkin.getLocalizacao() != null)
			newCheckin.setLocalizacao(LocalizacaoBuilder.newInstance(checkin.getLocalizacao()).getEntity());

		if(checkin.getServico() != null)
			newCheckin.setServico(ServicoBuilder.newInstance(checkin.getServico()).getEntity());
		
		if(Helper.isNotNull(checkin.getTarefas())) {
			newCheckin.setTarefas(TarefaBuilder.newInstance(checkin.getTarefas()).getEntityList());
		}
		
		return newCheckin;
	}	
}
