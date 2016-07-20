package com.ciabp.services;

import java.util.List;

import com.ciabp.idaos.ILinchuangDao;
import com.ciabp.iservices.IAnswerService;
import com.ciabp.iservices.ILinchuangService;
import com.ciabp.models.Linchuang;
import com.ciabp.models.PageVO;
import com.ciabp.models.QDetail;

public class LinchuangService  extends ServiceBase implements ILinchuangService{
	
	private ILinchuangDao linchuangDao;
	

	public ILinchuangDao getLinchuangDao() {
		return linchuangDao;
	}

	public void setLinchuangDao(ILinchuangDao linchuangDao) {
		this.linchuangDao = linchuangDao;
	}

	@Override
	public boolean tadd(Linchuang linchuang) {
		return linchuangDao.add(linchuang);
	}

	@Override
	public PageVO tlistByUser(String userno,int page) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		List<Linchuang> list = linchuangDao.listAll();
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
			pageVO.setList(linchuangDao.listByUser(userno, page));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public boolean tdeleteL(String id) {
		return linchuangDao.deleteL(id);
	}


}
