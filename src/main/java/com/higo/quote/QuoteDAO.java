package com.higo.quote;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.higo.myQuoteadd.MyQuoteAddVO;

public class QuoteDAO {

	private SqlSession sqlSession;
	
	public QuoteDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int optionQuote(QuoteVO vo) {
		return sqlSession.insert("quote.optionQuote", vo);
	}
	
	public List<Map<String, Object>> selectQuote(int member_seq){
		return sqlSession.selectList("quote.selectQuote", member_seq);
	}
	
	// 내 견적서에 추가
	public int insertMyQuoteAdd(MyQuoteAddVO mqavo) {
		return sqlSession.insert("quote.insertMyQuoteAdd", mqavo);
	}
	
	// 견적서 삭제
	public int quoteDelete(int quote_seq) {
		return sqlSession.delete("quote.quoteDelete", quote_seq);
	}
	
	//quote status 값 변경
	public int updateQuote(int quote_seq) {
		return sqlSession.update("quote.updateQuote", quote_seq);
	}
}
