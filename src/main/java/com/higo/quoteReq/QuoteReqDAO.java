package com.higo.quoteReq;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.higo.majorSvc.MajorSvcVO;
import com.higo.member.MemberVO;


public class QuoteReqDAO {
	
	private SqlSession sqlSession;
	
	public QuoteReqDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<Map<String,MajorSvcVO>>majorSvcSelect() {
		return sqlSession.selectList("majorSvcSelect");
	}
	
	public int quoteReqVOInsert(QuoteReqVO quoteReqVO) {
		return sqlSession.insert("quoteReqVOInsert", quoteReqVO);
	}
	
	public List<QuoteReqVO> selectQuote(int member_seq){
		return sqlSession.selectList("selectQuote", member_seq);
	}
	
	public List<Map<String, Object>> receiveQuoteRequest(int gosuMainSubSvc_seq){
		return sqlSession.selectList("request.receiveQuoteRequest", gosuMainSubSvc_seq);
	}
	
	public int delectQuoteRequest(int quotereq_seq) {
		return sqlSession.delete("request.delectQuoteRequest", quotereq_seq);
	}
	
	public QuoteReqVO showQuoteRequest(int quoteReq_seq) {
		return sqlSession.selectOne("showQuoteRequest", quoteReq_seq);
	}
	
	public int selectSubSeq(int quotereq_seq){
		return sqlSession.selectOne("request.selectSubSeq", quotereq_seq);
	}
	// quotereq에 status 값 변경
	public int statusUpdate(int quoteReq_seq) {
		return sqlSession.update("request.statusUpdate", quoteReq_seq);
	}
	public String majorSvcVO(int majorSvc_seq) {
		return sqlSession.selectOne("request.majorSvcVO", majorSvc_seq);
	}
	public String svcName(int gosuMS_seq) {
		return sqlSession.selectOne("svcName", gosuMS_seq);
	}
	
	
}
