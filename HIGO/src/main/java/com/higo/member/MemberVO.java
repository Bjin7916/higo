package com.higo.member;

public class MemberVO {
	private int member_seq;
	private String id;
	private String password;
	private String tel;
	private String email;
	private String name;
	private String member_img;
	private int member_div;
	private int agree_ad;
	
	public MemberVO() {}
	public MemberVO(int member_seq, String id, String password, String tel, String email, String name,
			String member_img, int member_div, int agree_ad) {
		super();
		this.member_seq = member_seq;
		this.id = id;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.name = name;
		this.member_img = member_img;
		this.member_div = member_div;
		this.agree_ad = agree_ad;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMember_img() {
		return member_img;
	}
	public void setMember_img(String member_img) {
		this.member_img = member_img;
	}
	public int getMember_div() {
		return member_div;
	}
	public void setMember_div(int member_div) {
		this.member_div = member_div;
	}
	public int getAgree_ad() {
		return agree_ad;
	}
	public void setAgree_ad(int agree_ad) {
		this.agree_ad = agree_ad;
	}
	
	

	
}
