package com.ciabp.utils;

public class ServiceResult {
	
	public static int SUCCESS = 0;
	public static int ERROR = 1;
	public static int LOGIN = 2;
	public static int EXCEPTION = 3;
	
	private int code;
	private String info;
	private Object response;

	public void setInfo(String info) {
		this.info = info;
	}
	public String getInfo() {
		return info;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public Object getResponse() {
		return response;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}		
}