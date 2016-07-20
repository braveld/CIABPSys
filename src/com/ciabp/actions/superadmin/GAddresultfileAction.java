package com.ciabp.actions.superadmin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQDetailService;
import com.ciabp.iservices.IQresultfileService;
import com.ciabp.models.QDetail;
import com.ciabp.models.Qresultfile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GAddresultfileAction extends ActionSupport{
	private IQresultfileService qresultfileService;
	private IQDetailService detailService;
	
	
	public IQDetailService getDetailService() {
		return detailService;
	}

	public void setDetailService(IQDetailService detailService) {
		this.detailService = detailService;
	}

	public IQresultfileService getQresultfileService() {
		return qresultfileService;
	}

	public void setQresultfileService(IQresultfileService qresultfileService) {
		this.qresultfileService = qresultfileService;
	}


	public String gqresultfile(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		List<Qresultfile> list = qresultfileService.tlistQr();
		List<QDetail> qdlist = detailService.tlistAll();
		requestMap.put("qresultfilelist", list);
		requestMap.put("qdlist", qdlist);
		return ActionSupport.SUCCESS;
	}
	
	
}
