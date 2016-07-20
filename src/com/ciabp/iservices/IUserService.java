package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.PageVO;
import com.ciabp.models.User;
import com.ciabp.utils.ServiceResult;

public interface IUserService {

	public boolean tdoaddUser(User user);
	
	public boolean tlogin(String no,String name);
	
	public boolean tdoudelete(String no);
	public boolean tdouupdate(String no,String mphone,String nick,String name,String sex,String type,String birthday,String education,String work,String email,String qq,String weixin,String phone,String address);
	public User tfindByNo(String no);
	
	public User tfindByNo1(String no);
	public User tfindByNo2(String no);
	public List<User> tlistAll();
	
	public PageVO tlistByQno(String qno,int page);
	
	public PageVO tlistAllByPage(int page);
	
	public PageVO tlistByNick(String nick);
	
	public PageVO tlistBySql(String sql,Object[] params);
	
	public PageVO tlistBySqlQ(String sql,Object[] params,String qno);
	
	public PageVO tlistBySqlPage(String sql,Object[] params,int page,String s,Object[] sparams,String qno);
}
