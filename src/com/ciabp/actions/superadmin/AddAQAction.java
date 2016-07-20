package com.ciabp.actions.superadmin;

import java.util.Map;

import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.Questionaire;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddAQAction extends ActionSupport{
	private IQuestionaireService questionaireService;
	private String qno;
	private String no;
	public IQuestionaireService getQuestionaireService() {
		return questionaireService;
	}
	public void setQuestionaireService(IQuestionaireService questionaireService) {
		this.questionaireService = questionaireService;
	}
	public String getQno() {
		return qno;
	}
	public void setQno(String qno) {
		this.qno = qno;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String addNQ(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		requestMap.put("no", no);
		Questionaire questionaire = new Questionaire();
		questionaire.setNo(no);
		questionaire.setQno(qno);
		if(questionaireService.tdoadd(questionaire)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}

}
