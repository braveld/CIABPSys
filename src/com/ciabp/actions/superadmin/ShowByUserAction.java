package com.ciabp.actions.superadmin;

import java.util.Map;

import com.ciabp.iservices.IUserService;
import com.ciabp.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowByUserAction extends ActionSupport{
	private IUserService userService;
	private String no;
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public String showByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		User user = userService.tfindByNo(no);
		requestMap.put("user", user);
		return ActionSupport.SUCCESS;
	}
}
