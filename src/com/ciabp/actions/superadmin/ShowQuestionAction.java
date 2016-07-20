package com.ciabp.actions.superadmin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQuestionService;
import com.ciabp.models.Question;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowQuestionAction extends ActionSupport{
	
	private IQuestionService questionService;
	private String qname;	
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public IQuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}

	public String show(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");			
		try {		
				List<Question> list = questionService.tlistByS();
				sessionMap.put("questionlist", list);
				sessionMap.put("qname", qname);
				return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
			sessionMap.put("errorinfo", "查询时数据库发生未知异常！");
			return ActionSupport.ERROR;
		}
		
	}

}
