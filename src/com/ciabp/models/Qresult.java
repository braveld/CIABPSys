package com.ciabp.models;

public class Qresult extends ModelBase{
	private String qno;
	private String questionno;
	private int result;
	private String xuanxiang;
	
	public String getXuanxiang() {
		return xuanxiang;
	}
	public void setXuanxiang(String xuanxiang) {
		this.xuanxiang = xuanxiang;
	}
	public String getQno() {
		return qno;
	}
	public void setQno(String qno) {
		this.qno = qno;
	}
	public String getQuestionno() {
		return questionno;
	}
	public void setQuestionno(String questionno) {
		this.questionno = questionno;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}

	

}
