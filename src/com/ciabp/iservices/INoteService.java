package com.ciabp.iservices;

import java.text.ParseException;
import java.util.List;

import com.ciabp.models.Note;

public interface INoteService {
	public boolean tdoaddNote(Note note);
	
	public List<Note> tlistByNo(String no);
	
	public boolean tdelete(String id);
}
