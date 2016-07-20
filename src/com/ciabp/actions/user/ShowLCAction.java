package com.ciabp.actions.user;

import java.util.Map;

import com.ciabp.iservices.ILinchuangService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowLCAction extends ActionSupport{
	private ILinchuangService linchuangService;
	private String page;
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public ILinchuangService getLinchuangService() {
		return linchuangService;
	}
	public void setLinchuangService(ILinchuangService linchuangService) {
		this.linchuangService = linchuangService;
	}
	public String showlinchuang(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String no = (String)sessionMap.get("name");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO", linchuangService.tlistByUser(no, p));
		requestMap.put("actionName", "showlinchuang");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}

}
