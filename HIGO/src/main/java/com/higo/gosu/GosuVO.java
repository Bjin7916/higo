package com.higo.gosu;

import com.higo.member.MemberVO;

public class GosuVO extends MemberVO{
	private int gosu_seq;
	private int member_seq;
	private String intro;
	private int svc_range;
	private String actAddr;
	private String account;
	private int staff_ctn;
	private int career;
	private String contact_time;
	private String portfolio;
	private int cash;
	private int bonus_cash;
	private int auto_check;
	private String kakao_id;
	private int gosuMS_seq;
	private int hire_cnt;
	private float star_avg;
	
	
	public GosuVO() {}
	
	
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
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}


	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}


	@Override
	public String getTel() {
		// TODO Auto-generated method stub
		return super.getTel();
	}


	@Override
	public void setTel(String tel) {
		// TODO Auto-generated method stub
		super.setTel(tel);
	}


	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}


	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}


	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}



	@Override
	public String getMember_img() {
		// TODO Auto-generated method stub
		return super.getMember_img();
	}


	@Override
	public void setMember_img(String member_img) {
		// TODO Auto-generated method stub
		super.setMember_img(member_img);
	}


	@Override
	public int getMember_div() {
		// TODO Auto-generated method stub
		return super.getMember_div();
	}


	@Override
	public void setMember_div(int member_div) {
		// TODO Auto-generated method stub
		super.setMember_div(member_div);
	}


	@Override
	public int getAgree_ad() {
		// TODO Auto-generated method stub
		return super.getAgree_ad();
	}


	@Override
	public void setAgree_ad(int agree_ad) {
		// TODO Auto-generated method stub
		super.setAgree_ad(agree_ad);
	}


	public GosuVO(int gosu_seq, int member_seq, String intro, int svc_range, String actAddr, String account,
			int staff_ctn, int career, String contact_time, String portfolio, int cash, int bonus_cash,
			int auto_check, String kakao_id, int gosuMS_seq, int hire_cnt, int star_avg) {
		super();
		this.gosu_seq = gosu_seq;
		this.member_seq = member_seq;
		this.intro = intro;
		this.svc_range = svc_range;
		this.actAddr = actAddr;
		this.account = account;
		this.staff_ctn = staff_ctn;
		this.career = career;
		this.contact_time = contact_time;
		this.portfolio = portfolio;
		this.cash = cash;
		this.bonus_cash = bonus_cash;
		this.auto_check = auto_check;
		this.kakao_id = kakao_id;
		this.gosuMS_seq = gosuMS_seq;
		this.hire_cnt = hire_cnt;
		this.star_avg = star_avg;
	}
	public int getGosu_seq() {
		return gosu_seq;
	}
	public void setGosu_seq(int gosu_seq) {
		this.gosu_seq = gosu_seq;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getSvc_range() {
		return svc_range;
	}
	public void setSvc_range(int svc_range) {
		this.svc_range = svc_range;
	}
	public String getActAddr() {
		return actAddr;
	}
	public void setActAddr(String actAddr) {
		this.actAddr = actAddr;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getStaff_ctn() {
		return staff_ctn;
	}
	public void setStaff_ctn(int staff_ctn) {
		this.staff_ctn = staff_ctn;
	}
	public int getCareer() {
		return career;
	}
	public void setCareer(int career) {
		this.career = career;
	}
	public String getContact_time() {
		return contact_time;
	}
	public void setContact_time(String contact_time) {
		this.contact_time = contact_time;
	}
	public String getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getBonus_cash() {
		return bonus_cash;
	}
	public void setBonus_cash(int bonus_cash) {
		this.bonus_cash = bonus_cash;
	}
	public int getAuto_check() {
		return auto_check;
	}
	public void setAuto_check(int auto_check) {
		this.auto_check = auto_check;
	}
	public String getKakao_id() {
		return kakao_id;
	}
	public void setKakao_id(String kakao_id) {
		this.kakao_id = kakao_id;
	}
	public int getGosuMS_seq() {
		return gosuMS_seq;
	}
	public void setGosuMS_seq(int gosuMS_seq) {
		this.gosuMS_seq = gosuMS_seq;
	}
	public int getHire_cnt() {
		return hire_cnt;
	}
	public void setHire_cnt(int hire_cnt) {
		this.hire_cnt = hire_cnt;
	}
	public float getStar_avg() {
		return star_avg;
	}
	public void setStar_avg(float star_avg) {
		this.star_avg = star_avg;
	}
	
	
    
}
