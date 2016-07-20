package com.ciabp.services;

import java.util.List;

import com.ciabp.idaos.IWriteQStatusDao;
import com.ciabp.iservices.IAdminService;
import com.ciabp.iservices.IWriteqstatusService;
import com.ciabp.models.WriteQStatus;

public class WriteqstatusService extends ServiceBase implements IWriteqstatusService{
	
	private IWriteQStatusDao writeQStatusDao;	
	public IWriteQStatusDao getWriteQStatusDao() {
		return writeQStatusDao;
	}
	public void setWriteQStatusDao(IWriteQStatusDao writeQStatusDao) {
		this.writeQStatusDao = writeQStatusDao;
	}


	@Override
	public boolean tadd(WriteQStatus writeQStatus) {		
		return writeQStatusDao.add(writeQStatus);
	}
	@Override
	public List<WriteQStatus> tlistByUser(String userno) {
		return writeQStatusDao.listByUser(userno);
	}
	@Override
	public boolean tdeleteByUser(String userno) {
		return writeQStatusDao.delete(userno);
	}

}
