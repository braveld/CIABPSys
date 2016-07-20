package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.Question;

public interface IQuestionDao {
	
	public boolean addQuestion(Question question);
	
	public List<Question> listAll();
	
	public int count();
	
	public List<Question> listWithA(String qno,String userno);
	
	public boolean updateshowByNo(String no,String isshow);
	
	public boolean delete(String no);
	
	public List<Question> listByS();
	
	public List<Question> listNoW(String qno);
	
	public boolean plusone();

}
