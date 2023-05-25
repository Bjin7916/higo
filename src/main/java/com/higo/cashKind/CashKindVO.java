package com.higo.cashKind;

public class CashKindVO {
	private int cashKind_seq;
	private int cash;
	
	
	public CashKindVO() {}
	
	public CashKindVO(int cashKind_seq, int cash) {
		super();
		this.cashKind_seq = cashKind_seq;
		this.cash = cash;
	}
	
	public int getCashKind_seq() {
		return cashKind_seq;
	}
	public void setCashKind_seq(int cashKind_seq) {
		this.cashKind_seq = cashKind_seq;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	
}
