package com.ciabp.actions.user;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.ITnoteService;
import com.ciabp.models.PageVO;
import com.ciabp.models.Snote;
import com.ciabp.models.Tnote;
import com.ciabp.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserShowTnoteAction extends ActionSupport{
	
	private ITnoteService tnoteService;
	private String page;
	public ITnoteService getTnoteService() {
		return tnoteService;
	}
	public void setTnoteService(ITnoteService tnoteService) {
		this.tnoteService = tnoteService;
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
	private String no;
	
	public String adshowtnote(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String nick = (String)sessionMap.get("nick");
		if(page == null || page.equals("")){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		PageVO pageVO = tnoteService.tlistAllByPage1(p,nick);
		System.out.println(pageVO.getList());
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "adshowtnote");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String showByTno(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Tnote tnote = tnoteService.tfindByNo(no);
		System.out.println(tnote.getNo());
		System.out.println(tnote.getContent());
		requestMap.put("tnote", tnote);
		return ActionSupport.SUCCESS;
	}
}
