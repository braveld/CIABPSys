package com.ciabp.actions.admin;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ciabp.iservices.IReserveService;
import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionSupport;

public class UploadResultAction extends ActionSupport{
	private IReserveService reserveService;
	private String checkreultFileName;
	private File checkreult;
	private String no;
	
	public IReserveService getReserveService() {
		return reserveService;
	}
	public void setReserveService(IReserveService reserveService) {
		this.reserveService = reserveService;
	}
	public String getCheckreultFileName() {
		return checkreultFileName;
	}
	public void setCheckreultFileName(String checkreultFileName) {
		this.checkreultFileName = checkreultFileName;
	}
	public File getCheckreult() {
		return checkreult;
	}
	public void setCheckreult(File checkreult) {
		this.checkreult = checkreult;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}

	public String uploadresult(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"resultimages/"+no);
		if(!file.exists() && !file .isDirectory()){
			System.out.println("//不存在");  
		    file .mkdir();
		}
		long filename = TimeIdGenerator.generateId();
		String[] names = checkreultFileName.split("\\.");
		String url = "";
		if(checkreultFileName!=null && !checkreultFileName.equals("")){
			checkreult.renameTo(new File(ServletActionContext.getServletContext().getRealPath("/")+"resultimages/"+no+"/"+filename+"."+names[1]));
			url = checkreultFileName;
		}
		if(reserveService.tupdateresult(url, no,filename+"."+names[1])){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}

}
