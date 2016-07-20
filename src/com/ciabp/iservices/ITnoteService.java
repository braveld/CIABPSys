package com.ciabp.iservices;

import java.text.ParseException;
import java.util.List;

import com.ciabp.models.PageVO;

import com.ciabp.models.Tnote;

public interface ITnoteService {
	public boolean tdoaddNote(Tnote tnote);
	
	public List<Tnote> tlistByNo(String no);

	public PageVO tlistAllByPage(int page,String nick);
	public PageVO tlistAllByPage(int page);
	public PageVO tlistAllByPage1(int page,String nick);
	public Tnote tfindByNo(String no);
	public boolean tdotdelete(String no);
	public boolean tdotupdate(String nick,String date,String content,String no,String title);
	public PageVO tlistBySql(String sql,Object[] params);
}
