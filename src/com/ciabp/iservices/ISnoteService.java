package com.ciabp.iservices;

import java.text.ParseException;
import java.util.List;

import com.ciabp.models.PageVO;
import com.ciabp.models.Snote;

public interface ISnoteService {
	public boolean tdoaddNote(Snote snote);
	
	public List<Snote> tlistByNo(String no);

	public PageVO tlistAllByPage(int page);

	public Snote tfindByNo(String no);
	public boolean tdosdelete(String no);
}
