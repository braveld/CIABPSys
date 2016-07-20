package com.ciabp.models;

import java.util.Date;
import java.util.List;

public class Note extends ModelBase{

	private Date date;
	private String user;
	private String content;
	private List<NoteImage> noteImages;
	
	
	public List<NoteImage> getNoteImages() {
		return noteImages;
	}
	public void setNoteImages(List<NoteImage> noteImages) {
		this.noteImages = noteImages;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
