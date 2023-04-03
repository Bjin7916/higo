package com.higo.post;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.higo.c_ment.CommentService;

public class PostDAO {
	
	public PostService postService;
	
	public CommentService commentService;
	
	private SqlSession sqlSession;
	
	public PostDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<PostVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("post.selectList", map);
	}
	
	public PostVO selectOne(int post_seq) {
		return sqlSession.selectOne("post.selectOne",post_seq);
	}
	
	public int getTotal(Map<String, Object> map) {
		return sqlSession.selectOne("post.getTotal",map);
	}
	
	public int insert(PostVO vo) {
		return sqlSession.insert("post.insert",vo);
	}
	
	public int updateStep(PostVO vo) {
		return sqlSession.update("post.updateStep",vo);
	}
	
	public int getSeq() {
		return sqlSession.selectOne("post.getSeq");
	}
	
	public int setGroupNum(PostVO vo) {
		return sqlSession.update("post.setGroupno",vo);
	}
	
	public int update(PostVO vo) {
		return sqlSession.update("post.update", vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("post.delete", seq);
	}
	
	public List<PostVO> mPList(int member_seq){
		return sqlSession.selectList("post.mPList", member_seq);
	}
	public int hitCnt(PostVO vo) {
		return sqlSession.update("post.hitCnt", vo);
	}
	
}
