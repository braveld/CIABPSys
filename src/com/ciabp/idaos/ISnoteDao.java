package com.ciabp.idaos;

import java.text.ParseException;
import java.util.List;

import com.ciabp.models.Snote;
import com.ciabp.models.User;

public interface ISnoteDao {
	public boolean add(Snote snote);
	
	public List<Snote> listByNo(String no);

	public List<Snote> listAll();

	public List listAllByPage(int page);

	public Snote findByNo(String no);
	public int count();
	public boolean sdelete(String no);
}
