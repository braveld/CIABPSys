package com.ciabp.actions.user;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.ciabp.iservices.INoteImageService;
import com.ciabp.iservices.INoteService;
import com.ciabp.models.Note;
import com.ciabp.models.NoteImage;
import com.ciabp.utils.TimeIdGenerator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddNoteAction extends ActionSupport{

	private INoteService noteService;
	private INoteImageService noteImageService;
	private Note note;
	private String[] noteimageFileName;
	private File[] noteimage;
	
	
	public INoteImageService getNoteImageService() {
		return noteImageService;
	}
	public void setNoteImageService(INoteImageService noteImageService) {
		this.noteImageService = noteImageService;
	}
	public String[] getNoteimageFileName() {
		return noteimageFileName;
	}
	public void setNoteimageFileName(String[] noteimageFileName) {
		this.noteimageFileName = noteimageFileName;
	}
	public File[] getNoteimage() {
		return noteimage;
	}
	public void setNoteimage(File[] noteimage) {
		this.noteimage = noteimage;
	}
	public INoteService getNoteService() {
		return noteService;
	}
	public void setNoteService(INoteService noteService) {
		this.noteService = noteService;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	
	public String addNote() throws UnsupportedEncodingException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		Map<String, Object> sessionMap = (Map<String, Object>) ActionContext
				.getContext().get("session");
		String no = (String)sessionMap.get("name");
		NoteImage rnoteImage = new NoteImage();
		long noteid = TimeIdGenerator.generateId();
		long filename = TimeIdGenerator.generateId();
		File file = new File(ServletActionContext.getServletContext().getRealPath("/")+"uploadimages/"+no);
		if(!file.exists() && !file .isDirectory()){
			System.out.println("//不存在");  
		    file .mkdir();
		}
		if(noteimageFileName!=null && !noteimageFileName[0].equals("")){
			for(int i = 0;i < noteimage.length;i++){
				String[] names = noteimageFileName[i].split("\\.");
				noteimage[i].renameTo(new File(ServletActionContext.getServletContext().getRealPath("/")+"uploadimages/"+no+"/"+filename+"."+names[1]));
				rnoteImage.setNoteid(noteid+"");
				rnoteImage.setUserno(no);
				rnoteImage.setUrl(noteimageFileName[i]);
				rnoteImage.setFilename(filename+"."+names[1]);
				rnoteImage.setType(names[1]);
				System.out.println(noteImageService.tadd(rnoteImage));
			}
		}		
		note.setId(noteid);
		note.setUser(no);
		if(noteService.tdoaddNote(note)){
			return ActionSupport.SUCCESS;
		}else{
			return ActionSupport.ERROR;
		}
	}
}
