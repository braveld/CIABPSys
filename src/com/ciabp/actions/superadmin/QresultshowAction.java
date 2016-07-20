package com.ciabp.actions.superadmin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;



public class QresultshowAction {
	private String qno;
	private String[] data;
	public String getQno() {
		return qno;
	}
	public void setQno(String qno) {
		this.qno = qno;
	}
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}
	public void sresultshow(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
	    try {
	    	for(int i=0;i < data.length;i++){
	    		File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"images/"+qno+".png");
		    	if(file.exists()){
		    		file.delete();
		    	}
		        String u = data[i];
		        
		        // Base64解码
		        byte[] b = new BASE64Decoder().decodeBuffer(u);
		        // 生成图片
		        OutputStream out = new FileOutputStream(file);
		        out.write(b);
		        out.flush();
		        out.close();
	    	}
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}
}
