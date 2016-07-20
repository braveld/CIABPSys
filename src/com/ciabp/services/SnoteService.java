package com.ciabp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ciabp.idaos.ISnoteDao;
import com.ciabp.iservices.ISnoteService;
import com.ciabp.models.PageVO;
import com.ciabp.models.Snote;
import com.ciabp.models.User;

public class SnoteService extends ServiceBase implements ISnoteService{
	
	private ISnoteDao snoteDao;
	
	public ISnoteDao getSnoteDao() {
		return snoteDao;
	}

	public void setSnoteDao(ISnoteDao snoteDao) {
		this.snoteDao = snoteDao;
	}

	@Override
	public boolean tdoaddNote(Snote snote) {
		Date date = new Date();
		snote.setDate(date);
		int count = snoteDao.count()+1;
		snote.setNo(String.format("SN%05d",count));
		return snoteDao.add(snote);
		
	}

	@Override
	public List<Snote> tlistByNo(String no) {
		return snoteDao.listByNo(no);
	}

	@Override
	public PageVO tlistAllByPage(int page) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		List<Snote> list = snoteDao.listAll();
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
			pageVO.setList(snoteDao.listAllByPage(page));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public Snote tfindByNo(String no) {
		return snoteDao.findByNo(no);
	}

	@Override
	public boolean tdosdelete(String no) {
		// TODO Auto-generated method stub
		return snoteDao.sdelete(no);
	}

}
