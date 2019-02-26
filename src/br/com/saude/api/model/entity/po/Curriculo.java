package br.com.saude.api.model.entity.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
public class Curriculo {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 4096, message="Tamanho máximo para Histórico do Currículo: 4096")
	private String historico;
	
	@Size(max = 512, message="Tamanho máximo para Formação Acadêmica: 512")
	private String formacao;
	
	@Size(max = 512, message="Tamanho máximo para Atuação Profissional: 512")
	private String atuacao;
	
	@OneToMany(mappedBy="curriculo", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<CurriculoCurso> curriculoCursos;
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getAtuacao() {
		return atuacao;
	}

	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public List<CurriculoCurso> getCurriculoCursos() {
		return curriculoCursos;
	}

	public void setCurriculoCursos(List<CurriculoCurso> curriculoCursos) {
		this.curriculoCursos = curriculoCursos;
	}
	
}
