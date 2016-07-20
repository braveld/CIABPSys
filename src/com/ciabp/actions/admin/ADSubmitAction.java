package com.ciabp.actions.admin;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IAnswerService;
import com.ciabp.iservices.IQresultService;
import com.ciabp.iservices.IWriteqstatusService;
import com.ciabp.models.Answer;
import com.ciabp.models.Qresult;
import com.ciabp.models.WriteQStatus;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ADSubmitAction extends ActionSupport{

	private IAnswerService answerService;
	private IWriteqstatusService writeqstatusService;
	private IQresultService qresultService;
	private String answer;
	private String type;
	private String questionaireno;
	private String questionno;
	private String no;
	private Integer page;
	
	
	public IQresultService getQresultService() {
		return qresultService;
	}
	public void setQresultService(IQresultService qresultService) {
		this.qresultService = qresultService;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public IAnswerService getAnswerService() {
		return answerService;
	}
	public void setAnswerService(IAnswerService answerService) {
		this.answerService = answerService;
	}
	public IWriteqstatusService getWriteqstatusService() {
		return writeqstatusService;
	}
	public void setWriteqstatusService(IWriteqstatusService writeqstatusService) {
		this.writeqstatusService = writeqstatusService;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestionaireno() {
		return questionaireno;
	}
	public void setQuestionaireno(String questionaireno) {
		this.questionaireno = questionaireno;
	}
	public String getQuestionno() {
		return questionno;
	}
	public void setQuestionno(String questionno) {
		this.questionno = questionno;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public String adsubmitwj(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		requestMap.put("qno", questionaireno);
		requestMap.put("page", page);
		String[] answers = answer.split("/");
		String[] types = type.split("/");
		String[] qnos = questionno.split("/");
		Answer uanswer = new Answer();
		uanswer.setDate(new Date());
		uanswer.setUser(no);
		uanswer.setNo(questionaireno);
		Qresult qresult = new Qresult();
		qresult.setQno(questionaireno);
		for(int i = 1;i < types.length;i++){
			uanswer.setAnswer(answers[i]);
			uanswer.setQno(qnos[i]);
			uanswer.setType(types[i]);
			if(answerService.tdoadd(uanswer)){
				if(types[i].equals("0")){
					qresultService.tadds(questionaireno, qnos[i], answers[i]);
				}
				if(types[i].equals("1")){
					String xu[] = answers[i].split("\\|");
					for(int p = 1;p < xu.length;p++){
						qresultService.tadds(questionaireno, qnos[i], xu[p]);
					}
				}				
			}else{
				return ActionSupport.ERROR;
			}
		}
		WriteQStatus writeQStatus = new WriteQStatus();
		writeQStatus.setDate(new Date());
		writeQStatus.setQno(questionaireno);
		writeQStatus.setUserno(no);
		if(!writeqstatusService.tadd(writeQStatus)){
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
}
