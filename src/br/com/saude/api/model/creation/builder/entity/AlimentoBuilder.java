package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.AlimentoFilter;
import br.com.saude.api.model.entity.po.Alimento;

public class AlimentoBuilder extends GenericEntityBuilder<Alimento, AlimentoFilter> {

	public static AlimentoBuilder newInstance(Alimento alimento) {
		return new AlimentoBuilder(alimento);
	}
	
	public static AlimentoBuilder newInstance(List<Alimento> alimentos) {
		return new AlimentoBuilder(alimentos);
	}
	
	private AlimentoBuilder(Alimento alimento) {
		super(alimento);
	}
	
	private AlimentoBuilder(List<Alimento> alimentos) {
		super(alimentos);
	}

	@Override
	protected Alimento clone(Alimento alimento) {
		Alimento newAlimento = new Alimento();
		
		newAlimento.setId(alimento.getId());
		newAlimento.setNome(alimento.getNome());
		newAlimento.setTipo(alimento.getTipo());
		newAlimento.setPadrao(alimento.getPadrao());
		newAlimento.setEnergia(alimento.getEnergia());
		newAlimento.setProteina(alimento.getProteina());
		newAlimento.setLipideos(alimento.getLipideos());
		newAlimento.setSaturada(alimento.getSaturada());
		newAlimento.setMonoinsaturada(alimento.getMonoinsaturada());
		newAlimento.setPoliinsaturada(alimento.getPoliinsaturada());
		newAlimento.setOmega6(alimento.getOmega6());
		newAlimento.setOmega3(alimento.getOmega3());
		newAlimento.setColesterol(alimento.getColesterol());
		newAlimento.setCho(alimento.getCho());
		newAlimento.setFibra(alimento.getFibra());
		newAlimento.setCalcio(alimento.getCalcio());
		newAlimento.setMg(alimento.getMg());
		newAlimento.setMn(alimento.getMn());
		newAlimento.setP(alimento.getP());
		newAlimento.setFerro(alimento.getFerro());
		newAlimento.setSodio(alimento.getSodio());
		newAlimento.setPotassio(alimento.getPotassio());
		newAlimento.setCobre(alimento.getCobre());
		newAlimento.setZinco(alimento.getZinco());
		newAlimento.setRetinol(alimento.getRetinol());
		newAlimento.setTiamina(alimento.getTiamina());
		newAlimento.setRiboflavina(alimento.getRiboflavina());
		newAlimento.setPiridoxina(alimento.getPiridoxina());
		newAlimento.setNiacina(alimento.getNiacina());
		newAlimento.setVitc(alimento.getVitc());
		newAlimento.setVitd(alimento.getVitd());
		newAlimento.setVite(alimento.getVite());
		newAlimento.setInativo(alimento.isInativo());
		newAlimento.setVersion(alimento.getVersion());
		
		return newAlimento;
	}
	
	public AlimentoBuilder loadAlimentosMedidaCaseira() throws Exception {
		return (AlimentoBuilder) this.loadProperty("alimentosMedidaCaseira", alimento -> {
			return AlimentoMedidaCaseiraBuilder.newInstance(alimento.getAlimentosMedidaCaseira()).getEntityList();
		});
	}
	
	public AlimentoBuilder loadSubstituicoes() throws Exception {
		return (AlimentoBuilder) this.loadProperty("substituicoes", alimento -> {
			return AlimentoBuilder.newInstance(alimento.getSubstituicoes()).getEntityList();
		});
	}
}
