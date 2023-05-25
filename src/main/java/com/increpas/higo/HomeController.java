package com.increpas.higo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higo.gosu.GosuService;
import com.higo.gosu.GosuVO;
import com.higo.local.LocalService;
import com.higo.majorSvc.MajorSvcVO;
import com.higo.member.MemberService;
import com.higo.member.MemberVO;
import com.higo.metro.MetroVO;
import com.higo.quoteReq.QuoteReqService;

import common.ViewPath;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private GosuService gosuService;
	private LocalService localService;
	private QuoteReqService quoteReqService;
	private GosuService gosuService;
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public HomeController(LocalService localService, QuoteReqService quoteReqService, GosuService gosuService, MemberService memberService) {
		this.localService =localService;
		this.gosuService = gosuService;
		this.quoteReqService=quoteReqService;
		this.memberService = memberService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {
		//홈에서 세션값 처리해주기 
		Integer status =(Integer)request.getSession().getAttribute("status");
		Integer mlogin = (Integer) request.getSession().getAttribute("mlogin");
		Integer glogin = (Integer) request.getSession().getAttribute("glogin");
		System.out.println(request.getSession().getAttribute("login"));
		//header이름 처리 
		if(glogin !=null) {
			GosuVO gosu = gosuService.selectOne(mlogin);
			request.getSession().setAttribute("login", gosu);
		}else if(mlogin != null) {
			MemberVO m = memberService.selectOne(mlogin);
			request.getSession().setAttribute("login", m);
		}
		
		
		List<Map<String,MajorSvcVO>> mlist = quoteReqService.majorSvcSelect();
		request.setAttribute("mlist", mlist);
		
		
		// 지역 카테고리 
		List<Map<String, MetroVO>> lvo = localService.metroList();
		System.out.println(lvo.get(0));
		request.setAttribute("lvo", lvo);
	
		
		return ViewPath.MAIN + "index.jsp";
	}
	
}
