package com.higo.majorSvc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class MajorSvcDAO {
	
	private SqlSession sqlSession;
	
	public MajorSvcDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String, Object>> major(){
		return sqlSession.selectList("gosu.major");
	}
	
	
	
	
	
}
