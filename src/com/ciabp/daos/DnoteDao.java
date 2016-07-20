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


import com.ciabp.daos.TnoteDao.TnoteMapper;
import com.ciabp.idaos.IDnoteDao;
import com.ciabp.models.PageVO;
import com.ciabp.models.Dnote;
import com.ciabp.models.Tnote;
import com.ciabp.utils.TimeIdGenerator;
import com.sun.jmx.snmp.Timestamp;


public class DnoteDao extends JdbcDaoSupport implements IDnoteDao{

	@Override
	public boolean add(Dnote dnote) {
		String sql = "insert into dannote(id,no,nick,title,content,date,name) values(?,?,?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),dnote.getNo(),dnote.getNick(),dnote.getTitle(),dnote.getContent(),new Date(),dnote.getName()};
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

	class DnoteMapper implements RowMapper<Dnote>{

		@Override
		public Dnote mapRow(ResultSet rs, int arg1) throws SQLException {
			Dnote dnote = new Dnote();
			dnote.setId(rs.getLong("id"));
			dnote.setNo(rs.getString("no"));
			dnote.setNick(rs.getString("nick"));
			dnote.setTitle(rs.getString("title"));
			dnote.setContent(rs.getString("content"));
			dnote.setDate(rs.getTimestamp("date"));
			dnote.setName(rs.getString("name"));
			return dnote;
		}
		
	}
	
	@Override
	public List<Dnote> listByNo(String no) {
		String sql = "select * from dannote where no = ?";
		List<Dnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new DnoteMapper(),no);
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
	public List<Dnote> listAllByNick(String nick) {
		String sql = "select * from dannote where nick = ?";
		List<Dnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new DnoteMapper(),nick);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public List<Dnote> listAll() {
		String sql = "select * from dannote";
		List<Dnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new DnoteMapper());
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
		String sql = "select * from dannote limit ?,?";
		List<Dnote> list = null;
		Object[] params = new Object[] {(page-1)*10,10};
		try {
			list = super.getJdbcTemplate().query(sql, new DnoteMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public List listAllByPage1(int page, String nick) {
		String sql = "select * from dannote where nick = ? limit ?,?";
		List<Dnote> list = null;
		Object[] params = new Object[] {nick,(page-1)*10,10};
		try {
			list = super.getJdbcTemplate().query(sql, new DnoteMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public Dnote findByNo(String no) {
		String sql = "select * from dannote where no=?";
		List<Dnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new DnoteMapper(), no);
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
		String sql = "select count(id) from dannote";
		try {
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public boolean ddelete(String no) {
		String sql = "delete from dannote where no = ?";
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
	public boolean dupdate(String no, String nick, String title,
			String content, String date) {
		String sql = "update dannote set no = ?, nick = ?, title = ?, content = ?, date = ? where no = ?";
		Object[] params = new Object[]{no,nick,title,content,date,no};
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
	public List<Dnote> listBySql(String sql, Object[] params) {
		List<Dnote> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new DnoteMapper(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

}
