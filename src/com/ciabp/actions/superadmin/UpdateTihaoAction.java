package com.ciabp.actions.superadmin;

import java.util.Map;

import com.ciabp.iservices.IQuestionaireService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateTihaoAction extends ActionSupport{
	private IQuestionaireService questionaireService;
	private String noss;
	private String tihaos;
	private String no;
	
	public String getNoss() {
		return noss;
	}
	public void setNoss(String noss) {
		this.noss = noss;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public IQuestionaireService getQuestionaireService() {
		return questionaireService;
	}
	public void setQuestionaireService(IQuestionaireService questionaireService) {
		this.questionaireService = questionaireService;
	}
	public String getTihaos() {
		return tihaos;
	}
	public void setTihaos(String tihaos) {
		this.tihaos = tihaos;
	}
	public String updatetihao(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		requestMap.put("qno", no);
		if(tihaos != null && !tihaos.equals("")){
			String[] tihaoss = tihaos.split("/");
			String[] nos = noss.split("/");
			if(!questionaireService.tupdatetihao(no, nos, tihaoss)){
				return ActionSupport.ERROR;
			}
		}else{
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}


}
