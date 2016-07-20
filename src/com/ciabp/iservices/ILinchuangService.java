package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.Linchuang;
import com.ciabp.models.PageVO;

public interface ILinchuangService {

	public boolean tadd(Linchuang linchuang);
	
	public PageVO tlistByUser(String userno,int page);
	
	public boolean tdeleteL(String id);
}
