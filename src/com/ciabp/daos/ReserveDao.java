package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.ReserveDao.ReserveMapper;
import com.ciabp.idaos.IReserveDao;
import com.ciabp.models.Reserve;
import com.ciabp.utils.TimeIdGenerator;


public class ReserveDao extends JdbcDaoSupport implements IReserveDao {
	@Override
	public boolean add(Reserve reserve) {
		String sql = "insert into reserve(id,name,no,address,phone,idno,date,zhuangtai,result,filename) values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),reserve.getName(),reserve.getNo(),reserve.getAddress(),reserve.getPhone(),reserve.getIdno(),reserve.getDate(),reserve.getStatus(),reserve.getResult(),reserve.getFilename()};
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
	class ReserveMapper implements RowMapper<Reserve>{

		@Override
		public Reserve mapRow(ResultSet rs, int arg1) throws SQLException {
			Reserve reserve = new Reserve();
			reserve.setId(rs.getLong("id"));
			reserve.setName(rs.getString("name"));
			reserve.setNo(rs.getString("no"));
			reserve.setAddress(rs.getString("address"));
			reserve.setPhone(rs.getString("phone"));
			reserve.setIdno(rs.getString("idno"));
			reserve.setDate(rs.getDate("date"));
			reserve.setStatus(rs.getString("zhuangtai"));
			reserve.setResult(rs.getString("result"));
			reserve.setFilename(rs.getString("filename"));
			return reserve;
		}
		
	}
	@Override
	public List<Reserve> listAll() {
		String sql = "select * from reserve";
		List<Reserve> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new ReserveMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}
	@Override
	public Reserve findByNo(String no) {
		String sql = "select * from reserve where no = ?";
		List<Reserve> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new ReserveMapper(),no);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}
	@Override
	public boolean updateStatus(String no, String status) {
		String sql = "update reserve set zhuangtai = ? where no = ?";
		Object[] params = new Object[] {status,no};
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
	public List<Reserve> listByStatus(String status) {
		String sql = "select * from reserve where zhuangtai = ?";
		List<Reserve> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new ReserveMapper(),status);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list;
	}
	@Override
	public boolean updateurl(String url, String no,String filename) {
		String sql = "update reserve set result = ?,filename = ? where no = ?";
		Object[] params = new Object[] {url,filename,no};
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
