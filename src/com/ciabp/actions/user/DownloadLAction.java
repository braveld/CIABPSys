package com.ciabp.actions.user;

 
import java.io.InputStream;  
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class DownloadLAction { 

	private String fileName; 
	private String no;
	private InputStream inStream; 
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setFileName(String fileName) { 
		this.fileName = fileName; 
	} 
	public InputStream getInputStream() { 
		return ServletActionContext.getServletContext().getResourceAsStream("/lcimages/"+no+"/" + fileName); 
	}	
	public String getFileName() {
		return fileName;
	}
	public String downloadL(){ 
		return ActionSupport.SUCCESS; 
	} 

} 
