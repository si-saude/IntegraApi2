package br.com.saude.api.model.entity.po;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
public class Endereco {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 200, message="Tamanho m�ximo para Logradouro do Endere�o: 200")
	private String logradouro;
	
	@Size(max = 12, message="Tamanho m�ximo para N�mero do Endere�o: 12")
	private String numero;
	
	@Size(max = 200, message="Tamanho m�ximo para Complemento do Endere�o: 200")
	private String complemento;
	
	@Size(max = 100, message="Tamanho m�ximo para Bairro do Endere�o: 100")
	private String bairro;
	
	@Size(max = 9, message="Tamanho m�ximo para Cep do Endere�o: 9")
	private String cep;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Cidade cidade;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}	
}
