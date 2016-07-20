package com.ciabp.actions.superadmin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQDetailService;
import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.QDetail;
import com.ciabp.models.Question;
import com.ciabp.models.Questionaire;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowQAction extends ActionSupport{
	
	private IQDetailService detailService;
	public IQDetailService getDetailService() {
		return detailService;
	}
	public void setDetailService(IQDetailService detailService) {
		this.detailService = detailService;
	}

	public String showQ(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		try {
				List<QDetail> list = detailService.tlistAll();
				sessionMap.put("detaillist", list);
				return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
			sessionMap.put("errorinfo", "查询时数据库发生未知异常！");
			return ActionSupport.ERROR;
		}
		
	}

}
