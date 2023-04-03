package com.higo.question;

import java.util.List;

public class QuestionService {
	
	public QuestionDAO questionDao;
	
	public void setQuestionDao(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}
	
	// 질문 내용 가져오기 subSvc_seq 소 카테고리 시퀀스 가져와서 그에 맞는 실문 가져오기
	public List<QuestionVO> questionSelect(int subSvc_seq){
		
		List<QuestionVO> qlist = questionDao.questionSelect(subSvc_seq);
		System.out.println("suv : "+subSvc_seq);
		if(qlist.isEmpty()) {
			System.out.println("qlist: "+ qlist);
			qlist = null;
		}
		
		return qlist;
	}
}
