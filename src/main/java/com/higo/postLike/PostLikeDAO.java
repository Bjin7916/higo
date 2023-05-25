package com.higo.postLike;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.higo.post.PostService;
import com.higo.post.PostVO;

public class PostLikeDAO {
	
	public PostLikeService postlikeService;
	
	public PostService postService;
	
	private SqlSession sqlSession;
	
	public PostLikeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getSeq() {
		return sqlSession.selectOne("like.getPostseq");
	}
	
	public int insert(PostLikeVO plvo) {
		return sqlSession.insert("like.createPostlike", plvo);
	}
	
	public PostLikeVO selectOne(PostLikeVO plvo) {
		return sqlSession.selectOne("like.readPostlike", plvo);
	}
	
	public PostLikeVO select(PostLikeVO plvo) {
		return sqlSession.selectOne("like.checkPostlike", plvo);
	}
	
	public int delete(PostLikeVO plvo) {
		return sqlSession.delete("like.deletePostlike", plvo);
	}
	
	public int likeCheck(Map<String, Integer> map) {
		return sqlSession.selectOne("like.likeCheck", map);
	}
	
	

}
