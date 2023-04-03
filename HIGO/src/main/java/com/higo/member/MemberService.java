package com.higo.member;

import java.util.List;

import com.higo.gosu.GosuVO;

public class MemberService {

	
	private MemberDAO memberDao;
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public int insert(MemberVO vo) {
		int seq = memberDao.getSeq();
		vo.setMember_seq(seq);
		
		
		return memberDao.insert(vo);
	}
	
	public int update(MemberVO vo) {
		return memberDao.update(vo);
	}
	
	public int delete(int member_seq) {
		return memberDao.delete(member_seq);
	}
	
	public int checkLogin(MemberVO vo) {
	
		return  memberDao.checkLogin(vo);
	}
//	public int checkLogin(MemberVO vo) {
//		return memberDao.checkLogin(vo);
//	}
	
	public MemberVO selectOne(int member_seq) {
		MemberVO vo = null;
		try {
			vo = memberDao.selectOne(member_seq);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public String findId(MemberVO vo) {
		return memberDao.findId(vo);
	}
	
	public String findPw(MemberVO vo) {
		return memberDao.findPw(vo);
	}
	
	public String getId(int member_seq) {
		return memberDao.getId(member_seq);
	}
	
	public String getName(int member_seq) {
		return memberDao.getName(member_seq);
	}
	public String checkId(String id) {
		return memberDao.checkId(id);
	}
	public int getMember_div(int member_seq) {
		return memberDao.getMember_div(member_seq);
	}

	//광민
	public String checkEmail(String email) {
		return memberDao.checkEmail(email);
	}
	
	public String checkTel(String tel) {
		return memberDao.checkTel(tel);
	}
	//범진
	// profile 정보
		public int countReview(int seq) {
			return memberDao.countReview(seq);
		}
		
		public List<Integer> reviewStar(int seq) {
			return memberDao.reviewStar(seq);
		}
		
		public List<String> majorSvc(){
			return memberDao.majorSvc();
		}
		// 서비스범위 업데이트
		public int svcRange(GosuVO gv) {
			return memberDao.svcRange(gv);
		}
	//선경
	// member_div update (추가로 고수가입시)
		public int updateDiv(int seq) {
			return memberDao.updateDiv(seq);
		}
	public MemberVO reqMember(int quoteReq_seq) {
		return memberDao.reqMember(quoteReq_seq);
	}
		//윤수
				public String selectMemName(int member_seq) {
					return memberDao.selectMemName(member_seq);
				}
}
