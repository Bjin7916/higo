package com.higo.gosu;

import java.util.List;
import java.util.Map;

import com.higo.member.MemberDAO;
import com.higo.member.MemberVO;

public class GosuService {
	
	public GosuDAO gosuDao;
	public MemberDAO memberDao;
	
	public void setGosuDao(GosuDAO gosuDao) {
		this.gosuDao = gosuDao;
	}
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public int insert(GosuVO vo) {
		int seq = memberDao.getSeq();
		vo.setMember_seq(seq);
		
		memberDao.insert(vo);
		
		if(gosuDao.insert(vo) != 0) {
		int	su = memberDao.updatediv(vo.getMember_seq());
			return su;
		}
		
		
		return gosuDao.insert(vo);
		
	}
	//추가정보
		public int insertGosu(GosuVO vo) {
			
			int su = 0;
			if(gosuDao.insert(vo) != 0) {
			//	System.out.println(vo.getMember_seq());
				su = memberDao.updatediv(vo.getMember_seq());
			}
			
			return su;
			
//			멤버에서 가입을 할떄
//			들어 오는 member_seq는 있으니까  그 member_seq를 담아서 
//			
//			고수 정보만 입력받은
//			그 고수 seq값에  넣어주기
//			
//			그리고 update_div
				
		}
	public int update(GosuVO vo) {
		memberDao.update(vo);
		return gosuDao.update(vo);
	}
	
	public int delete(int gosu_seq) {
		return gosuDao.delete(gosu_seq);
	}
	
	
	public GosuVO selectOneGosu(int gosu_seq) {
		GosuVO vo = null; 
		try {
			vo = gosuDao.selectOneGosu(gosu_seq);
		}catch(NullPointerException e) {
			e.printStackTrace();
			return null;
		}
		return vo;
		
	}
	
	public int checkLogin(int member_seq) {
		int chk = 0;
		try {
			chk = gosuDao.checkLogin(member_seq);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return chk;
	}
	
	//선경
	public GosuVO myCash(int gosu_seq) {
		return gosuDao.myCash(gosu_seq);
	}
	
	public GosuVO selectOne(int member_seq) {
		if(gosuDao.selectOne(member_seq) != null) {
			return gosuDao.selectOne(member_seq);
		}
		return null;
	}
	//견적서 해당 고수 id 가져오기
	public String gosuId(int quoteReq_seq) {
		String gosuId = "";
		try {
			gosuId = gosuDao.gosuId(quoteReq_seq);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return gosuId;
	}
	
	// 범진's CODE
		public List<GosuVO> select(GosuVO gv){
			return gosuDao.select(gv);
		}
		
		// 서비스 범위 수정
		public int svcRange(GosuVO gv) {
			return gosuDao.svcRange(gv);
		}
		
		public int returnRange(int gosu_seq) {
			return gosuDao.returnRange(gosu_seq);
		}
		
		// 활동지역
		public int reActaddr(GosuVO gv) {
			return gosuDao.svcLocal(gv);
		}
		
		public String returnActaddr(int gosu_seq) {
			return gosuDao.returnActaddr(gosu_seq);
		}
		
		// profile 정보
		public int countReview(int seq) {
			return gosuDao.countReview(seq);
		}
		
		public List<Integer> reviewStar(int seq) {
			return gosuDao.reviewStar(seq);
		}
		
		public List<String> majorSvc(){
			return gosuDao.majorSvc();
		}
		
		public int starAvg(int seq) {
			return gosuDao.starAvg(seq);
		}
		
		public int reName(MemberVO mv) {
			return gosuDao.reName(mv);
		}
		
		public String returnName(int member_seq) {
			return gosuDao.returnName(member_seq);
		}
		
		public int reIntro(GosuVO gv) {
			return gosuDao.reIntro(gv);
		}
		
		public String returnIntro(int gosu_seq) {
			return gosuDao.returnIntro(gosu_seq);
		}
		//윤수
		public int updateHireCnt(int gosu_seq) {
			return gosuDao.updateHireCnt(gosu_seq);
		}
		public GosuVO selectchargeCash(int gosu_seq) {
			return gosuDao.selectchargeCash(gosu_seq);
		}
		
		public List<Map<String, Object>> gosuAll(int subSvc_seq){
			
			List<Map<String, Object>> list = null;
			
			try {
				list = gosuDao.gosuAll(subSvc_seq);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	
}
