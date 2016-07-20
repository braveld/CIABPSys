package com.ciabp.actions.user;

import java.util.Map;

import com.ciabp.iservices.IReserveService;
import com.ciabp.models.Reserve;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowRStatusAction extends ActionSupport{
	
	private IReserveService reserveService;

	public IReserveService getReserveService() {
		return reserveService;
	}

	public void setReserveService(IReserveService reserveService) {
		this.reserveService = reserveService;
	}
	
	public String showRStatus(){
		Map<String, Object> sessiontMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String user = (String)sessiontMap.get("name");
		Reserve reserve = reserveService.tfindByNo(user);
		if(reserve == null){
			return ActionSupport.NONE;
		}else{
			if(reserve.getStatus().equals("通过")){
				return ActionSupport.INPUT;
			}
			sessiontMap.put("reserve", reserve);
			sessiontMap.put("status", reserve.getStatus());
			return ActionSupport.SUCCESS;
		}
	}

}
