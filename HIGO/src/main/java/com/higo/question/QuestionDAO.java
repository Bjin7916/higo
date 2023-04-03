package com.higo.question;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class QuestionDAO {
	
	private SqlSession sqlSession;
	
	public QuestionDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<QuestionVO> questionSelect(int subSvc_seq){
		return sqlSession.selectList("questionSelect", subSvc_seq);
	}
}
