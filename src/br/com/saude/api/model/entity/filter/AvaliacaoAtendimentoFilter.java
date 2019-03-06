package br.com.saude.api.model.entity.filter;

import br.com.saude.api.generic.GenericFilter;

public class AvaliacaoAtendimentoFilter extends GenericFilter {

	private String status;
	private CheckinFilter checkin;
	private QuestionarioFilter questionario;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CheckinFilter getCheckin() {
		return checkin;
	}
	public void setCheckin(CheckinFilter checkin) {
		this.checkin = checkin;
	}
	public QuestionarioFilter getQuestionario() {
		return questionario;
	}
	public void setQuestionario(QuestionarioFilter questionario) {
		this.questionario = questionario;
	}
	
	
}
