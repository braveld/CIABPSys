package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.NoteImage;

public interface INoteImageService {
	
	public boolean tadd(NoteImage noteImage);
	
	public boolean tdeleteN(String noteid);
	
	public List<NoteImage> tlistByNoteid(String noteid);

}
