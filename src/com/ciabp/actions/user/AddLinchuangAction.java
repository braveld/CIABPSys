package com.ciabp.actions.user;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ciabp.iservices.ILinchuangService;
import com.ciabp.models.Linchuang;
import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddLinchuangAction extends ActionSupport{
	String date;
	private Linchuang linchuang;
	private ILinchuangService linchuangService;
	private String lcimageFileName;
	private File lcimage;
	public Linchuang getLinchuang() {
		return linchuang;
	}
	public void setLinchuang(Linchuang linchuang) {
		this.linchuang = linchuang;
	}
	public ILinchuangService getLinchuangService() {
		return linchuangService;
	}
	public void setLinchuangService(ILinchuangService linchuangService) {
		this.linchuangService = linchuangService;
	}	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLcimageFileName() {
		return lcimageFileName;
	}
	public void setLcimageFileName(String lcimageFileName) {
		this.lcimageFileName = lcimageFileName;
	}
	public File getLcimage() {
		return lcimage;
	}
	public void setLcimage(File lcimage) {
		this.lcimage = lcimage;
	}
	public String writelc() throws ParseException, UnsupportedEncodingException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String no = (String)sessionMap.get("name");
		long filename = TimeIdGenerator.generateId();
		String[] names = lcimageFileName.split("\\.");
		File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"lcimages/"+no);
		if(!file.exists() && !file .isDirectory()){
			System.out.println("//不存在");  
		    file .mkdir();
		}
		if(date.equals("") || date==null){
			linchuang.setDate(new Date());
		} else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			String dstr=date;  
			linchuang.setDate(sdf.parse(dstr)); 			
		}
		linchuang.setUserno(no);
		if(lcimageFileName!=null && !lcimageFileName.equals("")){
			lcimage.renameTo(new File(ServletActionContext.getServletContext().getRealPath("/")+"lcimages/"+no+"/"+filename+"."+names[1]));
			linchuang.setImageurl("lcimages/"+no+"/"+lcimageFileName);
			linchuang.setFilename(filename+"."+names[1]);
			linchuang.setType(names[1]);
		}
		if(linchuangService.tadd(linchuang)){
			requestMap.put("jieguo", "success");
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}

}
