package com.higo.c_ment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.higo.post.PostVO;


public class CommentDAO {
	
	public CommentService commentService;
	
	private SqlSession sqlSession;

	public CommentDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(CommentVO cvo) {
		return sqlSession.insert("comment.writeComment",cvo);
	}
	
	public List<CommentVO> commentList(int post_seq) {
		return sqlSession.selectList("comment.commentList", post_seq);
	}
	
	public CommentVO selectOne(int comm_seq) {
		return sqlSession.selectOne("comment.selectOne", comm_seq);
	}
	
	public int update(CommentVO cvo) {
		return sqlSession.update("comment.update", cvo);
	}
	
	public int delete(int comm_seq) {
		return sqlSession.delete("comment.delete", comm_seq);
	}

	public int updateStep(CommentVO cvo) {
		return sqlSession.update("comment.updateStep",cvo);
	}

	public int getSeq() {
		return sqlSession.selectOne("comment.getSeq");

	}
	
	public int setGroupNum(CommentVO cvo) {
		return sqlSession.update("comment.setGroupNum",cvo);
	}

}


