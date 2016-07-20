package com.ciabp.actions.user;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQDetailService;
import com.ciabp.models.QDetail;
import com.ciabp.models.Qresult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckQlistAction extends ActionSupport{
	private IQDetailService detailService;

	public IQDetailService getDetailService() {
		return detailService;
	}

	public void setDetailService(IQDetailService detailService) {
		this.detailService = detailService;
	}
	
	public String checkQlist(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String no = (String)sessionMap.get("name");
		List<QDetail> list = detailService.tlistByUser(no);
		requestMap.put("UQList", list);
		return ActionSupport.SUCCESS;
	}

}
