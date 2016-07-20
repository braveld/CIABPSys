package com.ciabp.actions.superadmin;

import com.ciabp.iservices.IQresultfileService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteQrAction extends ActionSupport{

	private String id;
	private IQresultfileService qresultfileService;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public IQresultfileService getQresultfileService() {
		return qresultfileService;
	}
	public void setQresultfileService(IQresultfileService qresultfileService) {
		this.qresultfileService = qresultfileService;
	}
	
	public String deleteQr(){
		if(qresultfileService.tdelete(Long.parseLong(id))){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
