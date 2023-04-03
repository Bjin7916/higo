package com.higo.answerType;

public class AnswerTypeVO {
	private int anwType_seq;
	private String anwType_name;
	
	public AnswerTypeVO() {}
	public AnswerTypeVO(int anwType_seq, String anwType_name) {
		super();
		this.anwType_seq = anwType_seq;
		this.anwType_name = anwType_name;
	}
	public int getAnwType_seq() {
		return anwType_seq;
	}
	public void setAnwType_seq(int anwType_seq) {
		this.anwType_seq = anwType_seq;
	}
	public String getAnwType_name() {
		return anwType_name;
	}
	public void setAnwType_name(String anwType_name) {
		this.anwType_name = anwType_name;
	}
	
	
}
