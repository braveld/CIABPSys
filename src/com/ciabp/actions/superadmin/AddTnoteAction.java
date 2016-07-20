package com.ciabp.actions.superadmin;

import java.io.File;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.ciabp.iservices.ITnoteService;
import com.ciabp.models.Tnote;
import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class AddTnoteAction extends ActionSupport{
	private ITnoteService tnoteService;
	private Tnote tnote;
	private String nick;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public ITnoteService getTnoteService() {
		return tnoteService;
	}
	public void setTnoteService(ITnoteService tnoteService) {
		this.tnoteService = tnoteService;
	}
	public Tnote getTnote() {
		return tnote;
	}
	public void setTnote(Tnote tnote) {
		this.tnote = tnote;
	}
	
	public String addTnote(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String no = (String)sessionMap.get("name");
		tnote.setNo(no);
		tnote.setNick(nick);
		tnote.setName(name);
		if(tnoteService.tdoaddNote(tnote)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	

}
