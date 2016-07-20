package com.ciabp.actions.admin;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.IAnswerService;
import com.ciabp.iservices.IQresultService;
import com.ciabp.iservices.IUserService;
import com.ciabp.iservices.IWriteqstatusService;
import com.ciabp.models.Answer;
import com.ciabp.models.PageVO;
import com.ciabp.models.User;
import com.ciabp.models.WriteQStatus;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminShowUsersAction extends ActionSupport{
	
	private IUserService userService;
	private IAnswerService answerService;
	private IQresultService qresultService;
	private IWriteqstatusService writeqstatusService;
	private String page;
	private String no;
	
	public IAnswerService getAnswerService() {
		return answerService;
	}

	public void setAnswerService(IAnswerService answerService) {
		this.answerService = answerService;
	}

	public IQresultService getQresultService() {
		return qresultService;
	}

	public void setQresultService(IQresultService qresultService) {
		this.qresultService = qresultService;
	}

	public IWriteqstatusService getWriteqstatusService() {
		return writeqstatusService;
	}

	public void setWriteqstatusService(IWriteqstatusService writeqstatusService) {
		this.writeqstatusService = writeqstatusService;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public String adshowusers(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page == null || page.equals("")){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		PageVO pageVO = userService.tlistAllByPage(p);
		System.out.println(pageVO.getList());
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "adshowusers");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	public String showau2(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO",userService.tlistAllByPage(p));
		requestMap.put("actionName", "showau2");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String showau3(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO",userService.tlistAllByPage(p));
		requestMap.put("actionName", "showau3");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String showByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		User user = userService.tfindByNo1(no);
		requestMap.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	public String deleteUser(){
		if(userService.tdoudelete(no)){
			List<WriteQStatus> l = writeqstatusService.tlistByUser(no);
			if(l!=null && !l.isEmpty()){
				for(int i = 0;i < l.size();i++){
					List<Answer> list = answerService.tlistByUser(l.get(i).getQno(), no);
					if(list!=null){
						for(int p = 0;p < list.size();p++){
							if(list.get(p).getType().equals("0")){
								qresultService.tminus(list.get(p).getNo(), list.get(p).getQno(), list.get(p).getAnswer());
							}
							if(list.get(p).getType().equals("1")){
								String[] xuanxiangs = list.get(p).getAnswer().split("\\|");
								for(int r = 1;r < xuanxiangs.length;r++){
									qresultService.tminus(list.get(p).getNo(), list.get(p).getQno(), xuanxiangs[r]);
								}
							}
						}
					}
				}
				if(!answerService.tdeleteByUser(no) || !writeqstatusService.tdeleteByUser(no)){
					return ActionSupport.ERROR;
				}
			}
			
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	
	public String uupdateUser(){
		if(userService.tdouupdate(no, user.getMphone(), user.getNick(), user.getName(), user.getSex(), user.getType(), user.getBirthday(), user.getEducation()+"", user.getWork(), user.getEmail(), user.getQq(), user.getWeixin(), user.getPhone(), user.getAddress())){
			
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	
}
