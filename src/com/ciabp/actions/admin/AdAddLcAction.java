package com.ciabp.actions.admin;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ciabp.iservices.ILinchuangService;
import com.ciabp.iservices.IQresultfileService;
import com.ciabp.models.Linchuang;
import com.ciabp.models.Qresultfile;
import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdAddLcAction extends ActionSupport{
	private String date;
	private Integer page;
	private String no;
	private Linchuang linchuang;
	private ILinchuangService linchuangService;
	private String lcimageFileName;
	private File lcimage;
	private Qresultfile qresultfile;
	private IQresultfileService qresultfileService;
	
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
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
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
	public String adwritelc() throws ParseException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		
			File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"lcimages/"+no);
			Map<String, Object> requestMap = (Map<String, Object>) ActionContext
					.getContext().get("request");
			requestMap.put("no", no);
			requestMap.put("page", page);
			long filename = TimeIdGenerator.generateId();
			String[] names = lcimageFileName.split("\\.");
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
				System.out.println(ServletActionContext.getServletContext().getRealPath("/")+"lcimages/"+no+"/"+filename+"."+names[1]);
				linchuang.setImageurl("lcimages/"+no+"/"+lcimageFileName);
				linchuang.setFilename(filename+"."+names[1]);
				linchuang.setType(names[1]);
			}
			if(linchuangService.tadd(linchuang)){
				return ActionSupport.SUCCESS;
			}else{
				return ActionSupport.ERROR;
			}
		
		
	}


}
