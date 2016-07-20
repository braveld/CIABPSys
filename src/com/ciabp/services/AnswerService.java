package com.ciabp.services;

import java.util.List;

import com.ciabp.idaos.IAnswerDao;
import com.ciabp.iservices.IAnswerService;
import com.ciabp.models.Answer;



public class AnswerService extends ServiceBase implements IAnswerService{
	private IAnswerDao answerDao;
	
	public IAnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(IAnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	@Override
	public boolean tdoadd(Answer answer) {
		return answerDao.add(answer);
	}

	@Override
	public Answer tfindByNo(String no, String user) {
		return answerDao.findByNo(no, user);
	}

	@Override
	public boolean tdeleteByNo(String no, String qno) {
		return answerDao.deleteByNo(no, qno);
	}

	@Override
	public List<Answer> tlistByUser(String no, String userno) {
		return answerDao.listByUser(userno,no);
	}

	@Override
	public boolean tdeleteByUser(String userno) {
		return answerDao.deleteByUser(userno);
	}

}
