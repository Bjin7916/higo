package com.higo.myQuoteadd;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class MyQuoteAddDAO {
	
	private SqlSession sqlSession;
	
	public MyQuoteAddDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String, Object>> selectAddQuote(){
		return sqlSession.selectList("quote.selectAddQuote");
	}
	
	public MyQuoteAddVO selectAddQuoteSeq(int myQuote_seq) {
		return sqlSession.selectOne("quote.selectAddQuoteSeq", myQuote_seq);
	}
	
}
