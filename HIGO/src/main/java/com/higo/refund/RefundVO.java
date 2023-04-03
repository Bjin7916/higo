package com.higo.refund;

import java.sql.Date;

public class RefundVO {
	private int cash_seq;
	private int gosu_seq;
	private int refund_cash;
	private Date refund_date;
	private int refund_status;
	
	public RefundVO() {}
	public RefundVO(int cash_seq, int gosu_seq, int refund_cash, Date refund_date, int refund_status) {
		super();
		this.cash_seq = cash_seq;
		this.gosu_seq = gosu_seq;
		this.refund_cash = refund_cash;
		this.refund_date = refund_date;
		this.refund_status = refund_status;
	}
	public int getCash_seq() {
		return cash_seq;
	}
	public void setCash_seq(int cash_seq) {
		this.cash_seq = cash_seq;
	}
	public int getGosu_seq() {
		return gosu_seq;
	}
	public void setGosu_seq(int gosu_seq) {
		this.gosu_seq = gosu_seq;
	}
	public int getRefund_cash() {
		return refund_cash;
	}
	public void setRefund_cash(int refund_cash) {
		this.refund_cash = refund_cash;
	}
	public Date getRefund_date() {
		return refund_date;
	}
	public void setRefund_date(Date refund_date) {
		this.refund_date = refund_date;
	}
	public int getRefund_status() {
		return refund_status;
	}
	public void setRefund_status(int refund_status) {
		this.refund_status = refund_status;
	}
	
	
	

}
