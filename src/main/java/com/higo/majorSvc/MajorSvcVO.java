package com.higo.majorSvc;

public class MajorSvcVO {
	private int majorSvc_seq;
	private String majorSvc_name;

	public MajorSvcVO() {}
	
	public MajorSvcVO(int majorSvc_seq, String majorSvc_name) {
		super();
		this.majorSvc_seq = majorSvc_seq;
		this.majorSvc_name = majorSvc_name;
	}

	public int getMajorSvc_seq() {
		return majorSvc_seq;
	}

	public void setMajorSvc_seq(int majorSvc_seq) {
		this.majorSvc_seq = majorSvc_seq;
	}

	public String getMajorSvc_name() {
		return majorSvc_name;
	}

	public void setMajorSvc_name(String majorSvc_name) {
		this.majorSvc_name = majorSvc_name;
	}

	
}


