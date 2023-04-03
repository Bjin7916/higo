package com.higo.postFile;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class PostFileDAO {
	
	private SqlSession sqlSession;
	
	public PostFileDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(PostFileVO vo) {
		return sqlSession.insert("postfile.insert", vo);
	}
	
	public List<PostFileVO> selectList(int post_seq){
		return sqlSession.selectList("postfile.selectList", post_seq);
	}
	

}
