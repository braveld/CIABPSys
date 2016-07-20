package com.ciabp.actions.user;

import java.util.Map;

import com.ciabp.iservices.IAnswerService;
import com.ciabp.iservices.IQDetailService;
import com.ciabp.models.QDetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserEnterQAction extends ActionSupport{
	
	private IAnswerService answerService;
	private IQDetailService detailService;
	public IAnswerService getAnswerService() {
		return answerService;
	}
	public void setAnswerService(IAnswerService answerService) {
		this.answerService = answerService;
	}
	public IQDetailService getDetailService() {
		return detailService;
	}
	public void setDetailService(IQDetailService detailService) {
		this.detailService = detailService;
	}
	
	public String enterQ(){
		Map<String, Object> sessiontMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String user = (String)sessiontMap.get("name");
		QDetail detail = detailService.tfindByIsopen();
		if(detail==null){
			return ActionSupport.NONE;
		}
		String no = detail.getNo();
		
		if(answerService.tfindByNo(no, user)!=null){
			return ActionSupport.NONE;
		}else{
			return ActionSupport.SUCCESS;
		}
	}

}
