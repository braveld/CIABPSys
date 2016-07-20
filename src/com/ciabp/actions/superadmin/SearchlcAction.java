package com.ciabp.actions.superadmin;

import java.util.Map;

import com.ciabp.iservices.IDnoteService;
import com.ciabp.iservices.IUserService;
import com.ciabp.iservices.ITnoteService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchlcAction extends ActionSupport{
	private String xuan;
	private String xuanxiang;
	private IUserService userService;
	private ITnoteService tnoteService;
	private IDnoteService dnoteService;
	private String qno;
	
	public String getQno() {
		return qno;
	}
	public void setQno(String qno) {
		this.qno = qno;
	}
	public IDnoteService getDnoteService() {
		return dnoteService;
	}
	public void setDnoteService(IDnoteService dnoteService) {
		this.dnoteService = dnoteService;
	}
	public ITnoteService getTnoteService() {
		return tnoteService;
	}
	public void setTnoteService(ITnoteService tnoteService) {
		this.tnoteService = tnoteService;
	}
	public String getXuan() {
		return xuan;
	}
	public void setXuan(String xuan) {
		this.xuan = xuan;
	}
	public String getXuanxiang() {
		return xuanxiang;
	}
	public void setXuanxiang(String xuanxiang) {
		this.xuanxiang = xuanxiang;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String searchlcbyuser(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("用户名")){
			sql = "select * from user where nick = ?";
		}else if(xuan.equals("真实姓名")){
			sql = "select * from user where name = ?";
		}else if(xuan.equals("手机号")){
			sql = "select * from user where mphone = ?";
		}else if(xuan.equals("QQ号")){
			sql = "select * from user where qq = ?";
		}
		requestMap.put("upageVO", userService.tlistBySql(sql, params));
		requestMap.put("actionName", "searchlc");
		return ActionSupport.SUCCESS;
	}
	public String searchlcbyuser1(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("用户名")){
			sql = "select * from user where nick = ?";
		}else if(xuan.equals("真实姓名")){
			sql = "select * from user where name = ?";
		}
		requestMap.put("upageVO", userService.tlistBySql(sql, params));
		requestMap.put("actionName", "showau1");
		return ActionSupport.SUCCESS;
	}
	public String searchbyuser(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("用户名")){
			sql = "select * from user where nick = ?";
		}else if(xuan.equals("真实姓名")){
			sql = "select * from user where name = ?";
		}
		requestMap.put("upageVO", userService.tlistBySql(sql, params));
		requestMap.put("actionName", "showau2");
		return ActionSupport.SUCCESS;
	}
	
	public String searchmailbyuser(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("用户名")){
			sql = "select * from user where nick = ?";
		}else if(xuan.equals("真实姓名")){
			sql = "select * from user where name = ?";
		}
		requestMap.put("upageVO", userService.tlistBySql(sql, params));
		requestMap.put("actionName", "showau3");
		return ActionSupport.SUCCESS;
	}
	
	public String searchlcbyuser2(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("用户名")){
			sql = "select * from tuijiannote where nick = ?";
		}else if(xuan.equals("主题")){
			sql = "select * from tuijiannote where title = ?";
		}
		else if(xuan.equals("姓名")){
			sql = "select * from tuijiannote where name = ?";
		}
		requestMap.put("upageVO", tnoteService.tlistBySql(sql, params));
		requestMap.put("actionName", "showat");
		return ActionSupport.SUCCESS;
	}
	
	public String searchdanbytitle(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("主题")){
			sql = "select * from dannote where title = ?";
		}else if(xuan.equals("用户名")){
			sql = "select * from dannote where nick = ?";
		}
		else if(xuan.equals("姓名")){
			sql = "select * from dannote where name = ?";
		}
		requestMap.put("upageVO", dnoteService.dlistBySql(sql, params));
		requestMap.put("actionName", "showdanlist");
		return ActionSupport.SUCCESS;
	}
	public String searchforuli(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("用户名")){
			sql = "select * from user where nick = ?";
		}else if(xuan.equals("真实姓名")){
			sql = "select * from user where name = ?";
		}else if(xuan.equals("手机号")){
			sql = "select * from user where mphone = ?";
		}else if(xuan.equals("QQ号")){
			sql = "select * from user where qq = ?";
		}
		requestMap.put("upageVO", userService.tlistBySql(sql, params));
		requestMap.put("actionName", "searchlc");
		return ActionSupport.SUCCESS;
	}
	public String searchforsalu(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("用户名")){
			sql = "select * from user where nick = ?";
		}else if(xuan.equals("真实姓名")){
			sql = "select * from user where name = ?";
		}else if(xuan.equals("手机号")){
			sql = "select * from user where mphone = ?";
		}else if(xuan.equals("QQ号")){
			sql = "select * from user where qq = ?";
		}
		requestMap.put("upageVO", userService.tlistBySql(sql, params));
		requestMap.put("actionName", "searchlc");
		return ActionSupport.SUCCESS;
	}
	public String searchforsul(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("用户名")){
			sql = "select * from user where nick = ?";
			requestMap.put("upageVO", userService.tlistBySqlQ(sql, params,qno));
			requestMap.put("actionName", "searchlc");
		}else if(xuan.equals("真实姓名")){
			sql = "select * from user where name = ?";
			requestMap.put("upageVO", userService.tlistBySqlQ(sql, params,qno));
			requestMap.put("actionName", "searchlc");
		}else if(xuan.equals("手机号")){
			sql = "select * from user where mphone = ?";
			requestMap.put("upageVO", userService.tlistBySqlQ(sql, params,qno));
			requestMap.put("actionName", "searchlc");
		}else if(xuan.equals("QQ号")){
			sql = "select * from user where qq = ?";
			requestMap.put("upageVO", userService.tlistBySqlQ(sql, params,qno));
			requestMap.put("actionName", "searchlc");
		}else if(xuan.equals("未填")){
			sql = "select * from user where no not in (select userno from writeqstatus where qno = ?) limit ?,?";
			params = new Object[]{qno,0,9};
			String s = "select * from user where no not in (select userno from writeqstatus where qno = ?)";
			Object[] sparams = new Object[]{qno};
			requestMap.put("upageVO", userService.tlistBySqlPage(sql, params,1,s,sparams,qno));
			requestMap.put("actionName", "showUndo");
			requestMap.put("qno", qno);
			requestMap.put("page", 1);
		}else if(xuan.equals("已填")){
			sql = "select * from user where no in (select userno from writeqstatus where qno = ?) limit ?,?";
			params = new Object[]{qno,0,9};
			String s = "select * from user where no in (select userno from writeqstatus where qno = ?)";
			Object[] sparams = new Object[]{qno};
			requestMap.put("upageVO", userService.tlistBySqlPage(sql, params,1,s,sparams,qno));
			requestMap.put("actionName", "showdo");
			requestMap.put("qno", qno);
			requestMap.put("page", 1);
		}
		
		return ActionSupport.SUCCESS;
	}
	public String searchforssau(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		String sql = null;
		Object[] params = {xuanxiang};
		if(xuan.equals("用户名")){
			sql = "select * from user where nick = ?";
		}else if(xuan.equals("真实姓名")){
			sql = "select * from user where name = ?";
		}else if(xuan.equals("手机号")){
			sql = "select * from user where mphone = ?";
		}else if(xuan.equals("QQ号")){
			sql = "select * from user where qq = ?";
		}
		requestMap.put("upageVO", userService.tlistBySql(sql, params));
		requestMap.put("actionName", "searchlc");
		return ActionSupport.SUCCESS;
	}
	
}
