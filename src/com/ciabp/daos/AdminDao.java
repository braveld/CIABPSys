package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.UserDao.UserMapper;
import com.ciabp.idaos.IAdminDao;
import com.ciabp.models.Admin;
import com.ciabp.models.User;
import com.ciabp.utils.TimeIdGenerator;

public class AdminDao extends JdbcDaoSupport implements IAdminDao{

	@Override
	public Admin findByNo(String no) {
		String sql = "select * from admin where no=?";
		List<Admin> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new AdminMapper(), no);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

	class AdminMapper implements RowMapper<Admin>{

		@Override
		public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
			Admin admin = new Admin();
			admin.setId(rs.getLong("id"));
			admin.setName(rs.getString("name"));
			admin.setNo(rs.getString("no"));
			admin.setPassword(rs.getString("password"));
			admin.setRole(rs.getString("role"));
			return admin;
		}
		
	}

	@Override
	public boolean addAdmin(Admin admin) {
		String sql = "insert into admin(id,name,no,password,role) values(?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),admin.getName(),admin.getNo(),admin.getPassword(),admin.getRole()};
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
	public int count() {
		String sql = "select num from liucun where type = ?";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class,"admin");
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Admin> listAll() {
		String sql = "select * from admin";
		List<Admin> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new AdminMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public List listAllByPage(int page) {
		String sql = "select * from admin limit ?,?";
		List<Admin> list = null;
		Object[] params = new Object[] {(page-1)*10,10};
		try {
			list = super.getJdbcTemplate().query(sql, new AdminMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public boolean sdelete(String no) {
		String sql = "delete from admin where no = ?";
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
	public boolean plusone() {
		String sql = "update liucun set num = num+1 where type = ?";
		Object[] params = new Object[] {"admin"};
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
	public boolean aupdate(String password,String no) {
		String sql = "update admin set password = ? where no = ?";
		Object[] params = new Object[]{password,no};
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
}
