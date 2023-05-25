package com.higo.c_ment;

import java.util.List;

import com.higo.post.PostDAO;

public class CommentService {
	
	public CommentDAO commentDao;
	
	public PostDAO postDao;

	public CommentDAO getCommentDao() {
		return commentDao;
	}

	public PostDAO getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDAO postDao) {
		this.postDao = postDao;
	}

	public void setCommentDao(CommentDAO commentDao) {
		this.commentDao = commentDao;
	}

	public int insert(CommentVO cvo) {
		if(cvo.getComm_groupNum() != 0) {
			commentDao.updateStep(cvo);
		}
		int check = commentDao.insert(cvo);
				
		return check;
	}
	
	public List<CommentVO> commentList(int post_seq){
		List<CommentVO> list = commentDao.commentList(post_seq);
		
		if(list.isEmpty()) {
			list = null;
		}
		
		return list;
	}
	
	public CommentVO selectOne(int comm_seq) {
		return commentDao.selectOne(comm_seq);
	}
	
	public int getSeq() {
		return commentDao.getSeq();
	}
	
	public int update(CommentVO cvo) {
		return commentDao.update(cvo);
	}
	
	public int delete(int comm_seq) {
		return commentDao.delete(comm_seq);
	}
	
}
