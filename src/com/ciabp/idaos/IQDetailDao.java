package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.QDetail;
import com.ciabp.models.Question;

public interface IQDetailDao {

	public boolean add(QDetail qDetail);
	
	public List<QDetail> listAll();
	
	public boolean updateIsopen(String no,String isopen);
	
	public int count();
	
	public QDetail findByIsopen();
	
	public List<QDetail> listByUser(String userno);
	
	public List<QDetail> listByPage(int page);
	
	public boolean forbid();
	
	public boolean plusone();
	
	public boolean updateQY(String qno);
	
	public boolean updatename(String name,String qno);
	
}
