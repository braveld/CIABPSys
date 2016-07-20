package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.Answer;;

public interface IAnswerDao {
	public boolean add(Answer answer);
	
	public Answer findByNo(String no,String user);
	
	public List<Answer> listByUser(String userno,String no);
	
	public boolean deleteByNo(String no,String qno);
	
	public boolean deleteByUser(String userno);
	
	
}
