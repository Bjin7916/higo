package com.higo.postFile;

public class PostFileVO {
	private int postFile_seq;
	private int post_seq;
	private int fileType_seq;
	private String fileName;

	public PostFileVO() {}
	
	public PostFileVO(int post_seq, String fileName) {
		super();
		this.post_seq = post_seq;
		this.fileName = fileName;
	}
	
	public PostFileVO(int postFile_seq, int post_seq, int fileType_seq, String fileName) {
		super();
		this.postFile_seq = postFile_seq;
		this.post_seq = post_seq;
		this.fileType_seq = fileType_seq;
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getPostFile_seq() {
		return postFile_seq;
	}

	public void setPostFile_seq(int postFile_seq) {
		this.postFile_seq = postFile_seq;
	}

	public int getPost_seq() {
		return post_seq;
	}

	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}

	public int getFileType_seq() {
		return fileType_seq;
	}

	public void setFileType_seq(int fileType_seq) {
		this.fileType_seq = fileType_seq;
	}
	
	

	
	
}
