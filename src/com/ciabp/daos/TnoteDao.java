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


import com.ciabp.idaos.ITnoteDao;
import com.ciabp.models.PageVO;
import com.ciabp.models.Tnote;
import com.ciabp.utils.TimeIdGenerator;
import com.sun.jmx.snmp.Timestamp;


public class TnoteDao extends JdbcDaoSupport implements ITnoteDao {

	@Override
	public boolean add(Tnote tnote) {

		String sql = "insert into tuijiannote(id,nick,date,content,no,title,name) values(?,?,?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),tnote.getNick(),new Date(),tnote.getContent(),tnote.getNo(),tnote.getTitle(),tnote.getName()};

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
	
	class TnoteMapper implements RowMapper<Tnote>{

		@Override
		public Tnote mapRow(ResultSet rs, int arg1) throws SQLException {
			Tnote tnote = new Tnote();
			tnote.setId(rs.getLong("id"));
			tnote.setDate(rs.getTimestamp("date"));
			tnote.setNick(rs.getString("nick"));
			tnote.setNo(rs.getString("no"));
			tnote.setContent(rs.getString("content"));
			tnote.setTitle(rs.getString("title"));
			tnote.setName(rs.getString("name"));
			return tnote;
		}
		
	}

	@Override
	public List<Tnote> listByNo(String no) {
		String sql = "select * from tuijiannote where no = ?";
		List<Tnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new TnoteMapper(),no);
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
	public List<Tnote> listAllByNick(String nick) {
		String sql = "select * from tuijiannote where nick = ?";
		List<Tnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new TnoteMapper(),nick);
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
		String sql = "select * from tuijiannote limit ?,?";
		List<Tnote> list = null;
		Object[] params = new Object[] {(page-1)*10,10};
		try {
			list = super.getJdbcTemplate().query(sql, new TnoteMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public Tnote findByNo(String no) {
		String sql = "select * from tuijiannote where no=?";
		List<Tnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new TnoteMapper(), no);
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
		String sql = "select count(id) from tuijiannote";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Tnote> listAll() {
		String sql = "select * from tuijiannote";
		List<Tnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new TnoteMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public boolean tdelete(String no) {
		String sql = "delete from tuijiannote where no = ?";
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
	public boolean tupdate(String nick, String date, String content, String no, String title) {
		String sql = "update tuijiannote set nick = ?, date = ?, content = ?, no = ?, title = ? where no = ?";
		Object[] params = new Object[]{nick,date,content,no,title,no};
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
	public List listAllByPage1(int page,String nick) {
		String sql = "select * from tuijiannote where nick = ? limit ?,?";
		List<Tnote> list = null;
		Object[] params = new Object[] {nick,(page-1)*10,10};
		try {
			list = super.getJdbcTemplate().query(sql, new TnoteMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public List<Tnote> listBySql(String sql, Object[] params) {
		List<Tnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new TnoteMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}
	
	

}
