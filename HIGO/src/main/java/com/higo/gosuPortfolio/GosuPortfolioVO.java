package com.higo.gosuPortfolio;

public class GosuPortfolioVO {
	private int pofol_seq;
	private int gosu_seq;
	private int fileType_seq;
	private String pofolFile_name;
	
	public GosuPortfolioVO() {}
	
	public GosuPortfolioVO(int pofol_seq, int gosu_seq, int fileType_seq, String pofolFile_name) {
		super();
		this.pofol_seq = pofol_seq;
		this.gosu_seq = gosu_seq;
		this.fileType_seq = fileType_seq;
		this.pofolFile_name = pofolFile_name;
	}

	public int getPofol_seq() {
		return pofol_seq;
	}

	public void setPofol_seq(int pofol_seq) {
		this.pofol_seq = pofol_seq;
	}

	public int getGosu_seq() {
		return gosu_seq;
	}

	public void setGosu_seq(int gosu_seq) {
		this.gosu_seq = gosu_seq;
	}

	public int getFileType_seq() {
		return fileType_seq;
	}

	public void setFileType_seq(int fileType_seq) {
		this.fileType_seq = fileType_seq;
	}

	public String getPofolFile_name() {
		return pofolFile_name;
	}

	public void setPofolFile_name(String pofolFile_name) {
		this.pofolFile_name = pofolFile_name;
	}
	
	
	
	

}
