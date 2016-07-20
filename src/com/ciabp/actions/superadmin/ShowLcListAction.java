package com.ciabp.actions.superadmin;

import java.util.Map;

import sun.java2d.pipe.hw.AccelDeviceEventListener;

import com.ciabp.iservices.ILinchuangService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowLcListAction extends ActionSupport{
	private ILinchuangService linchuangService;
	private String no;
	private String page;
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public ILinchuangService getLinchuangService() {
		return linchuangService;
	}
	public void setLinchuangService(ILinchuangService linchuangService) {
		this.linchuangService = linchuangService;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String showlcByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO", linchuangService.tlistByUser(no, p));
		requestMap.put("actionName", "showlcByNo");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
}
