package com.ciabp.actions.admin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IReserveService;
import com.ciabp.models.Reserve;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowRBySAction extends ActionSupport{
	
	private IReserveService reserveService;
	private String status;
	public IReserveService getReserveService() {
		return reserveService;
	}
	public void setReserveService(IReserveService reserveService) {
		this.reserveService = reserveService;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String showRByS(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		List<Reserve> list = reserveService.tlistByStatus(status);
		sessionMap.put("rlist", list);
		return ActionSupport.SUCCESS;
	}

}
