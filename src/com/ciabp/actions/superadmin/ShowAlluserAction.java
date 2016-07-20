package com.ciabp.actions.superadmin;

import java.util.Map;
import com.ciabp.models.User;
import com.ciabp.iservices.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAlluserAction extends ActionSupport{
	private IUserService userService;
	private String page;
	private String no;


	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

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
	public String showau(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO",userService.tlistAllByPage(p));
		requestMap.put("actionName", "showau");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	public String showau1(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO",userService.tlistAllByPage(p));
		requestMap.put("actionName", "showau1");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String showau2(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO",userService.tlistAllByPage(p));
		requestMap.put("actionName", "showau2");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String noteshowByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		User user = userService.tfindByNo1(no);
		requestMap.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	public String dnoteshowByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		User user = userService.tfindByNo1(no);
		requestMap.put("user", user);
		return ActionSupport.SUCCESS;
	}
	public String eshowByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		User user = userService.tfindByNo1(no);
		requestMap.put("user", user);
		return ActionSupport.SUCCESS;
	}
}
