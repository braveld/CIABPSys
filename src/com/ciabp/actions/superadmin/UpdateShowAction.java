package com.ciabp.actions.superadmin;

import java.util.Map;

import com.ciabp.iservices.IQuestionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateShowAction extends ActionSupport{
	private String no;
	private String isshow;
	private IQuestionService questionService;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public IQuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	
	public String updateshow(){
		String s = "";
		if(isshow.equals("显示")){
			s = "不显示";
		}else if(isshow.equals("不显示")){
			s = "显示";
		}
		if(questionService.tdoupdateByNo(no, s)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
