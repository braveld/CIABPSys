package com.ciabp.iservices;

import java.util.List;

import com.ciabp.models.Question;
import com.ciabp.models.Questionaire;

public interface IQuestionaireService {

	public List<Questionaire> tlistAllQ();
	
	public boolean tdoadd(Questionaire questionaire);
	
	public boolean tdodelete(String qno,String no);
	
	public List<Question> tlistByNo(String no);
	
	public List<Question> tlistByUser(String userno,String no);
	
	public boolean tupdatetihao(String no,String[] nos,String[] tihaos);
}
