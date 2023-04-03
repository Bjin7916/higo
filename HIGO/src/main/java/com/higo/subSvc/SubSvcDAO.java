package com.higo.subSvc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SubSvcDAO {
	
	private SqlSession sqlSession;
	
	public SubSvcDAO (SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<SubSvcVO> subSvcSelect(int majorSvc_seq){
		return sqlSession.selectList("request.subSvcSelect", majorSvc_seq);
	}
	
	public SubSvcVO subSvcSelectVO(int subSvc_seq) {
		return sqlSession.selectOne("subSvcSelectVO", subSvc_seq);
	}
	
	public String selectSubName(int subSvc_seq) {
		return sqlSession.selectOne("quote.selectSubName", subSvc_seq);
	}
	public List<Map<String, Object>> sub(int middleSvc_seq){
		return sqlSession.selectList("gosu.sub", middleSvc_seq);
	}
	
	public List<Map<String, Object>> subSvcAll(){
		return sqlSession.selectList("request.subSvcAll");
	}
	
	
}
