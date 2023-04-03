package com.higo.postLike;

import java.util.Map;

import com.higo.post.PostDAO;

public class PostLikeService {

	public PostLikeDAO postLikeDao;
	public PostDAO postDao;
	
	public PostLikeDAO getPostLikeDao() {
		return postLikeDao;
	}
	public void setPostLikeDao(PostLikeDAO postLikeDao) {
		this.postLikeDao = postLikeDao;
	}
	public PostDAO getPostDao() {
		return postDao;
	}
	public void setPostDao(PostDAO postDao) {
		this.postDao = postDao;
	}
	
	public int getSeq() {
		return postLikeDao.getSeq();
	}
	
	public int insert(PostLikeVO plvo) {
		return postLikeDao.insert(plvo);
	}
	
	public PostLikeVO selectOne(PostLikeVO plvo) {
		return postLikeDao.selectOne(plvo);
	}
	
	public PostLikeVO select(PostLikeVO plvo) {
		return postLikeDao.select(plvo);
	}
	
	public int delete(PostLikeVO plvo) {
		return postLikeDao.delete(plvo);
	}
	
	public int likeCheck(Map<String, Integer> map) {
		return postLikeDao.likeCheck(map);
	}
}
