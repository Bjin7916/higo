package com.higo.out;

import java.sql.Date;

public class OutVO {
	private int out_seq;
	private int member_seq;
	private int outReason_seq;
	private Date out_date;
	
	public OutVO() {}
	public OutVO(int out_seq, int member_seq, int outReason_seq, Date out_date) {
		super();
		this.out_seq = out_seq;
		this.member_seq = member_seq;
		this.outReason_seq = outReason_seq;
		this.out_date = out_date;
	}
	public int getOut_seq() {
		return out_seq;
	}
	public void setOut_seq(int out_seq) {
		this.out_seq = out_seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	public int getOutReason_seq() {
		return outReason_seq;
	}
	public void setOutReason_seq(int outReason_seq) {
		this.outReason_seq = outReason_seq;
	}
	public Date getOut_date() {
		return out_date;
	}
	public void setOut_date(Date out_date) {
		this.out_date = out_date;
	}

	
}
