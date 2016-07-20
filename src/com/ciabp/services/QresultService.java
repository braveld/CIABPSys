package com.ciabp.services;

import java.util.List;

import com.ciabp.daos.QresultDao;
import com.ciabp.idaos.IQreslutDao;
import com.ciabp.iservices.IQresultService;
import com.ciabp.models.Qresult;



public class QresultService extends ServiceBase implements IQresultService{
	
	private IQreslutDao qresultDao;
	
	public IQreslutDao getQresultDao() {
		return qresultDao;
	}
	public void setQresultDao(IQreslutDao qresultDao) {
		this.qresultDao = qresultDao;
	}
	@Override
	public boolean tadd(Qresult qresult) {
		return qresultDao.add(qresult);
	}
	@Override
	public List<Qresult> tlistBySql(String sql, Object[] params) {
		return qresultDao.listBySql(sql, params);
	}
	@Override
	public boolean tdelete(String qno, String questionno, String xuanxiang) {
		return qresultDao.delete(qno, questionno, xuanxiang);
	}
	@Override
	public boolean tminus(String qno, String questionno, String xuanxiang) {
		return qresultDao.update(qno, questionno, xuanxiang);
	}
	@Override
	public boolean tadds(String qno, String questionno, String xuanxiang) {
		return qresultDao.adds(qno, questionno, xuanxiang);
	}

}
