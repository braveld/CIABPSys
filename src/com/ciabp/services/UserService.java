package com.ciabp.services;

import java.util.List;

import com.ciabp.idaos.IUserDao;
import com.ciabp.idaos.IWriteQStatusDao;
import com.ciabp.iservices.IUserService;
import com.ciabp.models.Admin;
import com.ciabp.models.Linchuang;
import com.ciabp.models.PageVO;
import com.ciabp.models.User;
import com.ciabp.models.WriteQStatus;
import com.ciabp.utils.ServiceResult;

public class UserService extends ServiceBase implements IUserService{
	
	private IUserDao userDao;
	private IWriteQStatusDao writeQStatusDao;
	
	
	public IWriteQStatusDao getWriteQStatusDao() {
		return writeQStatusDao;
	}

	public void setWriteQStatusDao(IWriteQStatusDao writeQStatusDao) {
		this.writeQStatusDao = writeQStatusDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean tdoaddUser(User user) {
		int count = userDao.count()+1;
		user.setNo(String.format("BD%05d",count));
		userDao.plusone();
		return userDao.add(user);
	}

	@Override
	public boolean tlogin(String no, String password) {
		if(no == null || password == null){
			return false;
		}
		User user = new User();
		user = userDao.findByNo1(no);
		if(user == null){
			return false;
		}
		if(password.equals(user.getPassword())){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public User tfindByNo(String no) {
		return userDao.findByNo1(no);
	}

	@Override
	public List<User> tlistAll() {
		return userDao.listAll();
	}

	@Override
	public PageVO tlistByQno(String qno,int page) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		
		// 计算总页数
		List<User> list = userDao.listAll();
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
			pageVO.setList(userDao.listByQno(qno,page));
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
		List<User> list = userDao.listAll();
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
			pageVO.setList(userDao.listAllByPage(page));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}


	@Override
	public boolean tdoudelete(String no) {
		return userDao.udelete(no);
	}

	@Override
	public User tfindByNo1(String no) {
		return userDao.findByNo2(no);
	}
	
	public User tfindByNo2(String no) {
		return userDao.findByNo3(no);
	}

	@Override
	public boolean tdouupdate(String no, String mphone, String nick,
			String name, String sex, String type, String birthday,
			String education, String work, String email, String qq, String weixin,
			String phone, String address) {
		// TODO Auto-generated method stub
		return userDao.uupdate(no, mphone, nick, name, sex, type, birthday, education, work, email, qq, weixin, phone, address);
	}


	@Override
	public PageVO tlistByNick(String nick) {
		PageVO pageVO = new PageVO();
		List<User> l = userDao.listAll();
		if(l!=null){
			int resultCount = l.size();
			int pageCount = resultCount / PageVO.getCount();
			if (resultCount % PageVO.getCount() != 0) {
				pageCount++;
			}
			pageVO.setList(userDao.listByNick(nick));
			pageVO.setPageCount(pageCount);
			pageVO.setPage(pageCount);
		}
		
		return pageVO;
	}

	@Override
	public PageVO tlistBySql(String sql, Object[] params) {
		// 封装分页对象
		PageVO pageVO = new PageVO();
		pageVO.setList(userDao.listBySql(sql, params));
		pageVO.setPageCount(1);
		pageVO.setPage(1);
		return pageVO;
	}

	@Override
	public PageVO tlistBySqlPage(String sql, Object[] params, int page,String s,Object[] sparams,String qno) {
		PageVO pageVO = new PageVO();
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		// 计算总页数
		
		List<User> list = userDao.listBySqlQno(s, sparams,qno);
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
			pageVO.setList(userDao.listBySqlQno(sql, params,qno));
			pageVO.setPageCount(pageCount);
		}else{
			pageVO.setPageCount(1);
		}	
		// 封装分页对象	
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public PageVO tlistBySqlQ(String sql, Object[] params, String qno) {
		// 封装分页对象
				PageVO pageVO = new PageVO();
				pageVO.setList(userDao.listBySqlQno(sql, params,qno));
				pageVO.setPageCount(1);
				pageVO.setPage(1);
				return pageVO;
	}


	

}
