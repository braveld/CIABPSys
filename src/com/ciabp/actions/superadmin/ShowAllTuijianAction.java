package com.ciabp.actions.superadmin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import com.ciabp.models.Tnote;
import com.ciabp.models.User;
import com.ciabp.iservices.ITnoteService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAllTuijianAction extends ActionSupport{
	private ITnoteService tnoteService;
	private String page;
	private String no;
	private Tnote tnote;
	
	public Tnote getTnote() {
		return tnote;
	}
	public void setTnote(Tnote tnote) {
		this.tnote = tnote;
	}
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
	
	public String showat(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO",tnoteService.tlistAllByPage(p));
		requestMap.put("actionName", "showat");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String deleteTuijian(){
		if(tnoteService.tdotdelete(no)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	
	public String showtByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Tnote tnote = tnoteService.tfindByNo(no);
		requestMap.put("tnote", tnote);
		return ActionSupport.SUCCESS;
	}
	
	public String tupdate(){
		if(tnoteService.tdotupdate(tnote.getNick(), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), tnote.getContent(), no, tnote.getTitle())){
			
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
