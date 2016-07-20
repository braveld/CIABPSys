package com.ciabp.actions.superadmin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQuestionService;
import com.ciabp.models.Question;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QuestionListAction extends ActionSupport{
	private IQuestionService questionService;

	public IQuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	
	public String questionlist(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		List<Question> list = questionService.tlistAll();
		requestMap.put("questionlist", list);
		return ActionSupport.SUCCESS;
	}
}
