package com.higo.community;

public class CommunityVO {
	private int comu_seq;
	private int member_seq;
	private int comuPart_seq;
	private int Post_seq;

	
	public CommunityVO() {
		super();
	}
	
	public CommunityVO(int comu_seq, int member_seq, int comuPart_seq) {
		super();
		this.comu_seq = comu_seq;
		this.member_seq = member_seq;
		this.comuPart_seq = comuPart_seq;
	}
	
	public int getComu_seq() {
		return comu_seq;
	}

	public void setComu_seq(int comu_seq) {
		this.comu_seq = comu_seq;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public int getComuPart_seq() {
		return comuPart_seq;
	}

	public void setComuPart_seq(int comuPart_seq) {
		this.comuPart_seq = comuPart_seq;
	}

	public int getPost_seq() {
		return Post_seq;
	}

	public void setPost_seq(int post_seq) {
		Post_seq = post_seq;
	}
	
}
