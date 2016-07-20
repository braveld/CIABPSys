package com.ciabp.actions.user;

import java.util.Date;
import java.util.Map;

import com.ciabp.iservices.IReserveService;
import com.ciabp.models.Reserve;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReserveAction extends ActionSupport{
	
	private IReserveService reserveService;
	private Reserve reserve;
	public IReserveService getReserveService() {
		return reserveService;
	}
	public void setReserveService(IReserveService reserveService) {
		this.reserveService = reserveService;
	}
	public Reserve getReserve() {
		return reserve;
	}
	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}
	
	public String ureserve(){
		Map<String, Object> sessiontMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String user = (String)sessiontMap.get("name");
		reserve.setDate(new Date());
		reserve.setNo(user);
		reserve.setStatus("审核中");
		if(reserveService.tdoaddReserve(reserve)){
			sessiontMap.put("status", reserve.getStatus());
			sessiontMap.put("reserve", reserve);
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}

}
