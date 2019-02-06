package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.IndicadorSastFilter;
import br.com.saude.api.model.entity.po.IndicadorSast;

public class IndicadorSastBuilder extends GenericEntityBuilder<IndicadorSast, IndicadorSastFilter> {

	public static IndicadorSastBuilder newInstance(IndicadorSast indicador) {
		return new IndicadorSastBuilder(indicador);
	}
	
	public static IndicadorSastBuilder newInstance(List<IndicadorSast> indicadores) {
		return new IndicadorSastBuilder(indicadores);
	}
	
	private IndicadorSastBuilder(IndicadorSast indicador) {
		super(indicador);
	}
	
	private IndicadorSastBuilder(List<IndicadorSast> indicadores) {
		super(indicadores);
	}

	@Override
	protected IndicadorSast clone(IndicadorSast indicador) {
		IndicadorSast newIndicadorSast = new IndicadorSast();
		
		newIndicadorSast.setId(indicador.getId());
		newIndicadorSast.setCodigo(indicador.getCodigo());
		newIndicadorSast.setCodigoExcludente(indicador.getCodigoExcludente());
		newIndicadorSast.setAusenteCalculoInterdisciplinar(indicador.isAusenteCalculoInterdisciplinar());
		newIndicadorSast.setCritico(indicador.getCritico());
		newIndicadorSast.setInativo(indicador.isInativo());
		newIndicadorSast.setIndice0(indicador.getIndice0());
		newIndicadorSast.setIndice1(indicador.getIndice1());
		newIndicadorSast.setIndice2(indicador.getIndice2());
		newIndicadorSast.setIndice3(indicador.getIndice3());
		newIndicadorSast.setIndice4(indicador.getIndice4());
		newIndicadorSast.setNome(indicador.getNome());
		newIndicadorSast.setObrigatorio(indicador.isObrigatorio());
		newIndicadorSast.setInativo(indicador.isInativo());
		newIndicadorSast.setVersion(indicador.getVersion());
		return newIndicadorSast;
	}	
	
	public IndicadorSastBuilder loadEquipe() throws Exception {
		return (IndicadorSastBuilder) this.loadProperty("equipe", indicador -> {
			return EquipeBuilder.newInstance(indicador.getEquipe()).getEntity();
		});
	}
	
	public IndicadorSastBuilder loadIndicadores() throws Exception {
		return (IndicadorSastBuilder) this.loadProperty("indicadorAssociadoSasts", indicador -> {
			return IndicadorAssociadoSastBuilder
					.newInstance(indicador.getIndicadorAssociadoSasts()).getEntityList();
		});
	}
}
