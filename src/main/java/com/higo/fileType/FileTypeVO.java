package com.higo.fileType;

public class FileTypeVO {
	private int fileType_seq;
	private int file_type;
	
	public FileTypeVO() {}
	
	public FileTypeVO(int fileType_seq, int file_type) {
		super();
		this.fileType_seq = fileType_seq;
		this.file_type = file_type;
	}

	public int getFileType_seq() {
		return fileType_seq;
	}

	public void setFileType_seq(int fileType_seq) {
		this.fileType_seq = fileType_seq;
	}

	public int getFile_type() {
		return file_type;
	}

	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}
	
	
}
