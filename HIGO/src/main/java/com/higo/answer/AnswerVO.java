package com.higo.answer;

public class AnswerVO {
	
	private int anw_seq;
	private int question_seq;
	private String anw;
	private String anw_sub;
	
	public AnswerVO() {}
	
	public AnswerVO(int anw_seq, int question_seq, String anw, String anw_sub) {
		super();
		this.anw_seq = anw_seq;
		this.question_seq = question_seq;
		this.anw = anw;
		this.anw_sub = anw_sub;
	}

	public int getAnw_seq() {
		return anw_seq;
	}

	public void setAnw_seq(int anw_seq) {
		this.anw_seq = anw_seq;
	}
	

	public int getQuestion_seq() {
		return question_seq;
	}

	public void setQuestion_seq(int question_seq) {
		this.question_seq = question_seq;
	}

	public String getAnw() {
		return anw;
	}

	public void setAnw(String anw) {
		this.anw = anw;
	}

	public String getAnw_sub() {
		return anw_sub;
	}

	public void setAnw_sub(String anw_sub) {
		this.anw_sub = anw_sub;
	}
	
	
	
}
