package com.higo.community;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.higo.community.CommunityVO;

public class CommunityDAO {
	public CommunityService communityService;
	
	private SqlSession sqlSession;
	
	public CommunityDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<CommunityVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("community.selectList", map);
	}
	
	public int getTotal(Map<String, Object> map) {
		return sqlSession.selectOne("community.getTotal",map);
	}
	

}
