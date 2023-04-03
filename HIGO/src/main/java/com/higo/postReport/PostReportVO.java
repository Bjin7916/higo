package com.higo.postReport;

public class PostReportVO {
	private int postReport_seq;
	private int member_seq;
	
	
	public PostReportVO() {}
	public PostReportVO(int postReport_seq, int member_seq) {
		super();
		this.postReport_seq = postReport_seq;
		this.member_seq = member_seq;
	}
	public int getPostReport_seq() {
		return postReport_seq;
	}
	public void setPostReport_seq(int postReport_seq) {
		this.postReport_seq = postReport_seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	
	
	

}
