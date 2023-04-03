package com.higo.answer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class AnswerDAO {
	
	private SqlSession sqlSession;
	
	public AnswerDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<AnswerVO> answerSelect(){
		return sqlSession.selectList("request.answerSelect");
	}

}
