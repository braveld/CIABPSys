package com.ciabp.actions.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQresultService;
import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.Qresult;
import com.ciabp.models.Question;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QresultAction extends ActionSupport{

	private IQresultService qresultService;
	private IQuestionaireService questionaireService;
	private String no;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public IQresultService getQresultService() {
		return qresultService;
	}
	public void setQresultService(IQresultService qresultService) {
		this.qresultService = qresultService;
	}
	public IQuestionaireService getQuestionaireService() {
		return questionaireService;
	}
	public void setQuestionaireService(IQuestionaireService questionaireService) {
		this.questionaireService = questionaireService;
	}
	
	public String resultshow(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		List<Question> list = questionaireService.tlistByNo(no);
		List<String> questions = new ArrayList<String>();
		List<String> xuanxiangs = new ArrayList<String>();
		List<List<Qresult>> qlist = new ArrayList<List<Qresult>>();
		List<Qresult> l = null;
		Object[] params = null;
		String sql = null;
		int j = 0;
		for(int i = 0;i < list.size();i++){
			if(!list.get(i).getType().equals("2")){
				questions.add(list.get(i).getQuestion());
				xuanxiangs.add(list.get(i).getOption());
				params = new Object[]{no,list.get(i).getNo()};
				sql = "select * from qresult where qno = ? and questionno = ?";
				l = qresultService.tlistBySql(sql, params);
				qlist.add(l);
				j++;
			}	
		}
		requestMap.put("no", no);
		requestMap.put("xuanxiangs", xuanxiangs);
		requestMap.put("questions", questions);
		requestMap.put("qresultlist", qlist);
		return ActionSupport.SUCCESS;
	}
}
