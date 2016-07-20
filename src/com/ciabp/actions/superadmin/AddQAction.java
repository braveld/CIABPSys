package com.ciabp.actions.superadmin;


import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.Question;
import com.ciabp.models.Questionaire;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddQAction extends ActionSupport{
	
	private IQuestionaireService questionaireService;;
	private Questionaire questionaire;

	public IQuestionaireService getQuestionaireService() {
		return questionaireService;
	}

	public void setQuestionaireService(IQuestionaireService questionaireService) {
		this.questionaireService = questionaireService;
	}

	public Questionaire getQuestionaire() {
		return questionaire;
	}

	public void setQuestionaire(Questionaire questionaire) {
		this.questionaire = questionaire;
	}

	public String addQ(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		List<Question> list = (List<Question>)sessionMap.get("questionlist");
		for(int i = 0;i < list.size();i++){
			if(list.get(i).getNo().equals(questionaire.getQno())){
				list.remove(i);
			}
		}
		if(questionaireService.tdoadd(questionaire)){
			sessionMap.put("questionlist", list);
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}

}
