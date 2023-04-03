package com.higo.subSvc;

public class SubSvcVO {
	private int subSvc_seq;
	private int middleSvc_seq;
	private int majorSvc_seq;
	private String subSvc_name;
	
	public SubSvcVO() {}
	
	public SubSvcVO(int subSvc_seq, int middleSvc_seq, int majorSvc_seq, String subSvc_name) {
		super();
		this.subSvc_seq = subSvc_seq;
		this.middleSvc_seq = middleSvc_seq;
		this.majorSvc_seq = majorSvc_seq;
		this.subSvc_name = subSvc_name;
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

	public String getSubSvc_name() {
		return subSvc_name;
	}

	public void setSubSvc_name(String subSvc_name) {
		this.subSvc_name = subSvc_name;
	}
	
	
	
}
