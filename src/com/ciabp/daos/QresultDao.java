package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.AdminDao.AdminMapper;
import com.ciabp.idaos.IAdminDao;
import com.ciabp.idaos.IQreslutDao;
import com.ciabp.models.Qresult;
import com.ciabp.utils.TimeIdGenerator;

public class QresultDao extends JdbcDaoSupport implements IQreslutDao{

	@Override
	public boolean add(Qresult qresult) {
		String sql = "insert into qresult(id,qno,questionno,result,xuanxiang) values(?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),qresult.getQno(),qresult.getQuestionno(),qresult.getResult(),qresult.getXuanxiang().trim()};
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
	public List<Qresult> listByQ(String qno, String questionno) {
		String sql = "select * from qresult where qno = ? and questionno = ?";
		Object[] params = new Object[]{qno,questionno};
		List<Qresult> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QresultM(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

	@Override
	public List<Qresult> listBySql(String sql, Object[] params) {
		List<Qresult> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new QresultM(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}
	
	class QresultM implements RowMapper<Qresult>{

		@Override
		public Qresult mapRow(ResultSet rs, int arg1) throws SQLException {
			Qresult qresult = new Qresult();
			qresult.setId(rs.getLong("id"));
			qresult.setQno(rs.getString("qno"));
			qresult.setQuestionno(rs.getString("questionno"));
			qresult.setXuanxiang(rs.getString("xuanxiang"));
			qresult.setResult(rs.getInt("result"));
			return qresult;
		}
		
	}

	@Override
	public boolean delete(String qno, String questionno, String xuanxiang) {
		String sql = "delete from qresult where qno = ? and questionno = ? and xuanxiang = ?";
		Object[] params = new Object[] {qno,questionno,xuanxiang};
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
	public boolean update(String qno, String questionno, String xuanxiang) {
		String sql = "update qresult set result = if(result < 1,0,result-1) where qno = ? and questionno = ? and xuanxiang = ?";
		Object[] params = new Object[] {qno,questionno,xuanxiang.trim()};
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
	public boolean adds(String qno, String questionno, String xuanxiang) {
		String sql = "update qresult set result = result+1 where qno = ? and questionno = ? and xuanxiang = ?";
		Object[] params = new Object[] {qno,questionno,xuanxiang.trim()};
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
