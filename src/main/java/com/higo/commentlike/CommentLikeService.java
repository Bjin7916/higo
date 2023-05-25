package com.higo.commentlike;

import com.higo.c_ment.CommentDAO;

public class CommentLikeService {
	
	public CommentLikeDAO commentLikeDao;
	public CommentDAO commentDao;
	
	public CommentLikeDAO getCommentLikeDao() {
		return commentLikeDao;
	}
	public void setCommentLikeDao(CommentLikeDAO commentLikeDao) {
		this.commentLikeDao = commentLikeDao;
	}
	public CommentDAO getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDAO commentDao) {
		this.commentDao = commentDao;
	}
	
	public int getSeq() {
		return commentLikeDao.getSeq();
	}
	
	public int insert(CommentLikeVO clvo) {
		return commentLikeDao.insert(clvo);
	}
	
	public CommentLikeVO selectOne(int commentLike_seq) {
		return commentLikeDao.selectOne(commentLike_seq);
	}
	
	public int delete(int commentLike_seq) {
		return commentLikeDao.delete(commentLike_seq);
	}

}
