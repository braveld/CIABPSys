package com.ciabp.actions.admin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IReserveService;
import com.ciabp.models.Reserve;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateStatusActioin extends ActionSupport{

	private IReserveService reserveService;
	private String no;
	private String status;
	public IReserveService getReserveService() {
		return reserveService;
	}
	public void setReserveService(IReserveService reserveService) {
		this.reserveService = reserveService;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String updateS(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		List<Reserve> list = (List<Reserve>)sessionMap.get("rlist");
		String s = "";
		if(status.equals("审核中")){
			s = "通过";
		}else if(status.equals("通过")){
			s = "收到血清";
		}else if(status.equals("收到血清")){
			s = "检测完成";
		}else{
			return ActionSupport.SUCCESS;
		}
		if(reserveService.tdoupdateStatus(no, s)){
			for(int i =0;i < list.size();i++){
				if(list.get(i).getNo().equals(no)){
					list.remove(i);
				}
			}
			sessionMap.put("rlist", list);
		}
		return ActionSupport.SUCCESS;
	}
}
