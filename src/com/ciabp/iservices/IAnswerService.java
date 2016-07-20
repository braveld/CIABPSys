package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.Answer;;

public interface IAnswerService {
	public boolean tdoadd(Answer answer);
	
	public Answer tfindByNo(String no, String user);
	
	public boolean tdeleteByNo(String no,String qno);
	
	public List<Answer> tlistByUser(String no,String userno);
	
	public boolean tdeleteByUser(String userno);
}
