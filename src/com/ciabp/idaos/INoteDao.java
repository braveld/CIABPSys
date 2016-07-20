package com.ciabp.idaos;

import java.text.ParseException;
import java.util.List;

import com.ciabp.models.Note;

public interface INoteDao {

	public boolean add(Note note);
	
	public List<Note> listByNo(String no);
	
	public boolean delete(String id);
}
