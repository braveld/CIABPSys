package com.ciabp.actions.admin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQuestionService;
import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.Question;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUQAction extends ActionSupport{
	private IQuestionService questionService;
	private IQuestionaireService questionaireService;
	private String qno;
	private String no;
	
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
	public String getQno() {
		return qno;
	}
	public void setQno(String qno) {
		this.qno = qno;
	}
	public IQuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	
	public String showUQ(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");		
		List<Question> list = questionService.tlistWithA(qno, no);
		List<Question> l = questionaireService.tlistByNo(qno);
		for(int p = 0;p < l.size();p++){
			for(int q = 0;q < list.size();q++){
				if(list.get(q).getNo().equals(l.get(p).getNo())){
					l.get(p).setAnswer(list.get(q).getAnswer());
				}
			}
		}
		requestMap.put("UQustionList", l);
		requestMap.put("no", no);
		String[] nos = new String[list.size()];
		String[] types = new String[list.size()];
		for (int i = 0;i < list.size();i++) {
			nos[i] = list.get(i).getNo();
			types[i] = list.get(i).getType();
		}
		requestMap.put("nos", nos);
		requestMap.put("types", types);
		requestMap.put("Qno", qno);
		return ActionSupport.SUCCESS;
	}

}
