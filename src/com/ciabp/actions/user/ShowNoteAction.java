package com.ciabp.actions.user;

import java.util.List;
import java.util.Map;

import com.ciabp.iservices.INoteService;
import com.ciabp.models.Note;
import com.ciabp.models.QDetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowNoteAction extends ActionSupport{

	private INoteService noteService;

	public INoteService getNoteService() {
		return noteService;
	}

	public void setNoteService(INoteService noteService) {
		this.noteService = noteService;
	}
	
	public String shownote(){
		
		Map<String, Object> requestMap = (Map<String, Object>) ActionContext
				.getContext().get("request");
		Map<String, Object> sessiontMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		try {
				String no = (String)sessiontMap.get("name");
				List<Note> list = noteService.tlistByNo(no);
				requestMap.put("notelist", list);
				return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
			requestMap.put("errorinfo", "查询时数据库发生未知异常！");
			return ActionSupport.ERROR;
		}
		
	}
}
