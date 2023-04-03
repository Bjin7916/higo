package com.higo.myQuoteadd;

import java.util.List;
import java.util.Map;

public class MyQuoteAddService {
	
	private MyQuoteAddDAO myQuoteAddDao;
	
	public void setMyQuoteAddDao(MyQuoteAddDAO myQuoteAddDao) {
		this.myQuoteAddDao = myQuoteAddDao;
	}
	
	public List<Map<String, Object>> selectAddQuote(){
		
		List<Map<String, Object>> list = null;
		
		try {
			list = myQuoteAddDao.selectAddQuote();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public MyQuoteAddVO selectAddQuoteSeq(int myQuote_seq) {
		
		MyQuoteAddVO vo = null;
		try {
			vo = myQuoteAddDao.selectAddQuoteSeq(myQuote_seq);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

}
