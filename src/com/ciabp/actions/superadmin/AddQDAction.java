package com.ciabp.actions.superadmin;

import com.ciabp.iservices.IQDetailService;
import com.ciabp.models.QDetail;
import com.opensymphony.xwork2.ActionSupport;

public class AddQDAction extends ActionSupport{
	
	private IQDetailService detailService;
	private String no;
	private String name;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IQDetailService getDetailService() {
		return detailService;
	}
	public void setDetailService(IQDetailService detailService) {
		this.detailService = detailService;
	}
	
	
	public String addQD(){
		QDetail qDetail = new QDetail();
		qDetail.setNo(no);
		qDetail.setName(name);
		if(detailService.tdoaddQD(qDetail)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}

}
