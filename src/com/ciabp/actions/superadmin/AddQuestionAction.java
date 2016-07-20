package com.ciabp.actions.superadmin;

import java.util.List;
import java.util.Map;

import com.ciabp.idaos.IQuestionDao;
import com.ciabp.iservices.IQuestionService;
import com.ciabp.models.Question;
import com.ciabp.models.Reserve;
import com.ciabp.utils.Randomten;
import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddQuestionAction extends ActionSupport{
	
	private IQuestionService questionService;
	
	private Question question;
		
	public IQuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}

	public String addQuestion() {
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		
		try {
			if(questionService.tdoaddQuestion(question)){
				sessionMap.put("addQuestion", "true");
				return ActionSupport.SUCCESS;
			}else{
				sessionMap.put("addQuestion", "false");
				sessionMap.put("errorinfo", "添加题目失败，请重新操作");
				return ActionSupport.ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sessionMap.put("errorinfo", "查询商品时数据库发生未知异常！");
			return ActionSupport.ERROR;
		}
	}

}
