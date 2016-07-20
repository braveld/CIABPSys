package com.ciabp.services;

import java.util.List;


import com.ciabp.idaos.IQresultfileDao;
import com.ciabp.iservices.IQresultfileService;
import com.ciabp.models.Qresultfile;

public class QresultfileService extends ServiceBase implements IQresultfileService {
	
	private IQresultfileDao qresultfileDao;
	
	public IQresultfileDao getQresultfileDao() {
		return qresultfileDao;
	}

	public void setQresultfileDao(IQresultfileDao qresultfileDao) {
		this.qresultfileDao = qresultfileDao;
	}

	@Override
	public boolean tadd(Qresultfile qresultfile) {
		return qresultfileDao.add(qresultfile);
	}

	@Override
	public List<Qresultfile> tlistQr() {
		return qresultfileDao.listQr();
	}

	@Override
	public boolean tdelete(long id) {
		return qresultfileDao.delete(id);
	}

}
