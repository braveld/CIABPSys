package com.ciabp.services;

import java.util.Date;
import java.util.List;

import com.ciabp.idaos.IQDetailDao;
import com.ciabp.iservices.IQDetailService;
import com.ciabp.models.PageVO;
import com.ciabp.models.QDetail;

public class QDetailService extends ServiceBase implements IQDetailService{
	
	private IQDetailDao qDetailDao;
	public IQDetailDao getqDetailDao() {
		return qDetailDao;
	}
	public void setqDetailDao(IQDetailDao qDetailDao) {
		this.qDetailDao = qDetailDao;
	}

	@Override
	public List<QDetail> tlistAll() {
		return qDetailDao.listAll();
	}

	@Override
	public boolean tdoaddQD(QDetail qDetail) {
		qDetail.setDate(new Date());
		qDetail.setIsopen("不启用");
		qDetailDao.plusone();
		return qDetailDao.add(qDetail);
	}

	@Override
	public boolean tdoupdateIsopen(String openno) {
		
		if(qDetailDao.findByIsopen()==null){
			if(qDetailDao.updateIsopen(openno, "启用")){
				return true;
			}
		}else{
			if(qDetailDao.updateIsopen(qDetailDao.findByIsopen().getNo(), "不启用") && qDetailDao.updateIsopen(openno, "启用")){
				return true;
			}
		}
		return false;
	}

	@Override
	public QDetail tfindByIsopen() {
		return qDetailDao.findByIsopen();
	}

	@Override
	public List<QDetail> tlistByUser(String userno) {
		return qDetailDao.listByUser(userno);
	}

	@Override
	public PageVO tlistByPage(int page) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		List<QDetail> list = qDetailDao.listAll();
		int resultCount = 0;
		if(list!=null){
			resultCount = list.size();
			int pageCount = resultCount / PageVO.getCount();
			if (resultCount % PageVO.getCount() != 0) {
				pageCount++;
			}		
			if (page > pageCount) {
				page = pageCount;
			}
			pageVO.setList(qDetailDao.listByPage(page));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public boolean tforbid() {
		return qDetailDao.forbid();
	}

	@Override
	public boolean tupdateQY(String qno) {
		return qDetailDao.updateQY(qno);
	}
	@Override
	public boolean tupdatename(String name, String qno) {
		return qDetailDao.updatename(name, qno);
	}



}
