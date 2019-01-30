package br.com.saude.api.model.entity.po;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

@Entity
public class Usuario {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="� necess�rio informar a Chave do Usu�rio.")
	@Size(max = 8, message="Tamanho m�ximo para Chave do Usu�rio: 8")
	@Column(unique=true)
	private String chave;
	
	@NotNull(message="� necess�rio informar a Senha do Usu�rio.")
	private String senha;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="usuario_perfil", 
	joinColumns = {@JoinColumn(name="usuario_id")}, 
	inverseJoinColumns = {@JoinColumn(name="perfil_id")})
	private List<Perfil> perfis;
	
	private boolean gestorCss;
	
	@Transient
	private String token;
	
	@Transient
	private Date sessionTime;
	
	@Version
	private long version;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public List<Perfil> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isGestorCss() {
		return gestorCss;
	}
	public void setGestorCss(boolean gestorCss) {
		this.gestorCss = gestorCss;
	}
	public Date getSessionTime() {
		return sessionTime;
	}
	public void setSessionTime(Date sessionTime) {
		this.sessionTime = sessionTime;
	}
}
