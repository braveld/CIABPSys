package com.ciabp.actions.admin;

import java.util.Date;
import java.util.Map;



import com.ciabp.iservices.IAnswerService;
import com.ciabp.iservices.IQresultService;
import com.ciabp.iservices.IWriteqstatusService;
import com.ciabp.models.Answer;
import com.ciabp.models.WriteQStatus;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class UpdateAnswer extends ActionSupport{
	private IAnswerService answerService;
	private String answer;
	private String type;
	private String no;
	private String questionaireno;
	private String questionno;
	private IQresultService qresultService;
	
	
	public IQresultService getQresultService() {
		return qresultService;
	}
	public void setQresultService(IQresultService qresultService) {
		this.qresultService = qresultService;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public IAnswerService getAnswerService() {
		return answerService;
	}
	public void setAnswerService(IAnswerService answerService) {
		this.answerService = answerService;
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
	public String updateanswer(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		requestMap.put("no", no);
		requestMap.put("qno", questionaireno);
		String[] answers = answer.split("/");
		String[] types = type.split("/");
		String[] qnos = questionno.split("/");
		Answer uanswer = new Answer();
		uanswer.setDate(new Date());
		uanswer.setUser(no);
		uanswer.setNo(questionaireno);
		java.util.List<Answer> l = answerService.tlistByUser(questionaireno, no);
		if(l!=null){
			for(int p = 0;p < l.size();p++){
				if(l.get(p).getType().equals("0")){
					qresultService.tminus(questionaireno, l.get(p).getQno(), l.get(p).getAnswer());
				}
				if(l.get(p).getType().equals("1")){
					String[] xuanxiangs = l.get(p).getAnswer().split("\\|");
					for(int r = 1;r < xuanxiangs.length;r++){
						qresultService.tminus(questionaireno, l.get(p).getQno(), xuanxiangs[r]);
					}
				}
			}
		}
		if(answerService.tdeleteByNo(no, questionaireno)){
			for(int i = 1;i < types.length;i++){
				uanswer.setAnswer(answers[i]);
				uanswer.setQno(qnos[i]);
				uanswer.setType(types[i]);
				if(!answerService.tdoadd(uanswer)){
					sessionMap.put("errorinfo", "答案修改失败");
					return ActionSupport.ERROR;
				}
				if(types[i].equals("0")){
					qresultService.tadds(questionaireno, qnos[i], answers[i].trim());
				}
				if(types[i].equals("1")){
					String xu[] = answers[i].split("\\|");
					for(int p = 1;p < xu.length;p++){
						qresultService.tadds(questionaireno, qnos[i], xu[p].trim());
					}
				}
				
			}
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
		
	}
}
