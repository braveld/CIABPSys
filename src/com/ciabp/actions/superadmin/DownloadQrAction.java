package com.ciabp.actions.superadmin;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadQrAction extends ActionSupport{

	private String fileName; 
	
	private String real;
	
	private String name;
	
	private InputStream inStream; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReal() {
		return real;
	}
	public void setReal(String real) throws UnsupportedEncodingException {
		this.real = new String(real.getBytes("ISO-8859-1"),"UTF-8"); 
	}
	public void setFileName(String fileName) throws UnsupportedEncodingException { 
		this.fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8"); 
	} 
	public InputStream getInputStream() { 
		return ServletActionContext.getServletContext().getResourceAsStream("/" + fileName); 
	}	
	public String getFileName() {
		return fileName;
	}
	public String downloadQr(){ 
		setName(fileName.split("/")[1]);
		return ActionSupport.SUCCESS; 
	} 
}
