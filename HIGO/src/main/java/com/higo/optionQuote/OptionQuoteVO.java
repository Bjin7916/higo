package com.higo.optionQuote;

import java.sql.Date;

public class OptionQuoteVO {
	
	private int oQuote_seq;
	private int gosu_seq;
	private int member_seq;
	private int price;
	private int option_price;
	private int quoteFile_seq;
	private Date send_date; // sysdate
	
	public OptionQuoteVO() {}
	public OptionQuoteVO(int oQuote_seq, int gosu_seq, int member_seq, int price, int option_price,
			int quoteFile_seq, Date send_date) {
		super();
		this.oQuote_seq = oQuote_seq;
		this.gosu_seq = gosu_seq;
		this.member_seq = member_seq;
		this.price = price;
		this.option_price = option_price;
		this.quoteFile_seq = quoteFile_seq;
		this.send_date = send_date;
	}
	public int getoQuote_seq() {
		return oQuote_seq;
	}
	public void setoQuote_seq(int oQuote_seq) {
		this.oQuote_seq = oQuote_seq;
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
	public int getOption_price() {
		return option_price;
	}
	public void setOption_price(int option_price) {
		this.option_price = option_price;
	}
	public int getQuoteFile_seq() {
		return quoteFile_seq;
	}
	public void setQuoteFile_seq(int quoteFile_seq) {
		this.quoteFile_seq = quoteFile_seq;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	
	
	
}	
