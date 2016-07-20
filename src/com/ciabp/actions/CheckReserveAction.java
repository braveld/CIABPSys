package com.ciabp.actions;

import java.util.List;
import java.util.Map;


import com.ciabp.iservices.IReserveService;
import com.ciabp.models.Reserve;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckReserveAction extends ActionSupport{
	
	private IReserveService reserveService;
	
	
	public IReserveService getReserveService() {
		return reserveService;
	}


	public void setReserveService(IReserveService reserveService) {
		this.reserveService = reserveService;
	}


	public String findall() {
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		try {
			List<Reserve> list = reserveService.tlistAll();
			requestMap.put("reserveList", list);
			return ActionSupport.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			requestMap.put("errorinfo", "查询商品时数据库发生未知异常！");
			return ActionSupport.ERROR;
		}
	}

}
