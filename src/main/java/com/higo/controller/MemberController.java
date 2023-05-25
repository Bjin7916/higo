package com.higo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.higo.member.MemberService;
import com.higo.member.MemberVO;

import common.ViewPath;

@Controller
public class MemberController {

	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	//광민
	@RequestMapping("/member/joinForm")
	public String joinForm() {
		return ViewPath.MEMBER + "joinForm.jsp";
	}
	
	@RequestMapping("/member/join")
	public String join(Model model, MemberVO vo) {
		
		int su = memberService.insert(vo);
		
		String url = null;
		String msg = null;
		
		if(su != 0) {
			msg = "회원가입 성공! 메인페이지이동";
			url = "/higo/login/loginForm";
		}else {
			msg = "회원가입 실패 이전페이지로";
			url = "history.back()";
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.MEMBER + "result.jsp";
	}
	//광민
		@RequestMapping(value = "/member/checkId"/*produces = "application/text;charset=utf8"*/ )
		@ResponseBody //데이터 자체를 클라이언트에게 전달하겠다..
		public String checkId(String id) {
			//System.out.println(id);
			
			if(memberService.checkId(id) != null) {
				return "이미 사용중인 ID입니다";
			}else{
				return "사용 가능한 ID입니다";
			}
		}
		
		@RequestMapping(value ="/member/checkEmail")
		@ResponseBody
		public String checkEmail(String email) {
			
			if(memberService.checkEmail(email) != null) {
				return "이미 사용중인 Email입니다";
			}else {
				return "사용 가능한 Email입니다";
			}
		}
		
		@RequestMapping(value ="/member/checkTel")
		@ResponseBody
		public String checkTel(String tel) {
			
			if(memberService.checkTel(tel) != null) {
				return "이미 등록된 번호입니다";
			}else {
				return "사용 가능한 번호입니다";
			}
		}
		
	@RequestMapping("/member/mypage")
	public String myPage(HttpServletRequest request) {
		
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		if(member_seq == null) {
			return "redirect:/login/loginForm";
		}
		
		MemberVO vo = memberService.selectOne(member_seq);
		
		request.setAttribute("vo", vo);
		
		return ViewPath.MEMBER + "myPage.jsp";
	}
	
	@RequestMapping("/member/updateform")
	public String updateForm(HttpServletRequest request) {
		
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		if(member_seq == null) {
			return "redirect:/login/loginForm";
		}
		
		MemberVO vo = memberService.selectOne(member_seq);
		
		request.setAttribute("vo", vo);
		
		return ViewPath.MEMBER + "updateForm.jsp";
	}
	
	@RequestMapping("/member/deleteform")
	public String deleteForm(HttpServletRequest request) {
		
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		if(member_seq == null) {
			return "redirect:/login/loginForm";
		}
		
		String id = memberService.getId(member_seq);
		
		request.setAttribute("id", id);
		
		return ViewPath.MEMBER + "deleteForm.jsp";
	}
	
	@RequestMapping("/member/update")
	public String update(HttpServletRequest request,MemberVO vo) {
		
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		if(member_seq == null) {
			return "redirect:/login/loginForm";
		}
		
		vo.setMember_seq(member_seq);
		
		int check = memberService.update(vo);
		
		
		String msg = null;
		String url = null;
		
		if(check != 0){
			msg = "수정완료!!MyPage로...";
			url = "/higo/member/mypage";
		}else{
			msg = "수정실패!!이전페이지로...";
			url = "/higo/member/updateform";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		
		
		return ViewPath.MEMBER + "result.jsp";
	}
	
	@RequestMapping("/member/delete")
	public String delete(HttpServletRequest request,String password,HttpServletResponse response) {
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		
		if(member_seq == null) {
			return "redirect:/login/loginForm";
		}
		
		MemberVO vo = memberService.selectOne(member_seq);
		
		String msg = "";
		String url = "";
		
		if(!vo.getPassword().equals(password)){
			msg = "비밀번호가 틀렸습니다.!!이전페이지로....";
			url = "/higo/member/deleteform";
		}else{
			int check = memberService.delete(member_seq);
			if(check != 0){
				
				//쿠키파일 삭제.
				Cookie[] cks = request.getCookies();
				if(cks != null){
					for(Cookie ck : cks){
						if(ck.getName().equals("ckid")){
							if(ck.getValue().equals(vo.getId())){
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
		
		return ViewPath.MEMBER + "result.jsp";
	}
	
	
}

