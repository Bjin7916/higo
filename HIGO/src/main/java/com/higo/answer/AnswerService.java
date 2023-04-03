package com.higo.answer;

import java.util.List;

public class AnswerService {
	
	public AnswerDAO answerDao;
	
	public void setAnswerDao(AnswerDAO answerDao) {
		this.answerDao = answerDao;
	}
	
	public List<AnswerVO> answerSelect(){
		
		
		List<AnswerVO> alist = answerDao.answerSelect();
		
		if(alist.isEmpty()) {
			System.out.println(alist);
			alist = null;
		}
		
		return alist;
	}
}
