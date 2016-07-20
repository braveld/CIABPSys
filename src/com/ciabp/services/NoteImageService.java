package com.ciabp.services;

import java.util.List;

import com.ciabp.idaos.INoteImageDao;
import com.ciabp.iservices.IAnswerService;
import com.ciabp.iservices.INoteImageService;
import com.ciabp.models.NoteImage;

public class NoteImageService extends ServiceBase implements INoteImageService{
	
	private INoteImageDao noteImageDao;

	public INoteImageDao getNoteImageDao() {
		return noteImageDao;
	}
	public void setNoteImageDao(INoteImageDao noteImageDao) {
		this.noteImageDao = noteImageDao;
	}
	@Override
	public boolean tadd(NoteImage noteImage) {
		return noteImageDao.add(noteImage);
	}
	@Override
	public boolean tdeleteN(String noteid) {
		return noteImageDao.deleteN(noteid);
	}
	@Override
	public List<NoteImage> tlistByNoteid(String noteid) {
		return noteImageDao.listByNoteid(noteid);
	}
	
	
	

}
