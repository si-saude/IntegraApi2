package br.com.saude.api.model.creation.builder.entity;

import java.util.List;

import br.com.saude.api.generic.GenericEntityBuilder;
import br.com.saude.api.model.entity.filter.ImovelFilter;
import br.com.saude.api.model.entity.po.Imovel;

public class ImovelBuilder extends GenericEntityBuilder<Imovel, ImovelFilter> {

	public static ImovelBuilder newInstance(Imovel imovel) {
		return new ImovelBuilder(imovel);
	}
	
	public static ImovelBuilder newInstance(List<Imovel> imovels) {
		return new ImovelBuilder(imovels);
	}
	
	private ImovelBuilder(Imovel imovel) {
		super(imovel);
	}
	
	private ImovelBuilder(List<Imovel> imovels) {
		super(imovels);
	}

	@Override
	protected Imovel clone(Imovel imovel) {
		Imovel newImovel = new Imovel();
		
		newImovel.setId(imovel.getId());
		newImovel.setNome(imovel.getNome());
		newImovel.setVersion(imovel.getVersion());
		
		return newImovel;
	}

	public ImovelBuilder loadBase() throws Exception {
		return (ImovelBuilder) this.loadProperty("base", imovel -> {
			return BaseBuilder.newInstance(imovel.getBase()).getEntity();
		});
	}
}
