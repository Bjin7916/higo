package com.higo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.higo.gosu.GosuService;
import com.higo.gosu.GosuVO;
import com.higo.majorSvc.MajorSvcService;
import com.higo.majorSvc.MajorSvcVO;
import com.higo.member.MemberService;
import com.higo.member.MemberVO;
import com.higo.middleSvc.MiddleSvcService;
import com.higo.subSvc.SubSvcService;

import common.Setting;
import common.ViewPath;

@Controller
public class GosuController {

	private GosuService gosuService;
	private MemberService memberService;
	private MajorSvcService majorSvcService;
	private MiddleSvcService middleSvcService;
	private SubSvcService subSvcService;
	
	public GosuController(GosuService gosuService,MemberService memberService, MajorSvcService majorSvcService,MiddleSvcService middleSvcService,SubSvcService subSvcService) {
		this.gosuService = gosuService;
		this.memberService = memberService;
		this.majorSvcService = majorSvcService;
		this.middleSvcService = middleSvcService;
		this.subSvcService = subSvcService;
	}
	
	@RequestMapping("/gosu/joinForm")
	public String joinForm(HttpServletRequest request) {
		Setting.status(request);
		return ViewPath.GOSU + "gosujoinForm.jsp";
	}
	
	@RequestMapping("/gosu/join")
	public String join(Model model, GosuVO vo, HttpServletRequest request) {
		
		String url = null;
		String msg = null;
		
		if(request.getSession().getAttribute("mlogin") != null) {
			
			int change = gosuService.insertGosu(vo);
			
			if(change != 0) {
				msg = "고수회원가입 성공! 메인페이지로이동";
				url = "/higo/";
			} else {
				msg = "회원가입실패 이전페이지로";
				url = "history.back()";
			}
		} else {
			
			int su = gosuService.insert(vo);
			
			if(su != 0) { 
				msg = "고수회원가입 성공! 메인페이지로이동"; url = "/higo/";
			  
			}else {
				msg = "회원가입실패 이전페이지로";
				url = "history.back()";
		}
		
			 
			 
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.GOSU +"result.jsp";
	}
	
	@RequestMapping("/gosu/mypage")
	public String myPage(HttpServletRequest request) {
		
		int gosu_seq = (int)request.getSession().getAttribute("glogin");
		int member_seq = (int)request.getSession().getAttribute("mlogin");
		if(gosu_seq == 0) {
			return "redirect:/login/loginForm";
		}
		
		GosuVO vo = gosuService.selectOneGosu(gosu_seq);
		MemberVO mvo = memberService.selectOne(member_seq);
		
		request.setAttribute("vo", vo);
		request.setAttribute("mvo", mvo);
		return ViewPath.GOSU + "myPage.jsp";
	}
	
	@RequestMapping("/gosu/updateform")
	public String updateForm(HttpServletRequest request) {
		
		Integer gosu_seq = (Integer)request.getSession().getAttribute("glogin");
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		if(gosu_seq == null) {
			return "redirect:/login/loginForm";
		}
		
		GosuVO vo = gosuService.selectOneGosu(gosu_seq);
		MemberVO mvo = memberService.selectOne(member_seq);
		
		request.setAttribute("vo", vo);
		request.setAttribute("mvo", mvo);
		
		return ViewPath.GOSU + "updateForm.jsp";
	}
	

	
	@RequestMapping("/gosu/update")
	public String update(HttpServletRequest request,GosuVO vo) {
		
		Integer gosu_seq = (Integer)request.getSession().getAttribute("glogin");
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		if(gosu_seq == null) {
			return "redirect:/login/loginForm";
		}
		
		vo.setMember_seq(member_seq);
		
		int check = gosuService.update(vo);
		
		
		String msg = null;
		String url = null;
		
		if(check != 0){
			msg = "수정완료!!MyPage로...";
			url = "/higo/mypage/mypage";
		}else{
			msg = "수정실패!!이전페이지로...";
			url = "/higo/member/updateform";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		
		
		return ViewPath.GOSU + "result.jsp";
	}
	@RequestMapping("/gosu/deleteform")
	public String deleteForm(HttpServletRequest request) {
		
		Integer gosu_seq = (Integer)request.getSession().getAttribute("glogin");
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		if(gosu_seq == null) {
			return "redirect:/login/loginForm";
		}
		
		String id = memberService.getId(member_seq);
		
		request.setAttribute("id", id);
		
		return ViewPath.MEMBER + "deleteForm.jsp";
	}
	@RequestMapping("/gosu/delete")
	public String delete(HttpServletRequest request,String password,HttpServletResponse response) {
		
		Integer gosu_seq = (Integer)request.getSession().getAttribute("glogin");
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		
		if(gosu_seq == null) {
			return "redirect:/login/loginForm";
		}
		
		GosuVO vo = gosuService.selectOneGosu(gosu_seq);
		MemberVO mvo = memberService.selectOne(member_seq);
		
		String msg = "";
		String url = "";
		
		if(!mvo.getPassword().equals(password)){
			msg = "비밀번호가 틀렸습니다.!!이전페이지로....";
			url = "/higo/member/deleteform";
		}else{
			int check = gosuService.delete(gosu_seq);
			memberService.delete(member_seq);
			if(check != 0){
				//쿠키파일 삭제.
				Cookie[] cks = request.getCookies();
				if(cks != null){
					for(Cookie ck : cks){
						if(ck.getName().equals("ckid")){
							if(ck.getValue().equals(mvo.getId())){
								ck.setMaxAge(0);
								ck.setPath("/");
								response.addCookie(ck);
								break;
							}
						}
					}
				}
			
				request.getSession().invalidate();
				msg = "탈퇴성공!!!메인페이지로...";
				url = "/higo/";
				
				
			}else{
				msg = "탈퇴실패!!잠시후에 다시 시도하십시오..이전페이지로....";
				url = "/higo/member/deleteform";
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return ViewPath.GOSU + "result.jsp";
	}	

	@RequestMapping("/gosu/searching")
	public String searching(HttpServletRequest request) {
		
		int kind = Integer.parseInt(request.getParameter("kind"));
		
		
		if(kind == 1) {
			List<Map<String, Object>> majorSvc = null;
			try {
				majorSvc = majorSvcService.major();
				System.out.println(majorSvc.get(0));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("majorSvc", majorSvc);
			request.setAttribute("kind", "1");
			return ViewPath.SEARCHING + "searching.jsp";
		}else if(kind == 2) {
			int majorSvc_seq = Integer.parseInt(request.getParameter("majorSvc"));
			List<Map<String, Object>> middleSvc = middleSvcService.middle(majorSvc_seq);
			request.setAttribute("middleSvc", middleSvc);
			request.setAttribute("kind", "2");
			return ViewPath.SEARCHING + "searching.jsp";
		}else if(kind == 3) {
			int middleSvc_seq = Integer.parseInt(request.getParameter("middleSvc"));
			List<Map<String, Object>> subSvc = subSvcService.sub(middleSvc_seq);
			request.setAttribute("subSvc", subSvc);
			request.setAttribute("kind", "3");
			return ViewPath.SEARCHING + "searching.jsp";
		}
		
		
		
		return ViewPath.SEARCHING + "searching.jsp";
	}
	
	@RequestMapping("/gosu/searchingMain")
	public String searchingMain(HttpServletRequest request) {
		
		int subSvc_seq = Integer.parseInt(request.getParameter("subSvc"));
		System.out.println(subSvc_seq);
		List<Map<String, Object>> gvo = gosuService.gosuAll(subSvc_seq);
		
		int member_seq[] = null;
		try {
			member_seq = new int[gvo.size()];
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<String> memName = new ArrayList<String>();
		
		if(gvo != null) {
			
			for(int i = 0; i < gvo.size(); i++) {
				member_seq[i] = ((BigDecimal)gvo.get(i).get("MEMBER_SEQ")).intValue();
			}
			System.out.println("위");
			for(int j = 0; j < member_seq.length; j++) {
				memName.add(memberService.selectMemName(member_seq[j]));
			}
			System.out.println("위");
			System.out.println(gvo.size());
		}
		

		request.setAttribute("memName", memName);
		request.setAttribute("gvo", gvo);
		
		return ViewPath.SEARCHING + "searchingMain.jsp";
	}
	
	
	/*
	 * @RequestMapping("/gosu/allService") public List<Map<String, Object>>
	 * allService(MajorSvcVO msv, HttpServletRequest request) {
	 * 
	 * 
	 * 
	 * 
	 * return null; }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
