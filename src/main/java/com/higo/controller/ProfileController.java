package com.higo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.codehaus.jackson.map.ObjectMapper;

import com.higo.gosu.GosuService;
import com.higo.gosu.GosuVO;
import com.higo.member.MemberService;
import com.higo.member.MemberVO;

import common.ViewPath;

@Controller
public class ProfileController {
	
	private MemberService memberService;
	private GosuService gosuService;
	
	public ProfileController(MemberService memberService, GosuService gosuService) {
		this.memberService = memberService;
		this.gosuService = gosuService;
	}
	

	@RequestMapping("/change/gosu")
	public String changGosu() {
		
		return ViewPath.MAIN + "index.jsp";
	}
	
	
	@RequestMapping("/change/client")
	public String changClient() {
		
		return ViewPath.MAIN + "index.jsp";
	}
	
	
	@RequestMapping("/gosu/profile")
	public String profile(MemberVO vo, HttpServletRequest request, GosuVO gv) {
		// 세션에 있는 시퀀스 가져오기
		int member_seq = (int)request.getSession().getAttribute("mlogin");
		int gosu_seq = (int)request.getSession().getAttribute("glogin");
		System.out.println("member_seq : " + member_seq);
		System.out.println("gosu_seq : " + gosu_seq);
		
		vo = memberService.selectOne(member_seq);
		// 해당 고수 데이터 전부 가져오기
		gv = gosuService.selectOneGosu(gosu_seq);
		
		

		// 서비스 범위 가져오기
		int svc_range = gv.getSvc_range();
		System.out.println(svc_range);
		
		// 고용횟수
		int hire = gv.getHire_cnt();
		
		// 한줄소개
		String intro = gv.getIntro();
		
		// 활동지역
		String actaddr = gv.getActAddr();
		System.out.println(actaddr);
		
		
		// review 갯수 가져오기
		int review = gosuService.countReview(gosu_seq);
		// 리뷰 평점 리스트에 전부 담아서 가져오기
		List<Integer> star = gosuService.reviewStar(gosu_seq);
		List<String> major = gosuService.majorSvc();

		int sum = 0;
		float star_avg = gv.getStar_avg();
		for(int su : star) {
			// sum 에 각 리뷰점수를 누적합으로 담아서
			sum += su;
			// 리뷰점수의 갯수로 나누어 평균 점수를 구한다음 result에 담는다.
			star_avg = sum / star.size();
		}
		System.out.println("star_avg : " + star_avg);
		
		// 가져온 서비스 범위를 세팅
		request.setAttribute("svc_range", svc_range);
		// review 갯수와 리뷰 평점을 셋팅하여 profile.jsp로 넘김
		request.setAttribute("review", review);
		request.setAttribute("star_avg", star_avg);
		request.setAttribute("major", major);
		// 처음 프로필 페이지 들어갔을때 띄워줄 고수정보와 멤버 정보들..
		request.setAttribute("vo", vo);
		request.setAttribute("gv", gv);
		request.setAttribute("major", major);
		request.setAttribute("hire", hire);
		request.setAttribute("intro", intro);
		request.setAttribute("actaddr", actaddr);
		
		return ViewPath.PROFILE + "profile.jsp";
	}
	
	
	
	@RequestMapping("/gosu/profile/portfolio")
	public String portfolio() {
		
		return ViewPath.PROFILE + "portfolio.jsp";
	}
	
	
	@RequestMapping(value = "/gosu/intro")
	@ResponseBody
	public String intro(@RequestParam String intro,HttpServletRequest request) {
		int gosu_seq = (int)request.getSession().getAttribute("glogin");
		GosuVO gv = gosuService.selectOneGosu(gosu_seq);
		
		gv.setIntro(intro);
		
		int chk = gosuService.reIntro(gv);
		if(chk != 0) {
			intro = gosuService.returnIntro(gosu_seq);
		}
		
		System.out.println("intro : " + intro);
		
		request.setAttribute("intro", intro);
		request.setAttribute("gv", gv);
		return gv.getIntro();
	}
	
	
	@RequestMapping("/gosu/majorSvc")
	@ResponseBody
	public String majorSvc(GosuVO gv, HttpServletRequest request) {
		int gosu_seq = (int)request.getSession().getAttribute("glogin");
		gv = gosuService.selectOneGosu(gosu_seq);
		List<String> major = gosuService.majorSvc();
		
		request.setAttribute("major", major);
		request.setAttribute("gv", gv);
		return ViewPath.PROFILE + "profile.jsp";
	}
	
	
	@RequestMapping("/gosu/reviewInfo")
	@ResponseBody
	public String reviewInfo(GosuVO gv, HttpServletRequest request) {
		
		int member_seq = (int)request.getSession().getAttribute("mlogin");
		int gosu_seq = (int)request.getSession().getAttribute("glogin");
		
		gv = gosuService.selectOneGosu(member_seq);
		
		int hire = gv.getHire_cnt();
		
		// review 갯수 가져오기
		int review = gosuService.countReview(member_seq);
		// 리뷰 평점 리스트에 전부 담아서 가져오기
		List<Integer> star = gosuService.reviewStar(member_seq);
		
		
		
		int sum = 0;
		double result = 0;
		for(int su : star) {
			// sum 에 각 리뷰점수를 누적합으로 담아서
			sum += su;
			// 리뷰점수의 갯수로 나누어 평균 점수를 구한다음 result에 담는다.
			result = sum / star.size();
		}
		int star_avg = gosuService.starAvg(gosu_seq);
		
		// review 갯수와 리뷰 평점을 셋팅하여 profile.jsp로 넘김
		request.setAttribute("review", review);
		request.setAttribute("result", result);
		request.setAttribute("hire", hire);
		request.setAttribute("star_avg", star_avg);
		request.setAttribute("gv", gv);
		
		return ViewPath.PROFILE + "profile.jsp";
	}
	
