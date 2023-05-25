package com.higo.commentfile;

public class CommentFileVO {
	private int commentFile;
	private int fileType_seq;
	
	public CommentFileVO() {}

	public CommentFileVO(int commentFile, int fileType_seq) {
		super();
		this.commentFile = commentFile;
		this.fileType_seq = fileType_seq;
	}

	public int getCommentFile() {
		return commentFile;
	}

	public void setCommentFile(int commentFile) {
		this.commentFile = commentFile;
	}

	public int getFileType_seq() {
		return fileType_seq;
	}

	public void setFileType_seq(int fileType_seq) {
		this.fileType_seq = fileType_seq;
	}
	
	
	
}
