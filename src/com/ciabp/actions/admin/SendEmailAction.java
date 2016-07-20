package com.ciabp.actions.admin;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendEmailAction extends ActionSupport{
	protected JavaMailSenderImpl mailSender;
	private String email;
	private String content;
	private String subject;
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

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

	public JavaMailSenderImpl getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	} 
	
	public String sendMail() throws Exception {  
		  
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
					.getContext().get("session");
		     //build message  
		     SimpleMailMessage mailMessage = new SimpleMailMessage();   
		     mailMessage.setTo(email);  
		     mailMessage.setFrom("13381331390@163.com");  
		     mailMessage.setSubject(new String(subject.getBytes("UTF-8")));   
		     mailMessage.setText(new String(content.getBytes("UTF-8")));  
		  
		     //send mail  
		  
		     try{
		    	 mailSender.send(mailMessage);  
		     }catch(Exception e){
		    	 sessionMap.put("errorinfo", "无此邮箱");
		    	 return ActionSupport.ERROR;
		     }
		     
		     return ActionSupport.SUCCESS;
	}
}
