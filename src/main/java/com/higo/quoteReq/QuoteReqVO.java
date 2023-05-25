package com.higo.quoteReq;

public class QuoteReqVO {

	private int quoteReq_seq;
	private int subSvc_seq;
	private int middleSvc_seq;
	private int majorSvc_seq;
	private int member_seq;
	private String req_text;
	private int qStatus;
	
	public QuoteReqVO() {}
	public QuoteReqVO(int quoteReq_seq, int subSvc_seq, int middleSvc_seq, int majorSvc_seq, int member_seq,
			String req_text, int qStatus) {
		super();
		this.quoteReq_seq = quoteReq_seq;
		this.subSvc_seq = subSvc_seq;
		this.middleSvc_seq = middleSvc_seq;
		this.majorSvc_seq = majorSvc_seq;
		this.member_seq = member_seq;
		this.req_text = req_text;
		this.qStatus = qStatus;
	}
	public int getQStatus() {
		return qStatus;
	}
	public void setQStatus(int qStatus) {
		this.qStatus = qStatus;
	}
	
	public int getQuoteReq_seq() {
		return quoteReq_seq;
	}
	public void setQuoteReq_seq(int quoteReq_seq) {
		this.quoteReq_seq = quoteReq_seq;
	}
	public int getSubSvc_seq() {
		return subSvc_seq;
	}
	public void setSubSvc_seq(int subSvc_seq) {
		this.subSvc_seq = subSvc_seq;
	}
	public int getMiddleSvc_seq() {
		return middleSvc_seq;
	}
	public void setMiddleSvc_seq(int middleSvc_seq) {
		this.middleSvc_seq = middleSvc_seq;
	}
	public int getMajorSvc_seq() {
		return majorSvc_seq;
	}
	public void setMajorSvc_seq(int majorSvc_seq) {
		this.majorSvc_seq = majorSvc_seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	public String getReq_text() {
		return req_text;
	}
	public void setReq_text(String req_text) {
		this.req_text = req_text;
	}
	
	
	
	
}
