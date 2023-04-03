package com.higo.question;

public class QuestionVO {
	
	private int question_seq;
	private int subSvc_seq;
	private int middleSvc_seq;
	private int majorSvc_seq;
	private int question_step;
	private int anwType_seq;
	private String question;
	
	public QuestionVO() {}
	
	public QuestionVO(int question_seq, int subSvc_seq, int middleSvc_seq, int majorSvc_seq, int question_step,
			int anwType_seq, String question) {
		super();
		this.question_seq = question_seq;
		this.subSvc_seq = subSvc_seq;
		this.middleSvc_seq = middleSvc_seq;
		this.majorSvc_seq = majorSvc_seq;
		this.question_step = question_step;
		this.question = question;
		this.anwType_seq = anwType_seq;
	}

	public int getQuestion_seq() {
		return question_seq;
	}

	public void setQuestion_seq(int question_seq) {
		this.question_seq = question_seq;
	}

	public int getSubSvc_seq() {
		return subSvc_seq;
	}

	public void setSubSvc_seq(int subSvc_seq) {
		this.subSvc_seq = subSvc_seq;
	}

	public int getMiddleSvc_seq() {
		return middleSvc_seq;
	}

	public void setMiddleSvc_seq(int middleSvc_seq) {
		this.middleSvc_seq = middleSvc_seq;
	}

	public int getMajorSvc_seq() {
		return majorSvc_seq;
	}

	public void setMajorSvc_seq(int majorSvc_seq) {
		this.majorSvc_seq = majorSvc_seq;
	}

	public int getQuestion_step() {
		return question_step;
	}

	public void setQuestion_step(int question_step) {
		this.question_step = question_step;
	}


	public int getAnwType_seq() {
		return anwType_seq;
	}

	public void setAnwType_seq(int anwType_seq) {
		this.anwType_seq = anwType_seq;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
	
}
