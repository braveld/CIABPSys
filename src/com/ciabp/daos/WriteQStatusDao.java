package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.NoteDao.NoteMapper;
import com.ciabp.idaos.IWriteQStatusDao;
import com.ciabp.models.Note;
import com.ciabp.models.WriteQStatus;
import com.ciabp.utils.TimeIdGenerator;

public class WriteQStatusDao extends JdbcDaoSupport implements IWriteQStatusDao{

	@Override
	public boolean add(WriteQStatus writeQStatus) {
		String sql = "insert into writeqstatus(id,qno,userno,date) values(?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),writeQStatus.getQno(),writeQStatus.getUserno(),writeQStatus.getDate()};
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
	
	@Override
	public List<WriteQStatus> listByUser(String userno) {
		String sql = "select * from writeqstatus where userno = ?";
		List<WriteQStatus> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new WriteqstatusM(),userno);
			if(list!=null)
				return list;
			else 
				return null;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public List<WriteQStatus> listByQno(String qno) {
		String sql = "select * from writeqstatus where qno = ?";
		List<WriteQStatus> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new WriteqstatusM(),qno);
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
	public int count(String qno) {
		String sql = "select count(id) from writeqstatus where qno = ?";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class,qno);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean delete(String userno) {
		String sql = "delete from writeqstatus where userno = ?";
		try {
			if (super.getJdbcTemplate().update(sql, userno) > 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
