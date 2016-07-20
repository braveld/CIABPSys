package com.ciabp.models;

import java.util.Date;

public class QDetail extends ModelBase{
	
	private String no;
	private String isopen;
	private String name;
	private Date date;
	private String isqiyong;
	
	public String getIsqiyong() {
		return isqiyong;
	}
	public void setIsqiyong(String isqiyong) {
		this.isqiyong = isqiyong;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getIsopen() {
		return isopen;
	}
	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
