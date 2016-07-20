package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.idaos.ISnoteDao;
import com.ciabp.models.Snote;
import com.ciabp.utils.TimeIdGenerator;
import com.sun.jmx.snmp.Timestamp;


public class SnoteDao extends JdbcDaoSupport implements ISnoteDao{

	public boolean add(Snote snote) {
		String sql = "insert into systemnote(id,date,content,no) values(?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),new Date(),snote.getContent(),snote.getNo()};
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

	class SnoteMapper implements RowMapper<Snote>{

		@Override
		public Snote mapRow(ResultSet rs, int arg1) throws SQLException {
			Snote snote = new Snote();
			snote.setId(rs.getLong("id"));
			Date date = rs.getTimestamp("date");
			snote.setDate(date);
			snote.setNo(rs.getString("no"));
			snote.setContent(rs.getString("content"));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			snote.setDatetime(formatter.format(date));
			return snote;
		}
		
	}
	
	public List<Snote> listByNo(String no) {
		String sql = "select * from systemnote where no = ?";
		List<Snote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new SnoteMapper(),no);
			if(list.isEmpty())
				return null;
			else 
				return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public List<Snote> listAll() {
		String sql = "select * from systemnote";
		List<Snote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new SnoteMapper());
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
		String sql = "select * from systemnote limit ?,?";
		List<Snote> list = null;
		Object[] params = new Object[] {(page-1)*10,10};
		try {
			list = super.getJdbcTemplate().query(sql, new SnoteMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public Snote findByNo(String no) {
		String sql = "select * from systemnote where no=?";
		List<Snote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new SnoteMapper(), no);
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
		String sql = "select count(id) from systemnote";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean sdelete(String no) {
		String sql = "delete from systemnote where no = ?";
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
	
	

}
