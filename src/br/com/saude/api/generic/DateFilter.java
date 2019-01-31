package br.com.saude.api.generic;

public class DateFilter {
	private long inicio;
	private long fim;
	private TypeFilter typeFilter;
	
	public long getInicio() {
		return inicio;
	}
	public void setInicio(long inicio) {
		this.inicio = inicio;
	}
	public long getFim() {
		return fim;
	}
	public void setFim(long fim) {
		this.fim = fim;
	}
	public TypeFilter getTypeFilter() {
		return typeFilter;
	}
	public void setTypeFilter(TypeFilter typeFilter) {
		this.typeFilter = typeFilter;
	}
}
