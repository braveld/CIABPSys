package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.Reserve;;

public interface IReserveDao {
	
	/**
	 * 预约检测
	 * @param reserve
	 * @return
	 */
	public boolean add(Reserve reserve);
	
	public List<Reserve> listAll();
	
	public Reserve findByNo(String no);
	
	public boolean updateStatus(String no,String status);
	
	public List<Reserve> listByStatus(String status);
	
	public boolean updateurl(String url,String no,String filename);
}
