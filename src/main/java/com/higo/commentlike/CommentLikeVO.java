package com.higo.commentlike;

public class CommentLikeVO {
	private int commLike_seq;
	private int comm_seq;
	private int member_seq;
	
	public CommentLikeVO() {}
	public CommentLikeVO(int commLike_seq, int comm_seq, int member_seq) {
		super();
		this.commLike_seq = commLike_seq;
		this.comm_seq = comm_seq;
		this.member_seq = member_seq;
	}
	public int getCommLike_seq() {
		return commLike_seq;
	}
	public void setCommLike_seq(int commLike_seq) {
		this.commLike_seq = commLike_seq;
	}
	public int getComm_seq() {
		return comm_seq;
	}
	public void setComm_seq(int comm_seq) {
		this.comm_seq = comm_seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	
	
	
	
}
