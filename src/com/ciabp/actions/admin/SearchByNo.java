package com.ciabp.actions.admin;

import java.util.Map;

import com.ciabp.iservices.IUserService;
import com.ciabp.models.PageVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchByNo extends ActionSupport{
	private IUserService userService;
	private String yonghuming;
	private String qno;
	
	public String getQno() {
		return qno;
	}
	public void setQno(String qno) {
		this.qno = qno;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String getYonghuming() {
		return yonghuming;
	}
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	public String searchbuno(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		PageVO pageVO = userService.tlistByNick(yonghuming);
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "showUlist");
		requestMap.put("qno", qno);
		requestMap.put("page", "1");
		return ActionSupport.SUCCESS;
	}
	public String searchbyno(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		PageVO pageVO = userService.tlistByNick(yonghuming);
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "showUlist");
		requestMap.put("qno", qno);
		requestMap.put("page", "1");
		return ActionSupport.SUCCESS;
	}
	public String searchbynosshowallu(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		PageVO pageVO = userService.tlistByNick(yonghuming);
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "showUlist");
		requestMap.put("qno", qno);
		requestMap.put("page", "1");
		return ActionSupport.SUCCESS;
	}

	public String searchbynoashowallu(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		PageVO pageVO = userService.tlistByNick(yonghuming);
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "showUlist");
		requestMap.put("qno", qno);
		requestMap.put("page", "1");
		return ActionSupport.SUCCESS;
	}
}
