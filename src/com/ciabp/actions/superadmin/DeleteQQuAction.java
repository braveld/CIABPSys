package com.ciabp.actions.superadmin;

import java.util.Map;

import com.ciabp.iservices.IQuestionaireService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteQQuAction extends ActionSupport{
	private IQuestionaireService questionaireService;
	private String qno;
	private String quno;
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
	public String getQuno() {
		return quno;
	}
	public void setQuno(String quno) {
		this.quno = quno;
	}
	
	public String deleteQu(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		
		if(questionaireService.tdodelete(quno, qno)){
			System.out.println("zhaodao");
			requestMap.put("no", qno);
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
