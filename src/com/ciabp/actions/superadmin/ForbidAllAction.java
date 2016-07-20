package com.ciabp.actions.superadmin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQDetailService;
import com.ciabp.models.QDetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ForbidAllAction extends ActionSupport{

	private IQDetailService detailService;

	public IQDetailService getDetailService() {
		return detailService;
	}

	public void setDetailService(IQDetailService detailService) {
		this.detailService = detailService;
	}
	
	public String forbidall(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		if(detailService.tforbid()){
			List<QDetail> list = detailService.tlistAll();
			sessionMap.put("detaillist", list);
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
