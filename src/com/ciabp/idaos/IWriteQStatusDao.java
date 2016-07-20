package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.WriteQStatus;

public interface IWriteQStatusDao {

	public boolean add(WriteQStatus writeQStatus);
	
	public List<WriteQStatus> listByUser(String userno);
	
	public List<WriteQStatus> listByQno(String qno);
	
	public int count(String qno);
	
	public boolean delete(String userno);
	

}
