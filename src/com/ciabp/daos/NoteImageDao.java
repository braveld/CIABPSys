package com.ciabp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


import com.ciabp.idaos.INoteImageDao;

import com.ciabp.models.NoteImage;
import com.ciabp.utils.TimeIdGenerator;





public class NoteImageDao extends JdbcDaoSupport implements INoteImageDao{

	@Override
	public boolean add(NoteImage noteImage) {
		String sql = "insert into noteimage(id,noteid,userno,imageurl,filename,type) values(?,?,?,?,?,?)";
		Object[] params = new Object[] {TimeIdGenerator.generateId(),noteImage.getNoteid(),noteImage.getUserno(),noteImage.getUrl(),noteImage.getFilename(),noteImage.getType()};
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
	
	class NoteImageMapper implements RowMapper<NoteImage>{

		@Override
		public NoteImage mapRow(ResultSet rs, int arg1) throws SQLException {
			NoteImage noteImage = new NoteImage();
			noteImage.setId(rs.getLong("id"));
			noteImage.setNoteid(rs.getString("noteid"));
			noteImage.setUserno(rs.getString("userno"));
			noteImage.setUrl(rs.getString("imageurl"));
			noteImage.setFilename(rs.getString("filename"));
			noteImage.setType(rs.getString("type"));
			return noteImage;
		}
		
	}

	@Override
	public List<NoteImage> listByNoteid(String noteid) {
		String sql = "select * from noteimage where noteid = ?";
		List<NoteImage> list = null;
		try {
			list = super.getJdbcTemplate().query(sql, new NoteImageMapper(),noteid);
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
	public boolean deleteN(String noteid) {
		String sql = "delete from noteimage where noteid = ?";
		try {
			if (super.getJdbcTemplate().update(sql, noteid) > 0) {
				return true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
