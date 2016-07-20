package com.ciabp.iservices;

import com.ciabp.models.Admin;
import com.ciabp.models.PageVO;


public interface IAdminService {

	
	/**
	 * 管理员登录
	 * @param no
	 * @return
	 */
	public boolean tlogin(String no,String password);
	public Admin tfindByNo(String no);
	public boolean tdoAddAdmin(String name,String password);
	public PageVO tlistAllByPage(int page);
	public boolean tdousdelete(String no);
	public boolean tdoaupdate(String password,String no);
}
