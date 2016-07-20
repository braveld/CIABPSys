package com.ciabp.services;

import java.util.List;



import com.ciabp.idaos.IAnswerDao;
import com.ciabp.idaos.IQuestionaireDao;
import com.ciabp.iservices.IQuestionaireService;
import com.ciabp.models.Answer;
import com.ciabp.models.Question;
import com.ciabp.models.Questionaire;

public class QuestionaireService extends ServiceBase implements IQuestionaireService{

	private IQuestionaireDao questionaireDao;
	private IAnswerDao answerDao;
	
	
	public IAnswerDao getAnswerDao() {
		return answerDao;
	}
	public void setAnswerDao(IAnswerDao answerDao) {
		this.answerDao = answerDao;
	}
	public IQuestionaireDao getQuestionaireDao() {
		return questionaireDao;
	}
	public void setQuestionaireDao(IQuestionaireDao questionaireDao) {
		this.questionaireDao = questionaireDao;
	}
	
	@Override
	public List<Questionaire> tlistAllQ() {
		return questionaireDao.listAll();
	}
	
	@Override
	public boolean tdoadd(Questionaire questionaire) {
		return questionaireDao.add(questionaire);
	}

	@Override
	public boolean tdodelete(String qno, String no) {
		return questionaireDao.delete(qno, no);
	}

	@Override
	public List<Question> tlistByNo(String no) {
		return questionaireDao.listByNo(no);
	}



	@Override
	public List<Question> tlistByUser(String userno, String no) {
		List<Question> list = questionaireDao.listByNo(no);
		List<Answer> l = answerDao.listByUser(userno, no);
		System.out.println(list.size()+","+l.size());
		for(int i = 0;i < list.size();i++){
			for(int j = 0;j < l.size();j++){
				if(list.get(i).getNo().equals(l.get(j).getQno())){
					list.get(i).setAnswer(l.get(j).getAnswer());
				}
			}
		}
		return list;
	}
	@Override
	public boolean tupdatetihao(String no, String[] nos, String[] tihaos) {
		for(int i = 1;i <nos.length;i++){
			if(!questionaireDao.updatetihao(nos[i], no, tihaos[i])){
				return false;
			}
		}
		return true;
	}

}
