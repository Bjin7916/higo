package com.higo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.reflect.MemberSignature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.higo.gosu.GosuService;
import com.higo.gosu.GosuVO;
import com.higo.gosuMainSvc.GosuMainSvcService;
import com.higo.gosuMainSvc.GosuMainSvcVO;
import com.higo.member.MemberService;
import com.higo.member.MemberVO;
import com.higo.myQuoteadd.MyQuoteAddService;
import com.higo.quote.QuoteService;
import com.higo.quoteReq.QuoteReqService;
import com.higo.quoteReq.QuoteReqVO;
import com.higo.subSvc.SubSvcService;

import common.Setting;
import common.ViewPath;

@Controller
public class QuoteController {
	
	private MemberService memberService;
	private GosuService gosuService;
	private SubSvcService subSvcService;
	private GosuMainSvcService gosuMainSvcService;
	private QuoteReqService quoteReqService;
	private QuoteService quoteService;
	private MyQuoteAddService myQuoteAddService;
	
	public QuoteController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public QuoteController(GosuService gosuService) {
		this.gosuService = gosuService;
	}
	
	public QuoteController(MemberService memberService, GosuService gosuService, SubSvcService subSvcService, GosuMainSvcService gosuMainSvcService, QuoteReqService quoteReqService, QuoteService quoteService, MyQuoteAddService myQuoteAddService) {
		this.memberService = memberService;
		this.gosuService = gosuService;
		this.subSvcService = subSvcService;
		this.gosuMainSvcService = gosuMainSvcService;
		this.quoteReqService = quoteReqService;
		this.quoteService = quoteService;
		this.myQuoteAddService = myQuoteAddService;
	}
	
	
	
	@RequestMapping("/quote/receiveRequestQuote")
	public String receiveRequestQuote(HttpServletResponse response, HttpServletRequest request, GosuVO gosuVO, QuoteReqVO quoteReqVO) {

		
	System.out.println(request.getSession().getAttribute("login"));
		
		//고수 시퀀스 가져오기
		Integer gosu_seq = null;
		if((gosu_seq = (Integer)request.getSession().getAttribute("glogin"))==null) {
			Setting.goToLogin(response);
		}
		
		
		
		System.out.println("2번" + gosu_seq);
		//고수 vo 가져오기
		gosuVO = gosuService.selectOneGosu(gosu_seq);
		System.out.println("고수메인" + gosuVO.getGosu_seq());
		//고수 vo에서 메인서비스 시퀀스 가져오기
		int gosuMS_seq = gosuVO.getGosuMS_seq();
		System.out.println("고수메인서비스" + gosuMS_seq);
		//고수메인서비스 테이블에서 모든 정보 가져오기
		GosuMainSvcVO gosuMainVO = gosuMainSvcService.selectGosuMS(gosuMS_seq);
		//고수의 메인서비스 소카테고리 시퀀스를 가져온다.
		
		int gosuMainSubSvc_seq = gosuMainVO.getSubSvc_seq();
		System.out.println("gosuMainSubSvc_seq" + gosuMainSubSvc_seq);
		//견적요청서 테이블에 소 카테고리와 비교해 같은 것들을 가져온다
		List<Map<String, Object>> qvo = quoteReqService.receiveQuoteRequest(gosuMainSubSvc_seq);
		System.out.println(qvo.size());
		
		//고수메인서비스 이용해 서비스명 가져오기
		String subSvc_name = quoteReqService.svcName(gosuMS_seq);
		System.out.println("subSvc" + subSvc_name);
		
		//MemberVO member = memberService.reqMember(quoteReq_seq);
//		List<MemberVO> mvo = new ArrayList<MemberVO>();  
//		
//		for(int i = 0; i < qvo.size(); i++) {
//			//위에서 가져온 qvo의 첫번째 인덱스 값을 가져와 member_Seq 값을 가져온다.
//		
//			int member_seq = ((BigDecimal)qvo.get(i).get("MEMBER_SEQ")).intValue();
//			// member_Seq를 이용하여 mem테이블에서 memberVO 로 받아온다.
//			System.out.println(member_seq);
//			mvo.add(memberService.selectOne(member_seq));
//			
//		}
//		
//		for(Map<String, Object> map: qvo) {
//			int member_seq = ((BigDecimal)map.get("MEMBER_SEQ")).intValue();
//			mvo.add(memberService.selectOne(member_seq));
//		}
//		
//		request.setAttribute("mvo", mvo);
		request.setAttribute("svcName", subSvc_name);
		request.setAttribute("qvo", qvo);
		
		//mvo.get(0);
		
		return ViewPath.QUOTE + "receiveRequestQuote.jsp";
	}
	
