package com.higo.customerCenter;

import java.sql.Date;

public class CustomerCenterVO {
	private int cc_seq;
	private int member_seq;
	private String cc_title;
	private String cc_content;
	private int cc_file;
	private int cc_status;
	private Date cc_date;
	
	public CustomerCenterVO() {}
	
	public CustomerCenterVO(int cc_seq, int member_seq, String cc_title, String cc_content, int cc_file, int cc_status,
			Date cc_date) {
		super();
		this.cc_seq = cc_seq;
		this.member_seq = member_seq;
		this.cc_title = cc_title;
		this.cc_content = cc_content;
		this.cc_file = cc_file;
		this.cc_status = cc_status;
		this.cc_date = cc_date;
	}

	public int getCc_seq() {
		return cc_seq;
	}

	public void setCc_seq(int cc_seq) {
		this.cc_seq = cc_seq;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public String getCc_title() {
		return cc_title;
	}

	public void setCc_title(String cc_title) {
		this.cc_title = cc_title;
	}

	public String getCc_content() {
		return cc_content;
	}

	public void setCc_content(String cc_content) {
		this.cc_content = cc_content;
	}

	public int getCc_file() {
		return cc_file;
	}

	public void setCc_file(int cc_file) {
		this.cc_file = cc_file;
	}

	public int getCc_status() {
		return cc_status;
	}

	public void setCc_status(int cc_status) {
		this.cc_status = cc_status;
	}

	public Date getCc_date() {
		return cc_date;
	}

	public void setCc_date(Date cc_date) {
		this.cc_date = cc_date;
	}

		
	
	
}
