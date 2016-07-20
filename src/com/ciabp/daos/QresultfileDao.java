package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.LinchuangDao.LinchuangM;
import com.ciabp.idaos.IQresultfileDao;
import com.ciabp.models.Linchuang;
import com.ciabp.models.Qresultfile;
import com.ciabp.utils.TimeIdGenerator;

public class QresultfileDao extends JdbcDaoSupport implements IQresultfileDao {

	@Override
	public boolean add(Qresultfile qresultfile) {
		String sql = "insert into resultfile(id,date,qname,url,filename) values(?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),qresultfile.getDate(),qresultfile.getQname(),qresultfile.getUrl(),qresultfile.getFilename()};
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
	
	class QresultfileM implements RowMapper<Qresultfile>{

		@Override
		public Qresultfile mapRow(ResultSet rs, int arg1) throws SQLException {
			Qresultfile qresultfile = new Qresultfile();
			qresultfile.setId(rs.getLong("id"));
			qresultfile.setDate(rs.getDate("date"));
			qresultfile.setQname(rs.getString("qname"));
			qresultfile.setUrl(rs.getString("url"));
			qresultfile.setFilename(rs.getString("filename"));
			return qresultfile;
		}
		
	}

	@Override
	public List<Qresultfile> listQr() {
		String sql = "select * from resultfile";
		List<Qresultfile> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QresultfileM());
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
	public boolean delete(long id) {
		String sql = "delete from resultfile where id = ?";
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
