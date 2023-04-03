package com.higo.middleSvc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.higo.majorSvc.MajorSvcVO;

public class MiddleSvcDAO {

	private SqlSession sqlSession;
	
	public MiddleSvcDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MiddleSvcVO> middleSvcSelect(int majorSvc_seq) {
		return sqlSession.selectList("request.middleSvcSelect", majorSvc_seq);
	}
	public List<Map<String, Object>> middle(int majorSvc_seq){
		return sqlSession.selectList("gosu.middle", majorSvc_seq);
	}
}
