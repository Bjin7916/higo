package com.higo.commentlike;

import org.apache.ibatis.session.SqlSession;

import com.higo.c_ment.CommentService;

public class CommentLikeDAO {
	
	public CommentLikeService commentLikeService;
	
	public CommentService commentService;
	
	private SqlSession sqlSession;
	
	public CommentLikeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getSeq() {
		return sqlSession.selectOne("like.getCommentseq");
	}
	
	public int insert(CommentLikeVO clvo) {
		return sqlSession.insert("like.createCommentlike", clvo);
	}
	
	public CommentLikeVO selectOne(int commentLike_seq) {
		return sqlSession.selectOne("like.readCommentlike", commentLike_seq);
	}
	
	public int delete(int commentLike_seq) {
		return sqlSession.delete("like.deleteCommentlike", commentLike_seq);
	}

}
