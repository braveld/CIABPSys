package com.ciabp.actions.user;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.ISnoteService;
import com.ciabp.models.PageVO;
import com.ciabp.models.Snote;
import com.ciabp.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserShowSnoteAction extends ActionSupport{
	private ISnoteService snoteService;
	private String page;
	private String no;
	public ISnoteService getSnoteService() {
		return snoteService;
	}
	public void setSnoteService(ISnoteService snoteService) {
		this.snoteService = snoteService;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public String adshowsnote(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page == null || page.equals("")){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		PageVO pageVO = snoteService.tlistAllByPage(p);
		System.out.println(pageVO.getList());
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "adshowsnote");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String showBySno(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Snote snote = snoteService.tfindByNo(no);
		System.out.println(snote.getNo());
		System.out.println(snote.getContent());
		requestMap.put("snote", snote);
		return ActionSupport.SUCCESS;
	}
	
}
