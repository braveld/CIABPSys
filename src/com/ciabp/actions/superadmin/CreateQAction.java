package com.ciabp.actions.superadmin;


import java.util.Map;


import com.ciabp.idaos.IQDetailDao;
import com.ciabp.idaos.IQuestionaireDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateQAction extends ActionSupport{
	
	private IQDetailDao qDetailDao;

	
	public IQDetailDao getqDetailDao() {
		return qDetailDao;
	}


	public void setqDetailDao(IQDetailDao qDetailDao) {
		this.qDetailDao = qDetailDao;
	}

	

	public String createQ(){
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		int count = qDetailDao.count() + 1;
		sessionMap.put("questionaireNo", String.format("QA%05d", count));
		return ActionSupport.SUCCESS;
	}

}
