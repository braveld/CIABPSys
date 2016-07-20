package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.PageVO;
import com.ciabp.models.QDetail;

public interface IQDetailService {
	
	public List<QDetail> tlistAll();
	
	public boolean tdoaddQD(QDetail qDetail);
	
	public boolean tdoupdateIsopen(String openno);
	
	public QDetail tfindByIsopen();
	
	public List<QDetail> tlistByUser(String userno);
	
	public PageVO tlistByPage(int page);
	
	public boolean tforbid();
	
	public boolean tupdateQY(String qno);
	
	public boolean tupdatename(String name,String qno);

}
