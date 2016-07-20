package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.Question;
import com.ciabp.models.Questionaire;

public interface IQuestionaireDao {
	
	public boolean add(Questionaire questionaire);
	
	public List<Questionaire> listAll();
	
	public boolean delete(String qno,String no);
	
	public List<Question> listByNo(String no);
	
	public int count();
	
	public int count(String qno);
	
	public boolean updatetihao(String qno,String no,String tihao);
}
