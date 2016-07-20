package com.ciabp.services;

import java.util.List;


import com.ciabp.idaos.IReserveDao;
import com.ciabp.iservices.IReserveService;
import com.ciabp.models.Reserve;

public class ReserveService extends ServiceBase implements IReserveService{
	
	private IReserveDao reserveDao;

	public IReserveDao getReserveDao() {
		return reserveDao;
	}
	public void setReserveDao(IReserveDao reserveDao) {
		this.reserveDao = reserveDao;
	}

	@Override
	public List<Reserve> tlistAll() {
		List<Reserve> list = reserveDao.listAll();
		return list;
	}

	@Override
	public boolean tdoaddReserve(Reserve reserve) {
		return reserveDao.add(reserve);
	}

	@Override
	public boolean tdoupdateStatus(String no, String status) {
		return reserveDao.updateStatus(no, status);
	}

	@Override
	public Reserve tfindByNo(String no) {
		return reserveDao.findByNo(no);
	}

	@Override
	public List<Reserve> tlistByStatus(String status) {
		return reserveDao.listByStatus(status);
	}

	@Override
	public boolean tupdateresult(String url, String no,String filename) {
		return reserveDao.updateurl(url, no,filename);
	}
	
	
	

}
