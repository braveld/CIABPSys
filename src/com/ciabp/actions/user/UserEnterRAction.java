package com.ciabp.actions.user;

import java.util.Map;

import com.ciabp.iservices.IReserveService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserEnterRAction extends ActionSupport{
	
	private IReserveService reserveService;

	public IReserveService getReserveService() {
		return reserveService;
	}

	public void setReserveService(IReserveService reserveService) {
		this.reserveService = reserveService;
	}
	
	public String enterR(){
		Map<String, Object> sessiontMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String user = (String)sessiontMap.get("name");
		System.out.println(user);
		if(reserveService.tfindByNo(user)!=null){
			System.out.println("success");
			return ActionSupport.SUCCESS;
		}else{
			System.out.println("none");
			return ActionSupport.NONE;
		}
	}

}
