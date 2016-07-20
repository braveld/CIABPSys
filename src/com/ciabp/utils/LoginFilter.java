package com.ciabp.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		  // 获得在下面代码中要用的request,response,session对象
		         HttpServletRequest servletRequest = (HttpServletRequest) request;
		         HttpServletResponse servletResponse = (HttpServletResponse) response;
		         HttpSession session = servletRequest.getSession();
		 
		         // 获得用户请求的URI
		         String path = servletRequest.getRequestURI();
		         
		         String name = (String)session.getAttribute("name");
		         
		         if(path.contains("/login.jsp") || path.contains("/registernotice.jsp") || path.contains("/register.jsp") || path.contains("/loginBg")){
		        	 chain.doFilter(servletRequest, servletResponse);
		         }else{
		        	 
			         if(name == null || "".equals(name)){
			        	 servletResponse.sendRedirect(servletRequest.getContextPath()+"/backstage/login.jsp");
			        	
			         }else{
			        	 chain.doFilter(servletRequest, servletResponse);
			         }
		         }
		         
		         
		         
		         
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
