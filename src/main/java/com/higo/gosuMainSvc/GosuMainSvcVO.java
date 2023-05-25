package com.higo.gosuMainSvc;

public class GosuMainSvcVO {
	private int gosuMS_seq;
	private int majorSvc_seq;
	private int middleSvc_seq;
	private int subSvc_seq;
	
	
	public GosuMainSvcVO() {}
	public GosuMainSvcVO(int gosuMS_seq, int majorSvc_seq, int middleSvc_seq, int subSvc_seq) {
		super();
		this.gosuMS_seq = gosuMS_seq;
		this.majorSvc_seq = majorSvc_seq;
		this.middleSvc_seq = middleSvc_seq;
		this.subSvc_seq = subSvc_seq;
	}
	
	public int getGosuMS_seq() {
		return gosuMS_seq;
	}
	public void setGosuMS_seq(int gosuMS_seq) {
		this.gosuMS_seq = gosuMS_seq;
	}
	public int getMajorSvc_seq() {
		return majorSvc_seq;
	}
	public void setMajorSvc_seq(int majorSvc_seq) {
		this.majorSvc_seq = majorSvc_seq;
	}
	public int getMiddleSvc_seq() {
		return middleSvc_seq;
	}
	public void setMiddleSvc_seq(int middleSvc_seq) {
		this.middleSvc_seq = middleSvc_seq;
	}
	public int getSubSvc_seq() {
		return subSvc_seq;
	}
	public void setSubSvc_seq(int subSvc_seq) {
		this.subSvc_seq = subSvc_seq;
	}
	
	
}
