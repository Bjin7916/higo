package com.higo.quoteReq;

import java.util.List;
import java.util.Map;

import com.higo.majorSvc.MajorSvcVO;



public class QuoteReqService {

	private QuoteReqDAO quoteReqDao;
	
	public void setQuoteReqDao(QuoteReqDAO quoteReqDao) {
		this.quoteReqDao = quoteReqDao;
	}
	
	public List<Map<String,MajorSvcVO>> majorSvcSelect() {
		return quoteReqDao.majorSvcSelect();
	}
	public int quoteReqVOInsert(QuoteReqVO quoteReqVO) {
		return quoteReqDao.quoteReqVOInsert(quoteReqVO);
	}
	
	public List<QuoteReqVO> selectQuote(int member_seq){
		return quoteReqDao.selectQuote(member_seq);
	}
	
	public List<Map<String, Object>> receiveQuoteRequest(int gosuMainSubSvc_seq){
		return quoteReqDao.receiveQuoteRequest(gosuMainSubSvc_seq);
	}
	
	public int delectQuoteRequest(int quotereq_seq) {
		return quoteReqDao.delectQuoteRequest(quotereq_seq);
	}
	
	public QuoteReqVO showQuoteRequest (int quotereq_seq) {
		return quoteReqDao.showQuoteRequest(quotereq_seq);
	}
	
	public int selectSubSeq(int quotereq_seq){
		
		int su = 0;
		
		try {
			su = quoteReqDao.selectSubSeq(quotereq_seq);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return su;
	}
	
	public int statusUpdate(int quoteReq_seq) {
		return quoteReqDao.statusUpdate(quoteReq_seq);
	}
	public String majorSvcVO(int majorSvc_seq) {
		return quoteReqDao.majorSvcVO(majorSvc_seq);
	}
	public String svcName(int gosuMS_seq) {
		return quoteReqDao.svcName(gosuMS_seq);
	}
	
}
