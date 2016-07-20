package com.ciabp.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.ciabp.idaos.ITnoteDao;
import com.ciabp.iservices.ITnoteService;
import com.ciabp.models.PageVO;
import com.ciabp.models.Snote;
import com.ciabp.models.Tnote;
import com.ciabp.models.User;


public class TnoteService extends ServiceBase implements ITnoteService {
	private User user;
	private ITnoteDao tnoteDao;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ITnoteDao getTnoteDao() {
		return tnoteDao;
	}

	public void setTnoteDao(ITnoteDao tnoteDao) {
		this.tnoteDao = tnoteDao;
	}

	@Override
	public boolean tdoaddNote(Tnote tnote) {
		tnote.setDate(new Date());
		int count = tnoteDao.count()+1;
		tnote.setNo(String.format("Tn%05d",count));
		return tnoteDao.add(tnote);
	}
	
	@Override
	public List<Tnote> tlistByNo(String no) {
		return tnoteDao.listByNo(no);
	}

	@Override
	public PageVO tlistAllByPage(int page,String nick) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		List<Tnote> list = tnoteDao.listAllByNick(nick);
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
			pageVO.setList(tnoteDao.listAllByPage(page));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public Tnote tfindByNo(String no) {
		return tnoteDao.findByNo(no);
	}

	@Override
	public PageVO tlistAllByPage(int page) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		List<Tnote> list = tnoteDao.listAll();
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
			pageVO.setList(tnoteDao.listAllByPage(page));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public boolean tdotdelete(String no) {
		return tnoteDao.tdelete(no);
	}

	@Override
	public boolean tdotupdate(String nick, String date, String content,
			String no, String title) {
		
		return tnoteDao.tupdate(nick, date, content, no, title);
	}

	@Override
	public PageVO tlistAllByPage1(int page, String nick) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		List<Tnote> list = tnoteDao.listAllByNick(nick);
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
			pageVO.setList(tnoteDao.listAllByPage1(page,nick));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public PageVO tlistBySql(String sql, Object[] params) {
		PageVO pageVO = new PageVO();
		pageVO.setList(tnoteDao.listBySql(sql, params));
		pageVO.setPageCount(1);
		pageVO.setPage(1);
		return pageVO;
	}

}
