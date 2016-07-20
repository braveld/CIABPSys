package com.ciabp.actions.superadmin;

import java.util.Map;
import com.ciabp.models.Admin;
import com.ciabp.idaos.IAdminDao;
import com.ciabp.iservices.IAdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Random;



public class AddAdminAction extends ActionSupport{

	private static final long serialVersionUID = 3152709707046086282L;
	private IAdminService adminService;
	private IAdminDao adminDao;
	
	public IAdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public IAdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	 public static String getRandomString(int length) { 
		 StringBuffer buffer = new StringBuffer("0123456789"); 
		 StringBuffer sb = new StringBuffer(); 
		 Random r = new Random(); 
		 int range = buffer.length(); 
		 for (int i = 0; i < length; i ++) { 
		sb.append(buffer.charAt(r.nextInt(range)));
		}
		 return sb.toString(); 
		}
	 
	public String register(){
		Map<String, Object> sessiontMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");

		
		
		int count = adminDao.count()+1;
		String no = String.format("AD%05d",count);
		String password = "000000";
		requestMap.put("no", no);
		requestMap.put("password", password);
		if(adminService.tdoAddAdmin(no, password)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	

	}
	

	

}
