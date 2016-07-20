package com.ciabp.actions.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.ciabp.iservices.IUserService;
import com.ciabp.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserRegisterAction extends ActionSupport{
	
	private User user;
	private String date;
	private String sex;
	
	
	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	private IUserService userService;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public IUserService getUserService() {
		return userService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	
	public String register(){
		Map<String, Object> sessiontMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(!"".equals(user.getMphone())){
			User userValid=userService.tfindByNo(user.getMphone());
			if(userValid!=null){
				sessiontMap.put("errorinfo", user.getMphone()+"用户已注册");
				return ActionSupport.ERROR;
			}
		}
		if(!"".equals(user.getNick())){
			User userValid=userService.tfindByNo(user.getNick());
			if(userValid!=null){
				sessiontMap.put("errorinfo", user.getNick()+"用户已注册");
				return ActionSupport.ERROR;
			}
		}
		if(date.equals("") || date==null){
			sessiontMap.put("errorinfo", "生日不能为空");
			return ActionSupport.ERROR;
		} else{
			user.setBirthday(date);			
		}
		user.setSex(sex);
		
		if(user.getPassword().equals("") || user.getMphone().equals("") || user.getName().equals("") || user.getNick().equals("") || user.getConfirm().equals("") || user.getBirthday().equals("") || user.getSex().equals("") || user.getType().equals("") || user.getWork().equals("") || user.getQq().equals("")){
			sessiontMap.put("errorinfo", "注册信息不能为空");
			return ActionSupport.ERROR;
		}
		
		if(userService.tdoaddUser(user)){
			
			requestMap.put("userno", user.getMphone());
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	
	public String register1(){
		Map<String, Object> sessiontMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");		
		if(user.getNick().equals("")){
			sessiontMap.put("errorinfo", "用户名不能为空");
			return ActionSupport.ERROR;
		}
		if(date.equals("") || date==null){
			sessiontMap.put("errorinfo", "生日不能为空");
			return ActionSupport.ERROR;
		} else{
			user.setBirthday(date);			
		}
		user.setSex(sex);
		user.setPassword("000000");
		user.setConfirm("000000");
		if(userService.tdoaddUser(user)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}

}
