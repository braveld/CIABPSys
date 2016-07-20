package com.ciabp.models;

public class Admin extends ModelBase{
	private String no;
	private String password;
	private String role;
	private String name;
	
	public String getNo() {
		return no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	
}
