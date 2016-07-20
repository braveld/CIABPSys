package com.ciabp.actions.superadmin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IAdminService;
import com.ciabp.models.PageVO;
import com.ciabp.models.Admin;
import com.ciabp.models.Tnote;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAllAdminAction extends ActionSupport{
	private IAdminService adminService;
	private String page;
	private String no;
	private Admin admin;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public IAdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public String showadmin(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page == null || page.equals("")){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		PageVO pageVO = adminService.tlistAllByPage(p);
		System.out.println(pageVO.getList());
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "showadmin");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String deleteAdmin(){
		if(adminService.tdousdelete(no)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	
	public String showaByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Admin admin = adminService.tfindByNo(no);
		requestMap.put("admin", admin);
		return ActionSupport.SUCCESS;
	}
	
	public String upateAdmin(){
		if(adminService.tdoaupdate(admin.getPassword(),no)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
