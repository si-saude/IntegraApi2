package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class DetalheRespostaFichaColeta {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="� necess�rio informar o Item do Detalhe.")
	private ItemRespostaFichaColeta item;
	
	@Size(max = 2048, message="Tamanho m�ximo para Conte�do da Resposta da Ficha de Coleta: 2048")
	private String conteudo;
	
	private int ordem;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public ItemRespostaFichaColeta getItem() {
		return item;
	}

	public void setItem(ItemRespostaFichaColeta item) {
		this.item = item;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}	
}
