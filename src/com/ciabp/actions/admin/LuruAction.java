package com.ciabp.actions.admin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.Question;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LuruAction extends ActionSupport{
	private String qno;
	private IQuestionaireService questionaireService;
	private String no;
	private Integer page;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getQno() {
		return qno;
	}
	public void setQno(String qno) {
		this.qno = qno;
	}
	public IQuestionaireService getQuestionaireService() {
		return questionaireService;
	}
	public void setQuestionaireService(IQuestionaireService questionaireService) {
		this.questionaireService = questionaireService;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public String luruabc(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");		
		List<Question> list = questionaireService.tlistByNo(qno);
		String[] nos = new String[list.size()];
		String[] types = new String[list.size()];
		for (int i = 0;i < list.size();i++) {
			nos[i] = list.get(i).getNo();
			types[i] = list.get(i).getType();
		}
		requestMap.put("UQlist", list);
		requestMap.put("nos", nos);
		requestMap.put("types", types);
		requestMap.put("Qno", qno);
		requestMap.put("no", no);
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;					 	
	}
}
