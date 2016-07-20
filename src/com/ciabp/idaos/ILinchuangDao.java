package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.Linchuang;

public interface ILinchuangDao {

	public boolean add(Linchuang linchuang);
	
	public List<Linchuang> listByUser(String userno,int page);
	
	public List<Linchuang> listAll();
	
	public boolean deleteL(String id);
}
