package com.higo.cash;

import java.sql.Date;

public class CashVO {
	private int cash_seq;
	private int gosu_seq;
	private int charge_cash;
	private int bonus_cash;
	private Date charge_date;
	
	public CashVO() {}
	public CashVO(int cash_seq, int gosu_seq, int charge_cash, int bonus_cash, Date charge_date) {
		super();
		this.cash_seq = cash_seq;
		this.gosu_seq = gosu_seq;
		this.charge_cash = charge_cash;
		this.bonus_cash = bonus_cash;
		this.charge_date = charge_date;
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
	public int getCharge_cash() {
		return charge_cash;
	}
	public void setCharge_cash(int charge_cash) {
		this.charge_cash = charge_cash;
	}
	public int getBonus_cash() {
		return bonus_cash;
	}
	public void setBonus_cash(int bonus_cash) {
		this.bonus_cash = bonus_cash;
	}
	public Date getCharge_date() {
		return charge_date;
	}
	public void setCharge_date(Date charge_date) {
		this.charge_date = charge_date;
	}
	
	

}
