package com.higo.gosu;

import java.util.List;
import java.util.Map;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.higo.member.MemberVO;

public class GosuDAO {
	private SqlSession sqlSession;
	
	public GosuDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(GosuVO vo) {
		return sqlSession.insert("gosu.insert", vo);
	}
	
	public int update(GosuVO vo) {
		return sqlSession.update("gosu.update",vo);
	}
	
	public int delete(int gosu_seq) {
		return sqlSession.update("gosu.delete",gosu_seq);
	}
	
	public int checkLogin(int member_seq) {
		int su = 0;
		
		try {
			su = sqlSession.selectOne("gosu.checkLogin",member_seq);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return su;
	}
	
//	public GosuVO selectOne(int gosu_seq) {
//		return sqlSession.selectOne( "gosu.selectOne",gosu_seq);
//	}
	//gosu 시퀀스로 찾기 
	public GosuVO selectOneGosu(int gosu_seq) {
		return sqlSession.selectOne( "gosu.selectOneGosu",gosu_seq);
	}
	
	//선경
	
	public int getSeq() {
		return sqlSession.selectOne("gosu.getSeq");
	}
	
	public GosuVO myCash(int gosu_seq) {
		return sqlSession.selectOne("gosu.myCash", gosu_seq);
	}
	
	public GosuVO selectOne(int member_seq) {
		GosuVO vo = null;
		
		try {
			vo = sqlSession.selectOne("gosu.selectOne", member_seq);
			return vo;
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return vo;
	}
	public String gosuId(int quoteReq_seq) {
		return sqlSession.selectOne("gosuId", quoteReq_seq);
	}
	
	// 범진's CODE
		public List<GosuVO> select(GosuVO gv){
			return sqlSession.selectList("gosu.selectQuote", gv);
		}
		// profile 관련 메소드
		// 리뷰 갯수
		public int countReview(int seq) {
			return sqlSession.selectOne("gosu.countReview", seq);
		}
		// 리뷰 평점
		public List<Integer> reviewStar(int seq) {
			return sqlSession.selectList("gosu.reviewStar", seq);
		}
		// 대표 서비스
		public List<String> majorSvc(){
			return sqlSession.selectList("gosu.majorSvc");
		}
		// 서비스범위 업데이트
		public int svcRange(GosuVO gv) {
			return sqlSession.update("gosu.svcRange",gv);
		}
		
		public int returnRange(int gosu_seq) {
			return sqlSession.selectOne("gosu.returnRange", gosu_seq);
		}
		
		// 활동지역 수정
		public int svcLocal(GosuVO gv) {
			return sqlSession.update("gosu.svcLocal", gv);
		}
		
		public String returnActaddr(int gosu_seq) {
			return sqlSession.selectOne("gosu.returnActaddr", gosu_seq);
		}
		
		// 리뷰평점
		public int starAvg(int seq) {
			return sqlSession.update("gosu.starAvg", seq);
		}
		// 고수 이름 수정
		public int reName(MemberVO mv) {
			return sqlSession.update("gosu.reName", mv);
		}
		
		// 수정된 이름 리턴
		public String returnName(int member_seq) {
			return sqlSession.selectOne("gosu.returnName",member_seq);
		}
		
		// 한줄소개 수정
		public int reIntro(GosuVO gv) {
			return sqlSession.update("gosu.reIntro", gv);
		}
		
		// 수정된 한줄소개 리턴
		public String returnIntro(int gosu_seq) {
			return sqlSession.selectOne("gosu.returnIntro", gosu_seq);
		}
		//윤수
		public int updateHireCnt(int gosu_seq) {
			return sqlSession.update("gosu.updateHireCnt", gosu_seq);
		}
		
		public GosuVO selectchargeCash(int gosu_seq) {
			return sqlSession.selectOne("gosu.selectchargeCash", gosu_seq);
		}
		
		public List<Map<String, Object>> gosuAll(int subSvc_seq){
			return sqlSession.selectList("gosu.gosuAll", subSvc_seq);
		}
	
}
