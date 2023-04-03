package com.higo.middleSvc;

public class MiddleSvcVO {
	private int middleSvc_seq;
	private int majorSvc_seq;
	private String middleSvc_name;
	
	public MiddleSvcVO() {}

	public MiddleSvcVO(int middleSvc_seq, int majorSvc_seq, String middleSvc_name) {
		super();
		this.middleSvc_seq = middleSvc_seq;
		this.majorSvc_seq = majorSvc_seq;
		this.middleSvc_name = middleSvc_name;
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

	public String getMiddleSvc_name() {
		return middleSvc_name;
	}

	public void setMiddleSvc_name(String middleSvc_name) {
		this.middleSvc_name = middleSvc_name;
	}
	
	
	
}
