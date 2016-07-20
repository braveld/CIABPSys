package com.ciabp.iservices;

import java.util.List;


import com.ciabp.models.Reserve;

public interface IReserveService {
	
	public List<Reserve> tlistAll();
	
	public boolean tdoaddReserve(Reserve reserve);
	
	public boolean tdoupdateStatus(String no,String status);
	
	public Reserve tfindByNo(String no);
	
	public List<Reserve> tlistByStatus(String status);
	
	public boolean tupdateresult(String url,String no,String filename);
}
