package com.ciabp.idaos;

import java.text.ParseException;
import java.util.List;

import com.ciabp.models.Tnote;


public interface ITnoteDao {
	
	public boolean add(Tnote tnote);
	
	public List<Tnote> listByNo(String no);

	public List<Tnote> listAllByNick(String nick);
	public List<Tnote> listAll();
	public List listAllByPage(int page);
	public List listAllByPage1(int page,String nick);

	public Tnote findByNo(String no);
	public int count();
	public boolean tdelete(String no);
	public boolean tupdate(String nick,String date,String content,String no,String title);
	public List<Tnote> listBySql(String sql,Object[] params);
}
