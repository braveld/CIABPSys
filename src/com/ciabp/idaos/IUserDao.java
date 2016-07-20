package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.User;;

public interface IUserDao {
	public boolean add(User user);
	public User findByNo(String no);
	public User findByNo1(String no);
	public User findByNo2(String no);
	public User findByNo3(String no);
	public boolean udelete(String no);
	public boolean uupdate(String no,String mphone,String nick,String name,String sex,String type,String birthday,String education,String work,String email,String qq,String weixin,String phone,String address);
	public int count();
	public List<User> listAll();
	public List<User> listByQno(String qno,int page);
	public List<User> listAllByPage(int page);
	public List<User> listByNick(String nick);
	public List<User> listBySql(String sql,Object[] params);
	
	public List<User> listBySqlQno(String sql,Object[] params,String qno);
	public boolean plusone();
	public int countall();
}
