package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.QDetailDao.QDetailMapper;
import com.ciabp.idaos.IQDetailDao;
import com.ciabp.models.QDetail;
import com.ciabp.utils.TimeIdGenerator;

public class QDetailDao extends JdbcDaoSupport implements IQDetailDao{

	@Override
	public boolean add(QDetail qDetail) {
		String sql = "insert into qdetail(id,no,isopen,date,name,isqiyong) values(?,?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),qDetail.getNo(),qDetail.getIsopen(),qDetail.getDate(),qDetail.getName(),"未启用"};
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

	class QDetailMapper implements RowMapper<QDetail>{

		@Override
		public QDetail mapRow(ResultSet rs, int arg1) throws SQLException {
			QDetail qDetail = new QDetail();
			qDetail.setId(rs.getLong("id"));
			qDetail.setNo(rs.getString("no"));
			qDetail.setIsopen(rs.getString("isopen"));
			qDetail.setDate(rs.getDate("date"));
			qDetail.setName(rs.getString("name"));
			qDetail.setIsqiyong(rs.getString("isqiyong"));
			return qDetail;
		}
		
	}
	
	
	@Override
	public List<QDetail> listAll() {
		String sql = "select * from qdetail";
		List<QDetail> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QDetailMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public boolean updateIsopen(String no, String isopen) {
		String sql = "update qdetail set isopen = ? where no = ? ";
		Object[] params = new Object[] {isopen,no};
		try {
			if (super.getJdbcTemplate().update(sql, params) >= 0) {
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
			int count = super.getJdbcTemplate().queryForObject(sql,Integer.class,"questionaire");
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public QDetail findByIsopen() {
		String sql = "select * from qdetail where isopen = ?";
		List<QDetail> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QDetailMapper(),"启用");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

	@Override
	public List<QDetail> listByUser(String userno) {
		String sql = "select * from qdetail where no in (select qno from writeqstatus where userno = ?)";
		List<QDetail> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QDetailMapper(),userno);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public List<QDetail> listByPage(int page) {
		String sql = "select * from qdetail limit ?,?";
		Object[] params = new Object[]{(page-1)*10,10};
		List<QDetail> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QDetailMapper(),params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public boolean forbid() {
		String sql = "update qdetail set isopen = ? where isopen = ?";
		Object[] params = new Object[] {"未启用","启用"};
		try {
			if (super.getJdbcTemplate().update(sql, params) >= 0) {
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
		Object[] params = new Object[] {"questionaire"};
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
	public boolean updateQY(String qno) {
		String sql = "update qdetail set isqiyong = ? where no = ?";
		Object[] params = new Object[] {"启用",qno};
		try {
			if (super.getJdbcTemplate().update(sql, params) >= 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean updatename(String name, String qno) {
		String sql = "update qdetail set name = ? where no = ?";
		Object[] params = new Object[] {name,qno};
		try {
			if (super.getJdbcTemplate().update(sql, params) >= 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
