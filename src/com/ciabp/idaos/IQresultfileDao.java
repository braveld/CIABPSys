package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.Qresultfile;

public interface IQresultfileDao {

	public boolean add(Qresultfile qresultfile);
	
	public List<Qresultfile> listQr();
	
	public boolean delete(long id);
}
