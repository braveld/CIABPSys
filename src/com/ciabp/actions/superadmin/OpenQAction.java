package com.ciabp.actions.superadmin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IQDetailService;
import com.ciabp.iservices.IQresultService;
import com.ciabp.iservices.IQuestionService;
import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.QDetail;
import com.ciabp.models.Qresult;
import com.ciabp.models.Question;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OpenQAction extends ActionSupport{
	private IQresultService qresultService;
	private IQDetailService detailService;
	private IQuestionaireService questionaireService;
	private String openno;
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IQuestionaireService getQuestionaireService() {
		return questionaireService;
	}
	public void setQuestionaireService(IQuestionaireService questionaireService) {
		this.questionaireService = questionaireService;
	}
	public IQresultService getQresultService() {
		return qresultService;
	}
	public void setQresultService(IQresultService qresultService) {
		this.qresultService = qresultService;
	}
	public IQDetailService getDetailService() {
		return detailService;
	}
	public void setDetailService(IQDetailService detailService) {
		this.detailService = detailService;
	}

	public String getOpenno() {
		return openno;
	}
	public void setOpenno(String openno) {
		this.openno = openno;
	}
	public String qiyong(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		if(detailService.tdoupdateIsopen(openno)){
			List<QDetail> list = detailService.tlistAll();
			sessionMap.put("detaillist", list);
			String sql = "select * from qresult where qno = ?";
			Object[] params = new Object[]{openno};
			Qresult qresult = new Qresult();
			qresult.setQno(openno);
			if(qresultService.tlistBySql(sql, params)==null){
				List<Question> l = questionaireService.tlistByNo(openno);
				for(int p = 0;p < l.size();p++){
					if(!l.get(p).getType().equals("2")){
						String[] xu = l.get(p).getOption().split("/");
						for(int q = 0;q < xu.length;q++){
							qresult.setQuestionno(l.get(p).getNo());
							qresult.setXuanxiang(xu[q]);
							qresult.setResult(0);
							qresultService.tadd(qresult);
						}
					}				
				}
			}
			if(detailService.tupdateQY(openno)){
				return ActionSupport.SUCCESS;
			}else{
				return ActionSupport.ERROR;
			}
			
		}else{
			return ActionSupport.ERROR;
		}
	}
	
	public String updateQno(){
		if(detailService.tupdatename(name,openno)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
