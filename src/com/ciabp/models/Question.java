package com.ciabp.models;

import java.util.Date;

public class Question extends ModelBase{

	private String no;
	private String type;//0单选题，1多选题，2填空题
	private String question;
	private String answer;
	private String option;
	private Date date;
	private String isshow;
	private String tihao;
	
	
	public String getTihao() {
		return tihao;
	}
	public void setTihao(String tihao) {
		this.tihao = tihao;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
