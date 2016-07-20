package com.ciabp.actions.user;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IDnoteService;
import com.ciabp.models.PageVO;
import com.ciabp.models.Dnote;
import com.ciabp.models.Tnote;
import com.ciabp.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserShowDnoteAction extends ActionSupport{
	private IDnoteService dnoteService;
	private String page;
	private String no;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public IDnoteService getDnoteService() {
		return dnoteService;
	}
	public void setDnoteService(IDnoteService dnoteService) {
		this.dnoteService = dnoteService;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	public String adshowdnote(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String nick = (String)sessionMap.get("nick");
		if(page == null || page.equals("")){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		PageVO pageVO = dnoteService.tlistAllByPage1(p,nick);
		System.out.println(pageVO.getList());
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "adshowdnote");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String showByDno(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Dnote dnote = dnoteService.tfindByNo(no);
		System.out.println(dnote.getNo());
		System.out.println(dnote.getContent());
		requestMap.put("dnote", dnote);
		return ActionSupport.SUCCESS;
	}
	
}
