package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ciabp.daos.NoteImageDao.NoteImageMapper;
import com.ciabp.idaos.ILinchuangDao;
import com.ciabp.idaos.INoteDao;
import com.ciabp.models.Linchuang;
import com.ciabp.utils.TimeIdGenerator;

public class LinchuangDao extends JdbcDaoSupport implements ILinchuangDao{

	@Override
	public boolean add(Linchuang linchuang) {
		String sql = "insert into linchuang(id,hospital,doctor,date,imageurl,userno,filename,type) values(?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),linchuang.getHospital(),linchuang.getDoctor(),linchuang.getDate(),linchuang.getImageurl(),linchuang.getUserno(),linchuang.getFilename(),linchuang.getType()};
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

	class LinchuangM implements RowMapper<Linchuang>{

		@Override
		public Linchuang mapRow(ResultSet rs, int arg1) throws SQLException {
			Linchuang linchuang = new Linchuang();
			linchuang.setId(rs.getLong("id"));
			linchuang.setHospital(rs.getString("hospital"));
			linchuang.setDoctor(rs.getString("doctor"));
			linchuang.setDate(rs.getDate("date"));
			linchuang.setImageurl(rs.getString("imageurl"));
			linchuang.setUserno(rs.getString("userno"));
			linchuang.setFilename(rs.getString("filename"));
			linchuang.setType(rs.getString("type"));
			return linchuang;
		}
		
	}
	
	@Override
	public List<Linchuang> listByUser(String userno,int page) {
		String sql = "select * from linchuang where userno = ? limit ?,?";
		List<Linchuang> list = null;
		Object[] params = new Object[]{userno,(page-1)*10,10};
		try {
			list = super.getJdbcTemplate().query(sql, new LinchuangM(),params);
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
	public List<Linchuang> listAll() {
		String sql = "select * from linchuang";
		List<Linchuang> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new LinchuangM());
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
	public boolean deleteL(String id) {
		String sql = "delete from linchuang where id = ?";
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
