package com.higo.communityPart;

public class CommunityPartVO {
	private int comuPart_seq;
	private int comuPart_name;
	
	public CommunityPartVO() {}
	public CommunityPartVO(int comuPart_seq, int comuPart_name) {
		super();
		this.comuPart_seq = comuPart_seq;
		this.comuPart_name = comuPart_name;
	}
	public int getComuPart_seq() {
		return comuPart_seq;
	}
	public void setComuPart_seq(int comuPart_seq) {
		this.comuPart_seq = comuPart_seq;
	}
	public int getComuPart_name() {
		return comuPart_name;
	}
	public void setComuPart_name(int comuPart_name) {
		this.comuPart_name = comuPart_name;
	}
	
	
	
}
