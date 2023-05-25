package com.higo.local;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.higo.metro.MetroVO;

public class LocalDAO {
	
	private SqlSession sqlSession;
	
	public LocalDAO(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	public List<Map<String,Object>> localList(int seq){
		return sqlSession.selectList("local.localList", seq);
	}
	
	public List<Map<String,MetroVO>> metroList(){
		return sqlSession.selectList("local.metroList");
	}
	
	public List<Map<String,Object>> localMainSvc(Map<String,Object> map){
		return sqlSession.selectList("local.localMainSvc", map);
	}
}
