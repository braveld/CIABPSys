package com.ciabp.actions.admin;


import java.io.File;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.ciabp.iservices.IDnoteService;
import com.ciabp.models.Dnote;
import com.ciabp.models.PageVO;
import com.ciabp.models.Tnote;
import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddDnoteAction extends ActionSupport{
	private IDnoteService dnoteService;
	private Dnote dnote;
	private String nick;
	private String no;
	private String page;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public IDnoteService getDnoteService() {
		return dnoteService;
	}
	public void setDnoteService(IDnoteService dnoteService) {
		this.dnoteService = dnoteService;
	}
	public Dnote getDnote() {
		return dnote;
	}
	public void setDnote(Dnote dnote) {
		this.dnote = dnote;
	}
	public String addDnote(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String no = (String)sessionMap.get("name");
		dnote.setNo(no);
		dnote.setNick(nick);
		dnote.setName(name);
		if(dnoteService.tdoaddNote(dnote)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	
	public String showdByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Dnote dnote = dnoteService.tfindByNo(no);
		requestMap.put("dnote", dnote);
		return ActionSupport.SUCCESS;
	}
	
	public String showdanlist(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		PageVO pageVO = dnoteService.tlistAllByPage(p);
		requestMap.put("upageVO",pageVO);
		requestMap.put("actionName", "showdanlist");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
		
	}
	
	public String deleteDan(){
		if(dnoteService.tdoddelete(no)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