	@RequestMapping("/quote/receiveQuote")
	public String receiveQuote(HttpServletRequest request) {
		
		int kind = Integer.parseInt(request.getParameter("kind"));
		
		if(kind == 2) {
			int quote_seq = Integer.parseInt(request.getParameter("quote_seq"));
			int d = quoteService.quoteDelete(quote_seq);
		}else if(kind == 3) {
			int quote_seq = Integer.parseInt(request.getParameter("quote_seq"));
			int b = quoteService.updateQuote(quote_seq);
			int gosu_seq = Integer.parseInt(request.getParameter("gosu_seq"));
			int re = gosuService.updateHireCnt(gosu_seq);
			
			
		}
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		List<Map<String, Object>> qvo = quoteService.selectQuote(member_seq);
//		System.out.println(qvo.size());
		String subSvcName[] = new String[qvo.size()];
        String gosu_id ="";
		for(int i=0; i < qvo.size(); i++) {
			// QUTEreq테이블 시퀀스 가져온다
			int quoteReq_seq = ((BigDecimal)qvo.get(i).get("QUOTEREQ_SEQ")).intValue();
            gosu_id = gosuService.gosuId(quoteReq_seq);
			//System.out.println(quoteReq_seq);
			//qutereq테이블에서 subsvc_seq 값 가져온다
			int subSvc_seq = quoteReqService.selectSubSeq(quoteReq_seq);
			//System.out.println(subSvc_seq);
			//subsvc 테이블에서 subsvc_name을 가져온다
			String subSvc = subSvcService.selectSubName(subSvc_seq);
			//System.out.println(subSvc);
			// 그 뒤에 리스트에 넣어준다.
			subSvcName[i] = subSvc;
			
		}
		request.setAttribute("subSvcName", subSvcName);
		request.setAttribute("qvo", qvo);
		request.setAttribute("gosu_id", gosu_id);
		
		return ViewPath.QUOTE + "receiveQuote.jsp";
	}
	
	@RequestMapping("/quote/receiveQuoteDetail")
	public String receiveQuoteDetail(HttpServletRequest request, QuoteReqVO vo, GosuVO gvo, MemberVO mvo) {
		//견적요청서를 받아온다.
		int quote_seq = Integer.parseInt(request.getParameter("quote_seq"));
		int quoteReq_seq = Integer.parseInt(request.getParameter("quoteReq_seq"));
		String options = request.getParameter("options");
		int gosu_seq = Integer.parseInt(request.getParameter("gosu_seq"));
		int price = Integer.parseInt(request.getParameter("price"));
		int qStatus = Integer.parseInt(request.getParameter("qStatus"));
		
		//System.out.println(options);
		//System.out.println(price);
		vo = quoteReqService.showQuoteRequest(quoteReq_seq);
		gvo = gosuService.selectOneGosu(gosu_seq);

		int member_seq = gvo.getMember_seq();
		mvo = memberService.selectOne(member_seq);
		
		request.setAttribute("gvo", gvo);
		request.setAttribute("vo", vo);
		request.setAttribute("mvo", mvo);
		request.setAttribute("price", price);
		request.setAttribute("options", options);
		request.setAttribute("quote_seq", quote_seq);
		request.setAttribute("gosu_seq", gosu_seq);
		request.setAttribute("qStatus", qStatus);
		
		
		return ViewPath.QUOTE + "receiveQuoteDetail.jsp";
	}
	
	
	
	
}

