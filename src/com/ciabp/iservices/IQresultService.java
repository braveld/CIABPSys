package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.Qresult;

public interface IQresultService {

	public boolean tadd(Qresult qresult);
	
	public List<Qresult> tlistBySql(String sql,Object[] params);
	
	public boolean tdelete(String qno,String questionno,String xuanxiang);
	
	public boolean tminus(String qno,String questionno,String xuanxiang);
	
	public boolean tadds(String qno,String questionno,String xuanxiang);
}
