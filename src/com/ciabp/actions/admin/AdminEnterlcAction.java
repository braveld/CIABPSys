package com.ciabp.actions.admin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminEnterlcAction extends ActionSupport{

	private String no;
	private String page;
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	public String tiao(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		requestMap.put("no", no);
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
}
