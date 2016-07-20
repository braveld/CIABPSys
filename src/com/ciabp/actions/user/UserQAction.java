package com.ciabp.actions.user;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQDetailService;
import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.Question;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserQAction extends ActionSupport{
	
	private IQuestionaireService questionaireService;
	private IQDetailService detailService;
	
	public IQuestionaireService getQuestionaireService() {
		return questionaireService;
	}
	public void setQuestionaireService(IQuestionaireService questionaireService) {
		this.questionaireService = questionaireService;
	}
	public IQDetailService getDetailService() {
		return detailService;
	}
	public void setDetailService(IQDetailService detailService) {
		this.detailService = detailService;
	}
	public String usershowByNo(){
		
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		try {
				String no = detailService.tfindByIsopen().getNo();
				List<Question> list = questionaireService.tlistByNo(no);
				String[] nos = new String[list.size()];
				String[] types = new String[list.size()];
				for (int i = 0;i < list.size();i++) {
					nos[i] = list.get(i).getNo();
					types[i] = list.get(i).getType();
				}
				requestMap.put("UQlist", list);
				requestMap.put("nos", nos);
				requestMap.put("types", types);
				requestMap.put("Qno", no);
				return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
			requestMap.put("errorinfo", "查询时数据库发生未知异常！");
			return ActionSupport.ERROR;
		}
		
	}

}
