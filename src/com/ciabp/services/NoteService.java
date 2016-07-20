package com.ciabp.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.ciabp.idaos.INoteDao;
import com.ciabp.idaos.INoteImageDao;
import com.ciabp.iservices.INoteService;
import com.ciabp.models.Note;

public class NoteService extends ServiceBase implements INoteService{

	private INoteDao noteDao;
	private INoteImageDao noteImageDao;
	
	
	public INoteImageDao getNoteImageDao() {
		return noteImageDao;
	}
	public void setNoteImageDao(INoteImageDao noteImageDao) {
		this.noteImageDao = noteImageDao;
	}
	public INoteDao getNoteDao() {
		return noteDao;
	}
	public void setNoteDao(INoteDao noteDao) {
		this.noteDao = noteDao;
	}

	@Override
	public boolean tdoaddNote(Note note){
		note.setDate(new Date());
		return noteDao.add(note);
	}


	@Override
	public List<Note> tlistByNo(String no) {
		List<Note> list = noteDao.listByNo(no);
		if(list != null){
			for(int i = 0;i < list.size();i++){
				list.get(i).setNoteImages(noteImageDao.listByNoteid(list.get(i).getId()+""));
			}
		}		
		return list;
	}
	@Override
	public boolean tdelete(String id) {
		return noteDao.delete(id);
	}


	

}
