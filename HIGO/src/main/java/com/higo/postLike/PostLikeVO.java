package com.higo.postLike;

public class PostLikeVO {
	private int postLike_seq;
	private int post_seq;
	private int member_seq;
	
	public PostLikeVO() {}
	public PostLikeVO(int postLike_seq, int post_seq, int member_seq) {
		super();
		this.postLike_seq = postLike_seq;
		this.post_seq = post_seq;
		this.member_seq = member_seq;
	}
	public int getPostLike_seq() {
		return postLike_seq;
	}
	public void setPostLike_seq(int postLike_seq) {
		this.postLike_seq = postLike_seq;
	}
	public int getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	
	
	
}
