package com.ciabp.actions.admin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IUserService;
import com.ciabp.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LcShowUserAction extends ActionSupport{
	private IUserService userService;
	private String page;

	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public String lcshowuser(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO", userService.tlistAllByPage(p));
		requestMap.put("actionName", "lcshowuser");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
		
	}

}
