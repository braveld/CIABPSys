package com.ciabp.actions.superadmin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQuestionService;
import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.QDetail;
import com.ciabp.models.Question;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowQByNoAction extends ActionSupport{
	
	private IQuestionaireService questionaireService;
	private IQuestionService questionService;
	private String no;
	
	public IQuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
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
	
	public String showByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		try {
			
				List<Question> list = questionaireService.tlistByNo(no);
				List<Question> l = questionService.tlistNOW(no);
				String[] nos = new String[list.size()];
				for(int i = 0;i < list.size();i++){
					nos[i] = list.get(i).getNo();
				}
				requestMap.put("nos", nos);
				requestMap.put("Qqlist", list);
				requestMap.put("nQqlist", l);
				requestMap.put("qno", no);
				return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
			requestMap.put("errorinfo", "查询时数据库发生未知异常！");
			return ActionSupport.ERROR;
		}
		
	}

}
