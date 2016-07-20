package com.ciabp.idaos;

import java.text.ParseException;
import java.util.List;

import com.ciabp.models.Dnote;;


public interface IDnoteDao {
	
	public boolean add(Dnote dnote);
	
	public List<Dnote> listByNo(String no);

	public List<Dnote> listAllByNick(String nick);
	public List<Dnote> listAll();
	public List listAllByPage(int page);
	public List listAllByPage1(int page,String nick);

	public Dnote findByNo(String no);
	public int count();
	public boolean ddelete(String no);
	public boolean dupdate(String no,String nick,String title,String content,String date);
	public List<Dnote> listBySql(String sql,Object[] params);
}