	// 서비스 범위 컨트롤러
	@RequestMapping(value="/gosu/localRange")
	@ResponseBody
	public String svcRange(@RequestBody Map<String,Object> map, HttpServletRequest request) {
		
		System.out.println(map.keySet().toString());		
		
		
		int gosu_seq = (int)request.getSession().getAttribute("glogin");
		System.out.println("gosu_seq : " + gosu_seq);
		GosuVO gv = gosuService.selectOneGosu(gosu_seq);
		
		gv.setActAddr((String)map.get("actaddr"));
		
		System.out.println("km :" + map.get("km"));
		System.out.println(map.get("actaddr"));
		System.out.println("svc_range : " + map.get("svc_range"));
		
		if(map.get("svc_range") == null) {
			gv.setSvc_range(Integer.valueOf((String)map.get("svc_range")));
		}else {
			gv.setSvc_range(Integer.valueOf((String)map.get("km")));
		} 
		
		gosuService.svcRange(gv);
		
		int svc_range = gv.getSvc_range();
		

		return "y";
		
	}
	
	// 활동지역
	@RequestMapping(value="/gosu/local")
	@ResponseBody
	public String local(@RequestBody Map<String,Object> map, HttpServletRequest request) {
      
	  System.out.println(map.keySet().toString());      
	  
	  
	  int gosu_seq = (int)request.getSession().getAttribute("glogin");
	  System.out.println("gosu_seq : " + gosu_seq);
	  GosuVO gv = gosuService.selectOneGosu(gosu_seq);
	  
	  gv.setActAddr((String)map.get("actaddr"));
//	  gv.setSvc_range((Integer)map.get("svc_range"));
	  
	  
	  System.out.println("km :" + map.get("km"));
	  System.out.println(map.get("actaddr"));
	  System.out.println("svc_range : " + map.get("svc_range"));
	  
	  
	  gosuService.reActaddr(gv);
	  //gosuService.reActaddr(gv);
	  
	  //int svc_range = gv.getSvc_range();
	  
	  // 기존 고수데이터를 가져와서 표시해주는 컨트롤러와 ajax로 새로운 데이터를 DB에 저장해주는 컨트롤러를 구분한다..?
	
	  return "yy";
      
	}
	
	
	@RequestMapping(value="/gosu/gosuinfo")
	@ResponseBody
	public String userInfo(HttpServletRequest request, @RequestParam String name) {
		
		int gosu_seq = (int)request.getSession().getAttribute("glogin");
		int member_seq = (int)request.getSession().getAttribute("mlogin");
		GosuVO gv = gosuService.selectOneGosu(gosu_seq);
		MemberVO mv = memberService.selectOne(member_seq);

		mv.setName(name);
		
		int su = gosuService.reName(mv);
		if(su != 0) {
			name = gosuService.returnName(member_seq);
		}
		
		System.out.println(name);
		
		request.setAttribute("name", name);
		return mv.getName();
	}
	
	
	@RequestMapping("/gosu/staff")
	@ResponseBody
	public String staff(GosuVO gv, HttpServletRequest request) {
		
		int gosu_seq = (int)request.getSession().getAttribute("glogin");
		gv = gosuService.selectOneGosu(gosu_seq);
		
		int staff_ctn = gv.getStaff_ctn();
		
		request.setAttribute("staff_ctn", staff_ctn);
		
		return ViewPath.PROFILE + "profile.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
