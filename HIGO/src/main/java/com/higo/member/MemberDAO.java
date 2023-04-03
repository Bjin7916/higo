package com.higo.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.higo.gosu.GosuVO;

public class MemberDAO {
	
	private SqlSession sqlSession;
	
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(MemberVO vo) {
		return sqlSession.insert("member.insert", vo);
	}
	
	public int update(MemberVO vo) {
		return sqlSession.update("member.update",vo);
	}
	
	public int delete(int member_seq) {
		return sqlSession.delete("member.delete",member_seq);
	}
	
	public int checkLogin(MemberVO vo) {
		
		return sqlSession.selectOne("member.checkLogin",vo);
	}
	
	public MemberVO selectOne(int member_seq) {
		return sqlSession.selectOne("member.selectOne",member_seq);
	}
	
	public String findId(MemberVO vo) {
		return sqlSession.selectOne("member.findId",vo);
	}
	
	public String findPw(MemberVO vo) {
		return sqlSession.selectOne("member.findPw",vo);
	}
	
	public String getId(int member_seq) {
		return sqlSession.selectOne("member.getId",member_seq);
	}
	public String getName(int member_seq) {
		return sqlSession.selectOne("member.getName",member_seq);
	}
	
	public int getSeq() {
		return sqlSession.selectOne("member.getSeq");
	}

	public String checkId(String id) {
		return sqlSession.selectOne("member.checkId",id);
	}
	//광민
	public String checkEmail(String email) {
		return sqlSession.selectOne("member.checkEmail",email);
	}
	public String checkTel(String tel) {
		return sqlSession.selectOne("member.checkTel",tel);
	}
	
	//광민
	public int updatediv(int member_seq) {
		return sqlSession.update("member.updatediv",member_seq);
	}
	
	public int getMember_div(int member_seq) {
		return sqlSession.selectOne("member.getMember_div",member_seq);
	}
	
	
	//범진
	// profile 관련 메소드
		// 리뷰 갯수
		public int countReview(int seq) {
			return sqlSession.selectOne("member.countReview", seq);
		}
		// 리뷰 평점
		public List<Integer> reviewStar(int seq) {
			return sqlSession.selectList("member.reviewStar", seq);
		}
		// 대표 서비스
		public List<String> majorSvc(){
			return sqlSession.selectList("member.majorSvc");
		}
		// 서비스범위 업데이트
		public int svcRange(GosuVO gv) {
			return sqlSession.update("member.svcRange",gv);
		}
		//선경
		public int updateDiv(int seq) {
			return sqlSession.update("member.updateDiv", seq);
		}
		public MemberVO reqMember(int quoteReq_seq) {
			return sqlSession.selectOne("member.reqMember", quoteReq_seq);
		}
		
		//윤수
		public String selectMemName(int member_seq) {
			return sqlSession.selectOne("member.selectMemName", member_seq);
		}
}
