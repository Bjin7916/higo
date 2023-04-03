package com.higo.c_ment;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.higo.post.PostVO;

public class CommentVO extends PostVO{	
	//테이블 명 c_ment
	private int comm_seq;
	private int member_seq;
	private Date comm_sysdate;
	private int commFile_seq;
	private int comm_groupNum;
	private int comm_step;
	private int comm_depth;
	private String comm_content;
	private int commLike_count;
	

	
	public CommentVO() {}
	
	
	
	public CommentVO(int comm_seq, int member_seq, Date comm_sysdate, int commFile_seq, int comm_groupNum,
			int comm_step, int comm_depth, String comm_content, int commLike_count) {
		super();
		this.comm_seq = comm_seq;
		this.member_seq = member_seq;
		this.comm_sysdate = comm_sysdate;
		this.commFile_seq = commFile_seq;
		this.comm_groupNum = comm_groupNum;
		this.comm_step = comm_step;
		this.comm_depth = comm_depth;
		this.comm_content = comm_content;
		this.commLike_count = commLike_count;
	}
	

	
	@Override
	public List<String> getFileList() {
		// TODO Auto-generated method stub
		return super.getFileList();
	}



	@Override
	public void setFileList(List<String> fileList) {
		// TODO Auto-generated method stub
		super.setFileList(fileList);
	}



	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return super.getFileName();
	}



	@Override
	public void setFileName(String fileName) {
		// TODO Auto-generated method stub
		super.setFileName(fileName);
	}



	@Override
	public MultipartFile getPhoto() {
		// TODO Auto-generated method stub
		return super.getPhoto();
	}



	@Override
	public void setPhoto(MultipartFile photo) {
		// TODO Auto-generated method stub
		super.setPhoto(photo);
	}



	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}



	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}



	@Override
	public int getPost_seq() {
		// TODO Auto-generated method stub
		return super.getPost_seq();
	}



	@Override
	public void setPost_seq(int post_seq) {
		// TODO Auto-generated method stub
		super.setPost_seq(post_seq);
	}



	@Override
	public int getComuPart_seq() {
		// TODO Auto-generated method stub
		return super.getComuPart_seq();
	}



	@Override
	public void setComuPart_seq(int comuPart_seq) {
		// TODO Auto-generated method stub
		super.setComuPart_seq(comuPart_seq);
	}



	@Override
	public int getSubSvc_seq() {
		// TODO Auto-generated method stub
		return super.getSubSvc_seq();
	}



	@Override
	public void setSubSvc_seq(int subSvc_seq) {
		// TODO Auto-generated method stub
		super.setSubSvc_seq(subSvc_seq);
	}



	@Override
	public int getMiddleSvc_seq() {
		// TODO Auto-generated method stub
		return super.getMiddleSvc_seq();
	}



	@Override
	public void setMiddleSvc_seq(int middleSvc_seq) {
		// TODO Auto-generated method stub
		super.setMiddleSvc_seq(middleSvc_seq);
	}



	@Override
	public int getMajorSvc_seq() {
		// TODO Auto-generated method stub
		return super.getMajorSvc_seq();
	}



	@Override
	public void setMajorSvc_seq(int majorSvc_seq) {
		// TODO Auto-generated method stub
		super.setMajorSvc_seq(majorSvc_seq);
	}



	@Override
	public int getLocal_seq() {
		// TODO Auto-generated method stub
		return super.getLocal_seq();
	}



	@Override
	public void setLocal_seq(int local_seq) {
		// TODO Auto-generated method stub
		super.setLocal_seq(local_seq);
	}



	@Override
	public String getPost_title() {
		// TODO Auto-generated method stub
		return super.getPost_title();
	}



	@Override
	public void setPost_title(String post_title) {
		// TODO Auto-generated method stub
		super.setPost_title(post_title);
	}



	@Override
	public Date getPost_sysdate() {
		// TODO Auto-generated method stub
		return super.getPost_sysdate();
	}



	@Override
	public void setPost_sysdate(Date post_sysdate) {
		// TODO Auto-generated method stub
		super.setPost_sysdate(post_sysdate);
	}



	@Override
	public int getPost_hit() {
		// TODO Auto-generated method stub
		return super.getPost_hit();
	}



	@Override
	public void setPost_hit(int post_hit) {
		// TODO Auto-generated method stub
		super.setPost_hit(post_hit);
	}



	@Override
	public int getPostLike_count() {
		// TODO Auto-generated method stub
		return super.getPostLike_count();
	}



	@Override
	public void setPostLike_count(int postLike_count) {
		// TODO Auto-generated method stub
		super.setPostLike_count(postLike_count);
	}



	@Override
	public String getPost_content() {
		// TODO Auto-generated method stub
		return super.getPost_content();
	}



	@Override
	public void setPost_content(String post_content) {
		// TODO Auto-generated method stub
		super.setPost_content(post_content);
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}



	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}



	public int getComm_seq() {
		return comm_seq;
	}
	public void setComm_seq(int comm_seq) {
		this.comm_seq = comm_seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	public Date getComm_sysdate() {
		return comm_sysdate;
	}
	public void setComm_sysdate(Date comm_sysdate) {
		this.comm_sysdate = comm_sysdate;
	}
	public int getCommFile_seq() {
		return commFile_seq;
	}
	public void setCommFile_seq(int commFile_seq) {
		this.commFile_seq = commFile_seq;
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
	public String getComm_content() {
		return comm_content;
	}
	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}
	public int getCommLike_count() {
		return commLike_count;
	}
	public void setCommLike_count(int commLike_count) {
		this.commLike_count = commLike_count;
	}
	
}
