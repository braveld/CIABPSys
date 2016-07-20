package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.Admin;
import com.ciabp.models.User;

public interface IAdminDao {
	
	/**
	 * 根据账号查询Admin对象
	 * @return
	 */
	public Admin findByNo(String no);
	
	/**
	 * 添加管理员账号
	 * @param admin
	 * @return
	 */
	public boolean addAdmin(Admin admin);
	
	/**
	 * 统计当前的记录数
	 * @return
	 */
	public int count();
	public boolean sdelete(String no);
	public List<Admin> listAll();
	public boolean plusone();

	public List listAllByPage(int page);
	public boolean aupdate(String password,String no);
}
