package com.higo.simpleQuote;

import java.sql.Date;

public class SimpleQuoteVO {
	private int sQuote_seq;
	private int gosu_seq;
	private int member_seq;
	private int price;
	private int price_type;
	private String quote_detail;
	private int quoteFile_seq;
	private int quoteReq_seq;
	private Date send_date;//DEFAULT sysdate NOT NULL,
	
	
	public SimpleQuoteVO() {}
	public SimpleQuoteVO(int sQuote_seq, int gosu_seq, int member_seq, int price, int price_type, String quote_detail,
			int quoteFile_seq, int quoteReq_seq, Date send_date) {
		super();
		this.sQuote_seq = sQuote_seq;
		this.gosu_seq = gosu_seq;
		this.member_seq = member_seq;
		this.price = price;
		this.price_type = price_type;
		this.quote_detail = quote_detail;
		this.quoteFile_seq = quoteFile_seq;
		this.quoteReq_seq = quoteReq_seq;
		this.send_date = send_date;
	}
	public int getsQuote_seq() {
		return sQuote_seq;
	}
	public void setsQuote_seq(int sQuote_seq) {
		this.sQuote_seq = sQuote_seq;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice_type() {
		return price_type;
	}
	public void setPrice_type(int price_type) {
		this.price_type = price_type;
	}
	public String getQuote_detail() {
		return quote_detail;
	}
	public void setQuote_detail(String quote_detail) {
		this.quote_detail = quote_detail;
	}
	public int getQuoteFile_seq() {
		return quoteFile_seq;
	}
	public void setQuoteFile_seq(int quoteFile_seq) {
		this.quoteFile_seq = quoteFile_seq;
	}
	public int getQuoteReq_seq() {
		return quoteReq_seq;
	}
	public void setQuoteReq_seq(int quoteReq_seq) {
		this.quoteReq_seq = quoteReq_seq;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	
	
	
}
