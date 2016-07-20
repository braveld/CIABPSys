package com.ciabp.services;

import java.util.Date;
import java.util.List;

import com.ciabp.daos.QuestionDao;
import com.ciabp.idaos.IQuestionDao;
import com.ciabp.iservices.IQuestionService;
import com.ciabp.models.Question;

public class QuestionService extends ServiceBase implements IQuestionService{
	
	private IQuestionDao questionDao;
	
	public IQuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(IQuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	
	@Override
	public List<Question> tlistAll() {
		return questionDao.listAll();
	}

	@Override
	public boolean tdoaddQuestion(Question question) {
		int count = questionDao.count()+1;
		question.setDate(new Date());
		question.setNo(String.format("QD%05d",count));
		question.setIsshow("不显示");
		questionDao.plusone();
		return questionDao.addQuestion(question);
	}

	@Override
	public List<Question> tlistWithA(String qno, String userno) {
		return questionDao.listWithA(qno, userno);
	}

	@Override
	public boolean tdoupdateByNo(String no, String isshow) {
		return questionDao.updateshowByNo(no, isshow);
	}

	@Override
	public boolean tdodelete(String no) {
		return questionDao.delete(no);
	}

	@Override
	public List<Question> tlistByS() {
		return questionDao.listByS();
	}

	@Override
	public List<Question> tlistNOW(String qno) {
		return questionDao.listNoW(qno);
	}

}
