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

import com.ciabp.daos.QuestionDao.QuestionMapper;
import com.ciabp.idaos.INoteDao;
import com.ciabp.models.Note;
import com.ciabp.utils.TimeIdGenerator;
import com.sun.jmx.snmp.Timestamp;

public class NoteDao extends JdbcDaoSupport implements INoteDao{

	@Override
	public boolean add(Note note){
		String sql = "insert into note(id,date,userno,content) values(?,?,?,?)";
		Object[] params = new Object[] {note.getId(),new Date(),note.getUser(),note.getContent()};
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
	
	class NoteMapper implements RowMapper<Note>{

		@Override
		public Note mapRow(ResultSet rs, int arg1) throws SQLException {
			Note note = new Note();
			note.setId(rs.getLong("id"));
			note.setDate(rs.getTimestamp("date"));
			note.setUser(rs.getString("userno"));
			note.setContent(rs.getString("content"));
			return note;
		}
		
	}

	@Override

	public List<Note> listByNo(String no) {
		String sql = "select * from note where userno = ?";
		List<Note> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new NoteMapper(),no);
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
	public boolean delete(String id) {
		String sql = "delete from note where id = ?";
		try {
			if (super.getJdbcTemplate().update(sql, id) > 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
