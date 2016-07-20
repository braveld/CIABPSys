package com.ciabp.iservices;

import java.text.ParseException;
import java.util.List;

import com.ciabp.models.PageVO;

import com.ciabp.models.Dnote;

public interface IDnoteService {
	
	public boolean tdoaddNote(Dnote dnote);
	
	public List<Dnote> tlistByNo(String no);

	public PageVO tlistAllByPage(int page,String nick);
	public PageVO tlistAllByPage(int page);
	public PageVO tlistAllByPage1(int page,String nick);
	public Dnote tfindByNo(String no);
	public boolean tdoddelete(String no);
	public boolean tdodupdate(String no,String nick,String title,String content,String date);
	public PageVO dlistBySql(String sql,Object[] params);

}
