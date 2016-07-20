package com.ciabp.actions.admin;

import java.util.Map;

import com.ciabp.iservices.IUserService;
import com.ciabp.models.PageVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUlistAction extends ActionSupport{
	private IUserService userService;
	private Integer page;
	private String qno;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getQno() {
		return qno;
	}

	public void setQno(String qno) {
		this.qno = qno;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public String showUlist(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null){
			page = 1;
		}	
		requestMap.put("upageVO", userService.tlistByQno(qno,page));
		requestMap.put("actionName", "showUlist");
		requestMap.put("qno", qno);
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String showUndo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null){
			page = 1;
		}	
		String sql = "";
		sql = "select * from user where no not in (select userno from writeqstatus where qno = ?) limit ?,?";
		String s = "select * from user where no not in (select userno from writeqstatus where qno = ?)";
		Object[] sparams = new Object[]{qno};
		Object[] params = new Object[]{qno,(page-1)*10,10};
		requestMap.put("upageVO", userService.tlistBySqlPage(sql, params,page,s,sparams,qno));
		requestMap.put("actionName", "showUndo");
		requestMap.put("qno", qno);
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
	public String showdo(){
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		if(page==null){
			page = 1;
		}	
		String sql = "";
		String s = "select * from user where no in (select userno from writeqstatus where qno = ?)";
		Object[] sparams = new Object[]{qno};
		sql = "select * from user where no in (select userno from writeqstatus where qno = ?) limit ?,?";
		Object[] params = new Object[]{qno,(page-1)*10,10};
		PageVO pageVO = userService.tlistBySqlPage(sql, params,page,s,sparams,qno);
		requestMap.put("upageVO", pageVO);
		requestMap.put("actionName", "showdo");
		requestMap.put("qno", qno);
		requestMap.put("page", page);
		return ActionSupport.SUCCESS;
	}
	
}
