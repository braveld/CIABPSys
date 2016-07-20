package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.NoteImage;

public interface INoteImageDao {

	public boolean add(NoteImage noteImage);
	
	public List<NoteImage> listByNoteid(String noteid);
	
	public boolean deleteN(String noteid);
}
