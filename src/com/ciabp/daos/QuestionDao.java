package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.idaos.IQuestionDao;
import com.ciabp.models.Question;
import com.ciabp.utils.TimeIdGenerator;



public class QuestionDao extends JdbcDaoSupport implements IQuestionDao{

	@Override
	public boolean addQuestion(Question question) {
		String sql = "insert into question(id,no,type,question,answer,date,xuanxiang,isshow) values(?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),question.getNo(),question.getType(),question.getQuestion(),question.getAnswer(),question.getDate(),question.getOption(),question.getIsshow()};
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

	class QuestionMapper implements RowMapper<Question>{

		@Override
		public Question mapRow(ResultSet rs, int arg1) throws SQLException {
			Question question = new Question();
			question.setId(rs.getLong("id"));
			question.setNo(rs.getString("no"));
			question.setType(rs.getString("type"));
			question.setQuestion(rs.getString("question"));
			question.setAnswer(rs.getString("answer"));
			question.setDate(rs.getDate("date"));
			question.setOption(rs.getString("xuanxiang"));
			question.setIsshow(rs.getString("isshow"));
			return question;
		}
		
	}
	
	class QuestionM implements RowMapper<Question>{

		@Override
		public Question mapRow(ResultSet rs, int arg1) throws SQLException {
			Question question = new Question();
			question.setId(rs.getLong("question.id"));
			question.setNo(rs.getString("question.no"));
			question.setType(rs.getString("question.type"));
			question.setQuestion(rs.getString("question.question"));
			question.setAnswer(rs.getString("answers.answers"));
			question.setDate(rs.getDate("question.date"));
			question.setOption(rs.getString("question.xuanxiang"));
			//question.setIsshow(rs.getString("question.isshow"));
			return question;
		}
		
	}
	
	@Override
	public List<Question> listWithA(String qno,String userno){
		String sql = "select question.id,question.no,question.type,question.question," +
				"question.answer,question.date,question.xuanxiang,answers.answers " +
				"from question left join answers on question.no = answers.qno where question.no in " +
				"(select qno from questionaire where no = ?) and answers.userno = ? ";
		List<Question> list = null;
		Object[] params = new Object[] {qno,userno};
		try {
			list = super.getJdbcTemplate().query(sql, new QuestionM(),params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}
	
	@Override
	public List<Question> listAll() {
		String sql = "select * from question";
		List<Question> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QuestionMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public int count() {
		String sql = "select num from liucun where type = ?";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class,"question");
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updateshowByNo(String no,String isshow) {
		String sql = "update question set isshow = ? where no = ?";
		Object[] params = new Object[]{isshow,no};
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
	public boolean delete(String no) {
		String sql = "delete from question where no = ?";
		try {			
			if (super.getJdbcTemplate().update(sql, no) > 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public List<Question> listByS() {
		String sql = "select * from question where isshow = ?";
		List<Question> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QuestionMapper(),"显示");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public List<Question> listNoW(String qno) {
		String sql = "select * from question where isshow = ? and no not in (select qno from questionaire where no = ?)";
		List<Question> list = null;
		Object[] params = new Object[]{"显示",qno};
		try {
			list = super.getJdbcTemplate().query(sql, new QuestionMapper(),params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public boolean plusone() {
		String sql = "update liucun set num = num+1 where type = ?";
		Object[] params = new Object[] {"question"};
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
