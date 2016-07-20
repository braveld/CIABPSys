package com.ciabp.actions;

import java.util.Map;

import com.ciabp.iservices.IAdminService;
import com.ciabp.iservices.IUserService;
import com.ciabp.models.Admin;
import com.ciabp.models.Role;
import com.ciabp.models.User;
import com.ciabp.utils.ServiceResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {


	private static final long serialVersionUID = -3150609910404461434L;

	private Role role;
	private IAdminService adminService;
	private IUserService userService;
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String userlogin(){
		
		Map<String, Object> sessiontMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		sessiontMap.put("addQuestion", "false");
		if(role.getRole().equals("0")){
			if(userService.tlogin(role.getNo(), role.getPassword())){
				User user = userService.tfindByNo(role.getNo());
				sessiontMap.put("name", user.getNo());
				sessiontMap.put("nick", user.getNick());
				sessiontMap.put("role",role.getRole());
				sessiontMap.put("userinfo", user);
				return ActionSupport.SUCCESS;
			}else{
				sessiontMap.put("errorinfo", "用户名或密码错误");
				return ActionSupport.ERROR;
			}
		}else{
			if(adminService.tlogin(role.getNo(), role.getPassword())){
				
				sessiontMap.put("name", role.getNo());
				sessiontMap.put("role",role.getRole());
				return ActionSupport.SUCCESS;
			}else{
				sessiontMap.put("errorinfo", "用户名或密码错误");
				return ActionSupport.ERROR;
			}
		}
	}
	
	
}
