package br.com.saude.api.model.business;

import java.util.List;

import br.com.saude.api.generic.DateFilter;
import br.com.saude.api.generic.GenericBo;
import br.com.saude.api.generic.Helper;
import br.com.saude.api.generic.PagedList;
import br.com.saude.api.model.creation.builder.entity.FilaAtendimentoBuilder;
import br.com.saude.api.model.creation.builder.example.FilaAtendimentoExampleBuilder;
import br.com.saude.api.model.entity.filter.FilaAtendimentoFilter;
import br.com.saude.api.model.entity.filter.LocalizacaoFilter;
import br.com.saude.api.model.entity.filter.ProfissionalFilter;
import br.com.saude.api.model.entity.po.FilaAtendimento;
import br.com.saude.api.model.persistence.FilaAtendimentoDao;
import br.com.saude.api.util.constant.StatusFilaAtendimento;
import br.com.saude.api.util.constant.TypeFilter;

public class FilaAtendimentoBo extends GenericBo<FilaAtendimento, FilaAtendimentoFilter, FilaAtendimentoDao, FilaAtendimentoBuilder, 
	FilaAtendimentoExampleBuilder> {

	private static FilaAtendimentoBo instance;
	
	private FilaAtendimentoBo() {
		super();
	}
	
	public static FilaAtendimentoBo getInstance() {
		if(instance == null)
			instance = new FilaAtendimentoBo();
		return instance;
	}

	@Override
	protected void initializeFunctions() {
		
	}
	
	@Override
	public PagedList<FilaAtendimento> getList(FilaAtendimentoFilter filter) throws Exception {
		return super.getDescOrderedList(filter,"data");
	}
	
	public List<FilaAtendimento> getListNaoEncerrado(FilaAtendimentoFilter filter) throws Exception {
		filter.setPageSize(Integer.MAX_VALUE);
		PagedList<FilaAtendimento> filas = this.getList(filter);
		if(filas.getTotal() > 0) {
			filas.getList().removeIf(f -> f.getStatus()
					.equals(StatusFilaAtendimento.getInstance().ENCERRADO));
		}
		return filas.getList();
	}
	
	public FilaAtendimento entrarOuVoltar(FilaAtendimento fila) throws Exception {
		
		long hoje = Helper.getToday();
		
		FilaAtendimentoFilter filter = new FilaAtendimentoFilter();
		filter.setPageSize(1);
		filter.setProfissional(new ProfissionalFilter());
		filter.getProfissional().setId(fila.getProfissional().getId());
		filter.setLocalizacao(new LocalizacaoFilter());
		filter.getLocalizacao().setId(fila.getLocalizacao().getId());
		filter.setData(new DateFilter());
		filter.getData().setInicio(hoje);
		filter.getData().setTypeFilter(TypeFilter.IGUAL);
		PagedList<FilaAtendimento> list = this.getList(filter);
		
		if(list.getTotal() > 0) {
			fila = list.getList().get(0);
		}
		
		fila.setData(hoje);
		fila.setStatus(StatusFilaAtendimento.getInstance().DISPONIVEL);
		fila = super.save(fila);
		return this.getById(fila.getId());
	}
	
	public FilaAtendimento pausar(FilaAtendimento fila) throws Exception {
		fila.setStatus(StatusFilaAtendimento.getInstance().INDISPONIVEL);
		fila = super.save(fila);
		return this.getById(fila.getId());
	}
	
	public FilaAtendimento encerrar(FilaAtendimento fila) throws Exception {
		fila.setStatus(StatusFilaAtendimento.getInstance().ENCERRADO);
		return super.save(fila);
	}
}
