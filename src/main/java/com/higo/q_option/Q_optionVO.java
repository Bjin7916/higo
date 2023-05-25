package com.higo.q_option;

public class Q_optionVO {
	
	private int option_seq;
	private int oQuote_seq;
	private String option_name;
	private int option_price;
	
	public Q_optionVO() {}
	public Q_optionVO(int option_seq, int oQuote_seq, String option_name, int option_price) {
		super();
		this.option_seq = option_seq;
		this.oQuote_seq = oQuote_seq;
		this.option_name = option_name;
		this.option_price = option_price;
	}
	public int getOption_seq() {
		return option_seq;
	}
	public void setOption_seq(int option_seq) {
		this.option_seq = option_seq;
	}
	
	public int getoQuote_seq() {
		return oQuote_seq;
	}
	public void setoQuote_seq(int oQuote_seq) {
		this.oQuote_seq = oQuote_seq;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public int getOption_price() {
		return option_price;
	}
	public void setOption_price(int option_price) {
		this.option_price = option_price;
	}
	
	
	
}
