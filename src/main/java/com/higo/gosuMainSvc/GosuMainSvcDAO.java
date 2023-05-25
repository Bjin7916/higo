package com.higo.gosuMainSvc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GosuMainSvcDAO {
	
	private SqlSession sqlSession;
	
	public GosuMainSvcDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public GosuMainSvcVO selectGosuMS(int gosuMS_seq) {
		return sqlSession.selectOne("gosu.selectGosuMS", gosuMS_seq);
	}
	
	public GosuMainSvcVO selectSMM(int gosu_seq) {
		return sqlSession.selectOne("gosu.selectSMM", gosu_seq);
	}
}
