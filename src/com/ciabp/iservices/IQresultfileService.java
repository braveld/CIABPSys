package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.Qresultfile;

public interface IQresultfileService {

	public boolean tadd(Qresultfile qresultfile);
	
	public List<Qresultfile> tlistQr();
	
	public boolean tdelete(long id);
}
