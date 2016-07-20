package com.ciabp.actions.superadmin;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ciabp.iservices.IQresultfileService;
import com.ciabp.models.Qresultfile;
import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddQresultfileAction extends ActionSupport{
	private String date;
	private String qrimageFileName;
	private File qrimage;
	private Qresultfile qresultfile;
	private IQresultfileService qresultfileService;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQrimageFileName() {
		return qrimageFileName;
	}
	public void setQrimageFileName(String qrimageFileName) {
		this.qrimageFileName = qrimageFileName;
	}
	public File getQrimage() {
		return qrimage;
	}
	public void setQrimage(File qrimage) {
		this.qrimage = qrimage;
	}
	public Qresultfile getQresultfile() {
		return qresultfile;
	}
	public void setQresultfile(Qresultfile qresultfile) {
		this.qresultfile = qresultfile;
	}
	public IQresultfileService getQresultfileService() {
		return qresultfileService;
	}
	public void setQresultfileService(IQresultfileService qresultfileService) {
		this.qresultfileService = qresultfileService;
	}
	
	public String qresultfile() throws ParseException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"qrfile");
		long filename = TimeIdGenerator.generateId();
		String[] names = qrimageFileName.split("\\.");
		
		if(!file.exists() && !file .isDirectory()){
			System.out.println("//不存在");  
		    file .mkdir();
		}
		if(date.equals("") || date==null){
			qresultfile.setDate(new Date());
		} else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			String dstr=date;  
			qresultfile.setDate(sdf.parse(dstr)); 			
		}
		if(qrimageFileName!=null && !qrimageFileName.equals("")){
			qrimage.renameTo(new File(ServletActionContext.getServletContext().getRealPath("/")+"qrfile/"+filename+"."+names[1]));
			qresultfile.setUrl("qrfile/"+filename+"."+names[1]);
			qresultfile.setFilename(names[0]+"."+names[1]);
		}
		if(qresultfileService.tadd(qresultfile)){
			requestMap.put("jieguo", "success");
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
