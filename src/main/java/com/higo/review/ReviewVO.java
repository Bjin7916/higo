package com.higo.review;

import java.sql.Date;

public class ReviewVO {
	private int rv_seq;
	private int gosu_seq;
	private int member_seq;
	private int quote_seq;
	private String rv_content;
	private int star_score;
	private String rv_file;
	private int fileType_seq;
	private String rvFile_name;
	private Date rv_date;
	
	public ReviewVO() {}
	
	public ReviewVO(int rv_seq, int gosu_seq, int member_seq, int quote_seq, String rv_content, int star_score,
			String rv_file, int fileType_seq, String rvFile_name, Date rv_date) {
		super();
		this.rv_seq = rv_seq;
		this.gosu_seq = gosu_seq;
		this.member_seq = member_seq;
		this.quote_seq = quote_seq;
		this.rv_content = rv_content;
		this.star_score = star_score;
		this.rv_file = rv_file;
		this.fileType_seq = fileType_seq;
		this.rvFile_name = rvFile_name;
		this.rv_date = rv_date;
	}

	public int getRv_seq() {
		return rv_seq;
	}

	public void setRv_seq(int rv_seq) {
		this.rv_seq = rv_seq;
	}

	public int getGosu_seq() {
		return gosu_seq;
	}

	public void setGosu_seq(int gosu_seq) {
		this.gosu_seq = gosu_seq;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public int getQuote_seq() {
		return quote_seq;
	}

	public void setQuote_seq(int quote_seq) {
		this.quote_seq = quote_seq;
	}

	public String getRv_content() {
		return rv_content;
	}

	public void setRv_content(String rv_content) {
		this.rv_content = rv_content;
	}

	public int getStar_score() {
		return star_score;
	}

	public void setStar_score(int star_score) {
		this.star_score = star_score;
	}

	public String getRv_file() {
		return rv_file;
	}

	public void setRv_file(String rv_file) {
		this.rv_file = rv_file;
	}

	public int getFileType_seq() {
		return fileType_seq;
	}

	public void setFileType_seq(int fileType_seq) {
		this.fileType_seq = fileType_seq;
	}

	public String getRvFile_name() {
		return rvFile_name;
	}

	public void setRvFile_name(String rvFile_name) {
		this.rvFile_name = rvFile_name;
	}

	public Date getRv_date() {
		return rv_date;
	}

	public void setRv_date(Date rv_date) {
		this.rv_date = rv_date;
	}
	
	

}
