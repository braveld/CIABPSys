package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.QuestionaireDao.QuestionaireMapper;
import com.ciabp.idaos.IQuestionaireDao;
import com.ciabp.models.Question;
import com.ciabp.models.Questionaire;
import com.ciabp.utils.TimeIdGenerator;

public class QuestionaireDao extends JdbcDaoSupport implements IQuestionaireDao{

	@Override
	public boolean add(Questionaire questionaire) {
		String sql = "insert into questionaire(id,no,qno,tihao) values(?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),questionaire.getNo(),questionaire.getQno(),count(questionaire.getNo())+1};
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
	
	class QuestionaireMapper implements RowMapper<Questionaire>{

		@Override
		public Questionaire mapRow(ResultSet rs, int arg1) throws SQLException {
			Questionaire questionaire = new Questionaire();
			questionaire.setId(rs.getLong("id"));
			questionaire.setNo(rs.getString("no"));
			questionaire.setQno(rs.getString("qno"));
			questionaire.setTihao(rs.getInt("tihao"));
			return questionaire;
		}
		
	}

	@Override
	public List<Questionaire> listAll() {
		String sql = "select * from questionaire";
		List<Questionaire> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QuestionaireMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list==null || list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public boolean delete(String qno,String no) {
		String sql = "delete from questionaire where qno = ? and no = ?";
		Object[] params = new Object[] {qno,no};
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
	public List<Question> listByNo(String no) {
		String sql = "select question.no,question.type,question.question,question.xuanxiang,question.date,question.isshow,questionaire.tihao from questionaire left join question on questionaire.qno = question.no where questionaire.no = ? order by questionaire.tihao";
		List<Question> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QuestionMapper(),no);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list==null)
			return null;
		else 
			return list;
		
	}
	
	@Override
	public int count() {
		String sql = "select count(id) from questionaire";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	class QuestionMapper implements RowMapper<Question>{

		@Override
		public Question mapRow(ResultSet rs, int arg1) throws SQLException {
			Question question = new Question();	
			question.setNo(rs.getString("question.no"));
			question.setType(rs.getString("question.type"));
			question.setQuestion(rs.getString("question.question"));
			question.setDate(rs.getDate("question.date"));
			question.setOption(rs.getString("question.xuanxiang"));
			question.setTihao(rs.getString("questionaire.tihao"));
			return question;
		}
		
	}

	@Override
	public int count(String qno) {
		String sql = "select count(id) from questionaire where no = ?";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class,qno);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updatetihao(String qno, String no, String tihao) {
		String sql = "update questionaire set tihao = ? where no = ? and qno = ?";
		Object[] params = new Object[]{tihao,no,qno};
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
