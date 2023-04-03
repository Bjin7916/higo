package com.higo.quote;

import java.util.List;
import java.util.Map;

import com.higo.myQuoteadd.MyQuoteAddVO;

public class QuoteService {
	
	private QuoteDAO quoteDao;
	
	public void setQuoteDao(QuoteDAO quoteDao) {
		this.quoteDao = quoteDao;
	}
	
	public int optionQuote(QuoteVO vo) {
		return quoteDao.optionQuote(vo);
	}
	
	public List<Map<String, Object>> selectQuote(int member_seq){
		List<Map<String, Object>> list = null;
		try {
			list = quoteDao.selectQuote(member_seq);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	// 내 견적서에 추가
	public int insertMyQuoteAdd(MyQuoteAddVO mqavo) {
		return quoteDao.insertMyQuoteAdd(mqavo);
	}
	
	// 견적서 삭제
	public int quoteDelete(int quote_seq) {
		return quoteDao.quoteDelete(quote_seq);
	}
	
	//quote status 값 변경
	public int updateQuote(int quote_seq) {
		return quoteDao.updateQuote(quote_seq);
	}

}
