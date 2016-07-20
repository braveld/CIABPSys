package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.UserDao.UserMapper;
import com.ciabp.daos.WriteQStatusDao.WriteqstatusM;
import com.ciabp.idaos.IUserDao;
import com.ciabp.models.User;
import com.ciabp.models.WriteQStatus;
import com.ciabp.utils.TimeIdGenerator;



public class UserDao extends JdbcDaoSupport implements IUserDao {

	@Override
	public boolean add(User user) {
	
		String sql = "insert into user(id,nick,name,sex,type,birthday,education,work,email,qq,weixin,mphone,phone,address,no,password,confirm) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Object[] params = new Object[] {TimeIdGenerator.generateId(),user.getNick().trim(),user.getName().trim(),user.getSex(),user.getType(),user.getBirthday(),user.getEducation(),user.getWork(),user.getEmail(),user.getQq(),user.getWeixin(),user.getMphone(),user.getPhone(),user.getAddress(),user.getNo(),user.getPassword(),user.getConfirm()};


		try {
			if (super.getJdbcTemplate().update(sql, params) > 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setNick(rs.getString("nick"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setType(rs.getString("type"));
			user.setBirthday(rs.getString("birthday"));
			user.setEducation(rs.getInt("education"));
			user.setWork(rs.getString("work"));
			user.setEmail(rs.getString("email"));
			user.setQq(rs.getString("qq"));
			user.setWeixin(rs.getString("weixin"));
			user.setMphone(rs.getString("mphone"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			user.setNo(rs.getString("no"));
			user.setPassword(rs.getString("password"));
			user.setConfirm(rs.getString("confirm"));
			user.setQstatus("未填");
			return user;
		}
		
	}
	
	class Userw implements RowMapper<User>{
		private String qno;
		public String getQno() {
			return qno;
		}
		public void setQno(String qno) {
			this.qno = qno;
		}

		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setNick(rs.getString("nick"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setType(rs.getString("type"));
			user.setBirthday(rs.getString("birthday"));
			user.setEducation(rs.getInt("education"));
			user.setWork(rs.getString("work"));
			user.setEmail(rs.getString("email"));
			user.setQq(rs.getString("qq"));
			user.setWeixin(rs.getString("weixin"));
			user.setMphone(rs.getString("mphone"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			user.setNo(rs.getString("no"));
			user.setPassword(rs.getString("password"));
			user.setConfirm(rs.getString("confirm"));
			if(listByUser(rs.getString("no"),qno)==null){
				user.setQstatus("未填");
			}else{
				user.setQstatus("已填");
			}
			
			return user;
		}
		
	}
	
	public List<WriteQStatus> listByUser(String userno,String qno) {
		String sql = "select * from writeqstatus where userno = ? and qno = ?";
		Object[] params = new Object[]{userno,qno};
		List<WriteQStatus> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new WriteqstatusM(),params);
			if(list==null || list.isEmpty())
				return null;
			else 
				return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	class WriteqstatusM implements RowMapper<WriteQStatus>{

		@Override
		public WriteQStatus mapRow(ResultSet rs, int arg1)
				throws SQLException {
			WriteQStatus writeQStatus = new WriteQStatus();
			writeQStatus.setId(rs.getLong("id"));
			writeQStatus.setDate(rs.getDate("date"));
			writeQStatus.setQno(rs.getString("qno"));
			writeQStatus.setUserno(rs.getString("userno"));
			return writeQStatus;
		}
		
	}
	
	class UserM implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setNick(rs.getString("user.nick"));
			user.setName(rs.getString("user.name"));
			user.setMphone(rs.getString("user.mphone"));
			user.setNo(rs.getString("user.no"));
			user.setQstatus("已填");		
			return user;
		}
		
	}
	
	class UserMN implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setNick(rs.getString("user.nick"));
			user.setName(rs.getString("user.name"));
			user.setMphone(rs.getString("user.mphone"));
			user.setNo(rs.getString("user.no"));
			user.setQstatus("未填");		
			return user;
		}
		
	}
	
	@Override
	public User findByNo(String no) {
		String sql = "select * from user where mphone=?";
		List<User> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new UserMapper(), no);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}
	
	@Override
	public User findByNo1(String no) {
		String sql = "select * from user where mphone=? or nick=?";
		List<User> list = null;
		try {
			Object[] params = new Object[] {no,no};
			list = super.getJdbcTemplate().query(sql, new UserMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}
	@Override
	public int count() {
		String sql = "select num from liucun where type = ?";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class,"user");
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public List<User> listAll() {
		String sql = "select * from user";
		List<User> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new UserMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list==null||list.isEmpty())
			return null;
		else 
			return list;
	}
	@Override
	public List<User> listByQno(String qno,int page) {
		String sql = " select * from user limit ?,?";
		List<User> list = null;
		Object[] params = new Object[] {(page-1)*10,10};
		Userw userw = new Userw();
		userw.setQno(qno);
		try {
			list = super.getJdbcTemplate().query(sql, userw, params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list==null||list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public List<User> listAllByPage(int page) {
		String sql = "select * from user limit ?,?";
		List<User> list = null;
		Object[] params = new Object[] {(page-1)*10,10};
		try {
			list = super.getJdbcTemplate().query(sql, new UserMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}


	@Override
	public boolean udelete(String no) {
		String sql = "delete from user where no = ?";
		Object[] params = new Object[] {no};
		try {
			if (super.getJdbcTemplate().update(sql, params) > 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public List<User> listByNick(String nick) {
		String sql = "select * from user where nick = ?";
		List<User> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new UserMapper(), nick);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public User findByNo2(String no) {
		String sql = "select * from user where no=?";
		List<User> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new UserMapper(), no);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}
	
	public User findByNo3(String no) {
		String sql = "select nick from user where no=?";
		List<User> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new UserMapper(), no);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

	@Override
	public boolean uupdate(String no,String mphone, String nick, String name, String sex,
			String type, String birthday, String education, String work,
			String email, String qq, String weixin, String phone, String address) {
		String sql = "update user set mphone = ?, nick = ?, name = ?, sex = ?, type = ?, birthday = ?, education = ?, work = ?, email = ?, qq = ?, weixin = ?, phone = ?, address = ? where no = ?";
		Object[] params = new Object[]{mphone,nick,name,sex,type,birthday,education,work,email,qq,weixin,phone,address,no};
		try {
			if (super.getJdbcTemplate().update(sql, params) > 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	
	



	@Override
	public List<User> listBySql(String sql, Object[] params) {
		List<User> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new Userw(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list==null || list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public boolean plusone() {
		String sql = "update liucun set num = num+1 where type = ?";
		Object[] params = new Object[] {"user"};
		try {
			if (super.getJdbcTemplate().update(sql, params) > 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public int countall() {
		String sql = "select count(id) from user";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<User> listBySqlQno(String sql, Object[] params, String qno) {
		List<User> list = null;
		Userw userw = new Userw();
		userw.setQno(qno);
		try {
			list = super.getJdbcTemplate().query(sql,userw , params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list==null || list.isEmpty())
			return null;
		else 
			return list;
	}

	



}
