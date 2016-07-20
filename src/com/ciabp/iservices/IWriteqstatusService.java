package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.WriteQStatus;

public interface IWriteqstatusService {

	public boolean tadd(WriteQStatus writeQStatus);
	
	public List<WriteQStatus> tlistByUser(String userno);
	
	public boolean tdeleteByUser(String userno);
}
