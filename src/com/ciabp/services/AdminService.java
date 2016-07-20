package com.ciabp.services;

import java.util.List;

import com.ciabp.idaos.IAdminDao;
import com.ciabp.iservices.IAdminService;
import com.ciabp.models.Admin;
import com.ciabp.models.PageVO;
import com.ciabp.models.User;
import com.ciabp.utils.ServiceResult;
import com.opensymphony.xwork2.ActionSupport;


public class AdminService extends ServiceBase implements IAdminService{

	private static final long serialVersionUID = -1106165411598861520L;

	private IAdminDao adminDao;
	
	@Override
	public boolean tlogin(String no, String password) {
		if(no == null || password == null){
			return false;
		}
		Admin admin = new Admin();
		admin = adminDao.findByNo(no);
		if(admin == null){
			return false;
		}
		if(password.equals(admin.getPassword())){
			return true;
		}else{
			return false;
		}
	}

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean tdoAddAdmin(String no,String password) {
		Admin admin = new Admin();
		
		admin.setNo(no);
		admin.setPassword(password);
		admin.setRole("1");
		adminDao.plusone();
		return adminDao.addAdmin(admin);
	}

	@Override
	public PageVO tlistAllByPage(int page) {
		List<Admin> l = adminDao.listAll();
		int resultCount = l.size();
		int pageCount = resultCount / PageVO.getCount();
		if (resultCount % PageVO.getCount() != 0) {
			pageCount++;
		}
		// 判断当前页码
		if (page < 1) {
			page = 1;
		}
		if (page > pageCount) {
			page = pageCount;
		}
		// 封装分页对象
		PageVO pageVO = new PageVO();
		pageVO.setList(adminDao.listAllByPage(page));
		pageVO.setPageCount(pageCount);
		pageVO.setPage(page);
		return pageVO;
	}

	@Override
	public boolean tdousdelete(String no) {
		
		return adminDao.sdelete(no);
	}

	@Override
	public boolean tdoaupdate(String password,String no) {
		// TODO Auto-generated method stub
		return adminDao.aupdate(password,no);
	}

	@Override
	public Admin tfindByNo(String no) {
		// TODO Auto-generated method stub
		return adminDao.findByNo(no);
	}



	
	
}
