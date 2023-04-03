package com.higo.post;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PostVO {
	private int post_seq;
	private int member_seq;
	private int comuPart_seq;
	private int subSvc_seq;
	private int middleSvc_seq;
	private int majorSvc_seq;
	private int local_seq;
	private String post_title;
	private Date post_sysdate;
	private int post_hit;
	private int postLike_count;
	private String post_content;
	
	private String id;
	private String fileName; 	// 업로드된 파일명
	
	private MultipartFile photo;
	
	private int comm_groupNum;
	private int comm_step;
	private int comm_depth;
	
	private List<String> fileList;
	
	public PostVO() {}
	
	public PostVO(int post_seq, String post_title, String post_content, String fileName) {
		super();
		this.post_seq = post_seq;
		this.post_title = post_title;
		this.post_content = post_content;
		this.fileName = fileName;
	}
	
	public PostVO(int post_seq, String post_title, String fileName, int post_hit, Date post_sysdate, String id) {
		super();
		this.post_seq = post_seq;
		this.post_title = post_title;
		this.fileName = fileName;
		this.post_hit = post_hit;
		this.post_sysdate = post_sysdate;
		this.id = id;
	}
	
	public PostVO(int post_seq, int member_seq, int comuPart_seq, int subSvc_seq, int middleSvc_seq, int majorSvc_seq,
			int local_seq, String post_title, Date post_sysdate, int post_hit, int postLike_count,
			String post_content) {
		super();
		this.post_seq = post_seq;
		this.member_seq = member_seq;
		this.comuPart_seq = comuPart_seq;
		this.subSvc_seq = subSvc_seq;
		this.middleSvc_seq = middleSvc_seq;
		this.majorSvc_seq = majorSvc_seq;
		this.local_seq = local_seq;
		this.post_title = post_title;
		this.post_sysdate = post_sysdate;
		this.post_hit = post_hit;
		this.postLike_count = postLike_count;
		this.post_content = post_content;
	}
	
	public List<String> getFileList() {
		return fileList;
	}
	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public int getComm_groupNum() {
		return comm_groupNum;
	}
	public void setComm_groupNum(int comm_groupNum) {
		this.comm_groupNum = comm_groupNum;
	}
	public int getComm_step() {
		return comm_step;
	}
	public void setComm_step(int comm_step) {
		this.comm_step = comm_step;
	}
	public int getComm_depth() {
		return comm_depth;
	}
	public void setComm_depth(int comm_depth) {
		this.comm_depth = comm_depth;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	public int getComuPart_seq() {
		return comuPart_seq;
	}
	public void setComuPart_seq(int comuPart_seq) {
		this.comuPart_seq = comuPart_seq;
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
	public int getLocal_seq() {
		return local_seq;
	}
	public void setLocal_seq(int local_seq) {
		this.local_seq = local_seq;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public Date getPost_sysdate() {
		return post_sysdate;
	}
	public void setPost_sysdate(Date post_sysdate) {
		this.post_sysdate = post_sysdate;
	}
	public int getPost_hit() {
		return post_hit;
	}
	public void setPost_hit(int post_hit) {
		this.post_hit = post_hit;
	}
	public int getPostLike_count() {
		return postLike_count;
	}
	public void setPostLike_count(int postLike_count) {
		this.postLike_count = postLike_count;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	} 
	
	
	
	
}
