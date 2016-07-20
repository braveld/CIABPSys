package com.ciabp.actions.admin;


import java.io.File;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;



import org.apache.struts2.ServletActionContext;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.ciabp.iservices.ISnoteService;
import com.ciabp.models.Dnote;
import com.ciabp.models.Snote;
import com.ciabp.utils.MailSenderInfo;
import com.ciabp.utils.SimpleMailSender;
import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddSnoteAction extends ActionSupport{
	private ISnoteService snoteService;
	private Snote snote;
	private String content;
	private String page;
	private String no;
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

	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ISnoteService getSnoteService() {
		return snoteService;
	}
	public void setSnoteService(ISnoteService snoteService) {
		this.snoteService = snoteService;
	}
	public Snote getSnote() {
		return snote;
	}
	public void setSnote(Snote snote) {
		this.snote = snote;
	}
	
	public String addSnote(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String no = (String)sessionMap.get("name");
		long id = TimeIdGenerator.generateId();
		snote.setNo(no);
		if(snoteService.tdoaddNote(snote)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	public String showslist(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null || "".equals(page)){
			page = "1";
		}
		Integer p = Integer.parseInt(page);
		requestMap.put("upageVO",snoteService.tlistAllByPage(p));
		requestMap.put("actionName", "showslist");
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String showsByNo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Snote snote = snoteService.tfindByNo(no);
		requestMap.put("snote", snote);
		return ActionSupport.SUCCESS;
	}
	
	public String deleteS(){
		if(snoteService.tdosdelete(no)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	
	public String sendemail(){
		// 设置邮件服务器信息
		  MailSenderInfo mailInfo = new MailSenderInfo();
		  mailInfo.setMailServerHost("smtp.163.com");
		  mailInfo.setMailServerPort("25");
		  mailInfo.setValidate(true);
		  
		  // 邮箱用户名
		  mailInfo.setUserName("13934601833@163.com");
		  // 邮箱密码
		  mailInfo.setPassword("love199188can");
		  // 发件人邮箱
		  mailInfo.setFromAddress("13934601833@163.com");
		  // 收件人邮箱
		  mailInfo.setToAddress(email);
		  // 邮件标题
		  mailInfo.setSubject("白塞人公邮");
		  // 邮件内容
		  StringBuffer buffer = new StringBuffer();
		  buffer.append(content);
		  
		  mailInfo.setContent(buffer.toString());
		  
		  // 发送邮件
		  SimpleMailSender sms = new SimpleMailSender();
		  // 发送文体格式
		  sms.sendTextMail(mailInfo);
		  // 发送html格式
		  SimpleMailSender.sendHtmlMail(mailInfo);
		  System.out.println("邮件发送完毕");
		  return ActionSupport.SUCCESS;
		 }
	

}

