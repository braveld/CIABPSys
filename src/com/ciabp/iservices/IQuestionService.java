package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.Question;

public interface IQuestionService {
	
	public boolean tdoaddQuestion(Question question);
	
	public List<Question> tlistAll();
	
	public List<Question> tlistWithA(String qno,String userno);
	
	public boolean tdoupdateByNo(String no,String isshow);
	
	public boolean tdodelete(String no);
	
	public List<Question> tlistByS();
	
	public List<Question> tlistNOW(String qno);
}
