package com.ciabp.daos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.NoteDao.NoteMapper;
import com.ciabp.idaos.IAnswerDao;
import com.ciabp.models.Answer;
import com.ciabp.utils.TimeIdGenerator;

public class AnswerDao extends JdbcDaoSupport implements IAnswerDao {
	@Override
	public boolean add(Answer answer) {
		
		String sql = "insert into answers(id,no,type,userno,qno,answers,date,atime) values(?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),answer.getNo(),answer.getType(),answer.getUser(),answer.getQno(),answer.getAnswer(),answer.getDate(),answer.getTime()};
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
	class AnswerMapper implements RowMapper<Answer>{

		@Override
		public Answer mapRow(ResultSet rs, int arg1) throws SQLException {
			Answer answer = new Answer();
			answer.setId(rs.getLong("id"));
			answer.setNo(rs.getString("no"));
			answer.setType(rs.getString("type"));
			answer.setUser(rs.getString("userno"));
			answer.setQno(rs.getString("qno"));
			answer.setAnswer(rs.getString("answers"));
			answer.setDate(rs.getDate("date"));
			answer.setTime(rs.getString("atime"));
			return answer;
		}
		
	}
	@Override
	public Answer findByNo(String no, String user) {
		String sql = "select * from answers where no = ? and userno = ?";
		Object[] params = new Object[]{no,user};
		List<Answer> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new AnswerMapper(),params);
			if(list.isEmpty())
				return null;
			else 
				return list.get(0);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}		
	}
	@Override
	public List<Answer> listByUser(String userno, String no) {
		String sql = "select * from answers where no = ? and userno = ?";
		Object[] params = new Object[]{no,userno};
		List<Answer> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new AnswerMapper(),params);
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
	public boolean deleteByNo(String no, String qno) {
		String sql = "delete from answers where no = ? and userno = ?";
		Object[] params = new Object[]{qno,no};
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
	public boolean deleteByUser(String userno) {
		String sql = "delete from answers where userno = ?";
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
