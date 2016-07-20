package com.ciabp.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.ciabp.idaos.IDnoteDao;
import com.ciabp.iservices.IDnoteService;
import com.ciabp.models.PageVO;
import com.ciabp.models.Dnote;
import com.ciabp.models.Tnote;
import com.ciabp.models.User;



public class DnoteService extends ServiceBase implements IDnoteService{
	private User user;
	private IDnoteDao dnoteDao;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IDnoteDao getDnoteDao() {
		return dnoteDao;
	}

	public void setDnoteDao(IDnoteDao dnoteDao) {
		this.dnoteDao = dnoteDao;
	}

	@Override
	public boolean tdoaddNote(Dnote dnote) {
		dnote.setDate(new Date());
		int count = dnoteDao.count()+1;
		dnote.setNo(String.format("Dn%05d",count));
		return dnoteDao.add(dnote);
	}

	@Override
	public List<Dnote> tlistByNo(String no) {
		return dnoteDao.listByNo(no);
	}

	@Override
	public PageVO tlistAllByPage(int page, String nick) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		List<Dnote> list = dnoteDao.listAllByNick(nick);
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
			pageVO.setList(dnoteDao.listAllByPage(page));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public PageVO tlistAllByPage(int page) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		List<Dnote> list = dnoteDao.listAll();
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
			pageVO.setList(dnoteDao.listAllByPage(page));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public PageVO tlistAllByPage1(int page, String nick) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		List<Dnote> list = dnoteDao.listAllByNick(nick);
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
			pageVO.setList(dnoteDao.listAllByPage1(page,nick));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public Dnote tfindByNo(String no) {
		return dnoteDao.findByNo(no);
	}

	@Override
	public boolean tdoddelete(String no) {
		return dnoteDao.ddelete(no);
	}

	@Override
	public boolean tdodupdate(String no, String nick, String title,
			String content, String date) {
		return dnoteDao.dupdate(no, nick, title, content, date);
	}

	@Override
	public PageVO dlistBySql(String sql, Object[] params) {
		PageVO pageVO = new PageVO();
		pageVO.setList(dnoteDao.listBySql(sql, params));
		pageVO.setPageCount(1);
		pageVO.setPage(1);
		return pageVO;
	}

}
