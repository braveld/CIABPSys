package com.ciabp.actions.superadmin;

import java.util.Map;

import com.ciabp.iservices.IQuestionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteQuestionAction extends ActionSupport{

	private IQuestionService questionService;
	private String no;
	public IQuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public String deletequestion(){
		if(questionService.tdodelete(no)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
