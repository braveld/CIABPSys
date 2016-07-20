package com.ciabp.actions.admin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQDetailService;
import com.ciabp.models.QDetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QAllListAction extends ActionSupport{
	private IQDetailService detailService;
	private Integer page;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public IQDetailService getDetailService() {
		return detailService;
	}

	public void setDetailService(IQDetailService detailService) {
		this.detailService = detailService;
	}
	
	public String qalllist(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null){
			page = 1;
		}
		requestMap.put("pageVO", detailService.tlistByPage(page));
		requestMap.put("actionName", "qalllist");
		return ActionSupport.SUCCESS;
	}
}
