package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.GenericFilter;

public class EmpregadoFilter extends GenericFilter {

	private PessoaFilter pessoa;
	private String chave;
	private String matricula;
	private String status;
	private String vinculo;
	private CargoFilter cargo;
	private FuncaoFilter funcao;
	private EnfaseFilter enfase;
	private RegimeFilter regime;
	private GerenciaFilter gerencia;
	private BaseFilter base;
	private GheFilter ghe;
	private GheeFilter ghee;
	
	public PessoaFilter getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaFilter pessoa) {
		this.pessoa = pessoa;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVinculo() {
		return vinculo;
	}
	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}
	public CargoFilter getCargo() {
		return cargo;
	}
	public void setCargo(CargoFilter cargo) {
		this.cargo = cargo;
	}
	public FuncaoFilter getFuncao() {
		return funcao;
	}
	public void setFuncao(FuncaoFilter funcao) {
		this.funcao = funcao;
	}
	public EnfaseFilter getEnfase() {
		return enfase;
	}
	public void setEnfase(EnfaseFilter enfase) {
		this.enfase = enfase;
	}
	public RegimeFilter getRegime() {
		return regime;
	}
	public void setRegime(RegimeFilter regime) {
		this.regime = regime;
	}
	public GerenciaFilter getGerencia() {
		return gerencia;
	}
	public void setGerencia(GerenciaFilter gerencia) {
		this.gerencia = gerencia;
	}
	public BaseFilter getBase() {
		return base;
	}
	public void setBase(BaseFilter base) {
		this.base = base;
	}
	public GheFilter getGhe() {
		return ghe;
	}
	public void setGhe(GheFilter ghe) {
		this.ghe = ghe;
	}
	public GheeFilter getGhee() {
		return ghee;
	}
	public void setGhee(GheeFilter ghee) {
		this.ghee = ghee;
	}
}
