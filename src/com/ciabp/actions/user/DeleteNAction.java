package com.ciabp.actions.user;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ciabp.iservices.ILinchuangService;
import com.ciabp.iservices.INoteImageService;
import com.ciabp.iservices.INoteService;
import com.ciabp.models.NoteImage;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteNAction extends ActionSupport{
	private String id;
	private String no;
	private String filename;
	private INoteService noteService;
	private INoteImageService noteImageService;
	private ILinchuangService linchuangService;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public ILinchuangService getLinchuangService() {
		return linchuangService;
	}
	public void setLinchuangService(ILinchuangService linchuangService) {
		this.linchuangService = linchuangService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public INoteService getNoteService() {
		return noteService;
	}
	public void setNoteService(INoteService noteService) {
		this.noteService = noteService;
	}
	public INoteImageService getNoteImageService() {
		return noteImageService;
	}
	public void setNoteImageService(INoteImageService noteImageService) {
		this.noteImageService = noteImageService;
	}
	
	public String deleteN(){
		List<NoteImage> list = noteImageService.tlistByNoteid(id);
		if(list!=null){
			for(int i = 0;i < list.size();i++){
				File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"uploadimages/"+list.get(i).getUserno()+"/"+list.get(i).getFilename());
				if(file.exists()){
					file.delete();
				}
			}
		}
		if(noteService.tdelete(id) && noteImageService.tdeleteN(id)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	
	public String deleteL(){
		File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"lcimages/"+no+"/"+filename);
		if(file.exists()){
			file.delete();
		}
		if(linchuangService.tdeleteL(id)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
	

}
