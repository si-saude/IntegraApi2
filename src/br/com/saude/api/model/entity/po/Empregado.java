package br.com.saude.api.model.entity.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Empregado {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="É necessário informar a Chave do Empregado.")
	@Size(max = 4, message="Tamanho máximo para Chave de Empregado: 4")
	private String chave;
	
	@NotNull(message="É necessário informar a Matrícula do Empregado.")
	@Size(max = 16, message="Tamanho máximo para Matrícula de Empregado: 16")
	private String matricula;
	
	@Size(max = 16, message="Tamanho máximo para Ramal de Empregado: 16")
	private String ramal;
	
	@Size(max = 16, message="Tamanho máximo para Status de Empregado: 16")
	private String status;
	
	@Size(max = 16, message="Tamanho máximo para Estado Civil de Empregado: 16")
	private String estadoCivil;
	
	@Size(max = 128, message="Tamanho máximo para Escolaridade de Empregado: 128")
	private String escolaridade;
	
	@Size(max = 20, message="Tamanho máximo para PIS de Empregado: 20")
	private String pis;
	
	@Size(max = 128, message="Tamanho máximo para Email: 128")
	@Email(message="Valor inválido para Email.")
	private String email;
	
	private long dataAdmissao;
	
	@Size(max = 32, message="Tamanho máximo para Vínculo de Empregado: 32")
	@NotNull(message="É necessário informar o Vínculo de Empregado.")
	private String vinculo;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "pessoa_id")
	@NotNull(message="É necessário informar a Pessoa.")
	private Pessoa pessoa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="É necessário informar o Cargo de Empregado.")
	private Cargo cargo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="É necessário informar a Função de Empregado.")
	private Funcao funcao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="É necessário informar a Ênfase de Empregado.")
	private Enfase enfase;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Regime regime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="É necessário informar a Gerência de Empregado.")
	private Gerencia gerencia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="É necessário informar a Base de Empregado.")
	private Base base;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Ghe ghe;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Ghee ghee;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinTable(name="empregado_grupomonitoramento", 
				joinColumns = {@JoinColumn(name="empregado_id")}, 
				inverseJoinColumns = {@JoinColumn(name="grupomonitoramento_id")})
	private List<GrupoMonitoramento> grupoMonitoramentos;
	
	@Lob
	private String assinatura;
	
	@Lob
	private String foto;
	
	@Version
	private long version;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getVinculo() {
		return vinculo;
	}
	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	public Regime getRegime() {
		return regime;
	}
	public void setRegime(Regime regime) {
		this.regime = regime;
	}
	public Gerencia getGerencia() {
		return gerencia;
	}
	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}
	public Base getBase() {
		return base;
	}
	public void setBase(Base base) {
		this.base = base;
	}
	public Ghe getGhe() {
		return ghe;
	}
	public void setGhe(Ghe ghe) {
		this.ghe = ghe;
	}
	public Ghee getGhee() {
		return ghee;
	}
	public void setGhee(Ghee ghee) {
		this.ghee = ghee;
	}
	public List<GrupoMonitoramento> getGrupoMonitoramentos() {
		return grupoMonitoramentos;
	}
	public void setGrupoMonitoramentos(List<GrupoMonitoramento> grupoMonitoramentos) {
		this.grupoMonitoramentos = grupoMonitoramentos;
	}	
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public long getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(long dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public Enfase getEnfase() {
		return enfase;
	}
	public void setEnfase(Enfase enfase) {
		this.enfase = enfase;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getAssinatura() {
		return assinatura;
	}
	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}
	@Override
	public boolean equals(Object empregado) {
		return ((Empregado)empregado).id == this.id && this.id > 0;
	}
}
