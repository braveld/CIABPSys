package com.ciabp.models;

import java.util.Date;

public class WriteQStatus extends ModelBase{

	
	private Date date;
	private String Qno;
	private String userno;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getQno() {
		return Qno;
	}
	public void setQno(String qno) {
		Qno = qno;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	
}
