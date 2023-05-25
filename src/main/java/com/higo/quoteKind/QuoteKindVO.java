package com.higo.quoteKind;

public class QuoteKindVO {
	private int quoteKind_seq;
    private int kind;
    
    public QuoteKindVO() {}
	public QuoteKindVO(int quoteKind_seq, int kind) {
		super();
		this.quoteKind_seq = quoteKind_seq;
		this.kind = kind;
	}
	public int getQuoteKind_seq() {
		return quoteKind_seq;
	}
	public void setQuoteKind_seq(int quoteKind_seq) {
		this.quoteKind_seq = quoteKind_seq;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
    
    
    
    

}
