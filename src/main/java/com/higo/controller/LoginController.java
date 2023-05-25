package com.higo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.higo.gosu.GosuService;
import com.higo.gosu.GosuVO;
import com.higo.member.MemberService;
import com.higo.member.MemberVO;

import common.Setting;
import common.ViewPath;
@Controller
public class LoginController {

	private MemberService memberService;
	private GosuService gosuService;


	public LoginController(MemberService memberService, GosuService gosuService) {
		this.memberService = memberService;
		this.gosuService = gosuService;
	}

	@RequestMapping("/login/loginForm")
	public String loginForm(HttpServletRequest request) {

		String id = request.getParameter("id");

		boolean check = false;
		//쿠키
		if(id == null){

			Cookie[] cks = request.getCookies();

			if(cks != null){
				for(Cookie ck : cks){
					if(ck.getName().equals("ckid")){
						id = ck.getValue();
						check = true;
						break;
					}
				}
			}

			if(id == null){
				id = "";
			}
		}

		request.setAttribute("id", id);
		request.setAttribute("check", check);

		return ViewPath.LOGIN + "form.jsp";
	}

	@RequestMapping("/login/check")
	public String loginCheck(MemberVO vo,HttpServletRequest request,HttpServletResponse response) {
		
		
		int member_seq = memberService.checkLogin(vo);	
		int gosu_seq = gosuService.checkLogin(member_seq);
	
		try {
			
			vo = memberService.selectOne(member_seq);
			request.setAttribute("vo", vo);
//			
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
//		int member_seq = memberService.checkLogin(vo);	
//		int gosu_seq = gosuService.checkLogin(member_seq);
//		int member_div = 0;

		String msg = null;
		boolean check = false;
		
		//		if(gosu_seq != 0) {
		//			msg = vo.getId() + "님이 로그인하셧습니다";
		//			check = 
		//			request.getSession().setAttribute("glogin", gosu_seq);
		//		}
		
//		if(gosu_seq != 0) {
//			request.getSession().setAttribute("glogin", gosu_seq);
//		}
		
		if(vo.getMember_seq() != 0){
			msg = vo.getId() + "님이 로그인하셨습니다.";
			check = true;
			int status = 0;
			int member_div = vo.getMember_div();
			//session에 로그인 값 저장...
			request.getSession().setAttribute("mlogin", member_seq); 
			request.getSession().setAttribute("name", vo.getName());
			request.getSession().setAttribute("member_div", member_div);
			request.getSession().setAttribute("status", status);
			request.getSession().setAttribute("login", vo);
			// 로그인 처리...
			//고수로 가입이 되어있으면 세션에 고수시퀀스 같이 저장. 둘다가입되어있는 사람으로 구분.
			if(gosu_seq != 0) {
				request.getSession().setAttribute("glogin", gosu_seq);
				System.out.println("1" + gosu_seq);
				GosuVO login = gosuService.selectOne(member_seq);
				request.getSession().setAttribute("login", login);
				
				System.out.println(login.getName());
			}
			//회원구분용 세션값 어찌할지 .


			//아이디 기억하기 체크 유무
			String ckid = request.getParameter("ckid");

			Cookie ck = null;

			//쿠키파일 읽어 오기...
			Cookie[] cks = request.getCookies();

			//기존 쿠키파일 검색
			if(cks != null){
				for(Cookie c : cks){
					if(c.getName().equals("ckid")){
						ck = c;
						break;
					}
				}
			}

			if(ckid != null){ //체크 되어 있을때
				if(ck == null){ // 쿠키파일 없을때
					ck = new Cookie("ckid",vo.getId());

					//root로 경로 설정
					ck.setPath("/");

					//유효시간 설정
					ck.setMaxAge(60*60*24);

					//클라이언트에게 쿠키파일 생성
					response.addCookie(ck);
				}else{ //있을때
					if(!ck.getValue().equals(vo.getId())){
						ck.setValue(vo.getId());
						response.addCookie(ck);
					}
				}
			}else{ // 체크 안되어 있을때
				if(ck != null){
					if(ck.getValue().equals(vo.getId())){
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
				}
			}

		}else{
			msg = "아이디 혹은 비밀번호가 잘못되었습니다.";	
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("check", check);


		return ViewPath.LOGIN + "result.jsp";
	}

	@RequestMapping("/login/logout")
	public String logout(Model model, HttpSession session) {

		session.invalidate();

		model.addAttribute("msg", "로그아웃되었습니다.");
		model.addAttribute("url", "/higo/");

		return ViewPath.LOGIN + "logout.jsp";
	}

	@RequestMapping("/login/findForm")
	public String findForm() {
		return ViewPath.LOGIN + "findForm.jsp";
	}

	@RequestMapping("/login/find")
	public String find(Model model,MemberVO vo,String mode, HttpServletRequest request) {
		Setting.status(request);
		String find = null;
		if(vo.getId() == null){
			find = memberService.findId(vo);
		}else{
			find = memberService.findPw(vo);	
		}


		boolean check = false;
		if(find != null){
			check = true;
			String re = "";
			for(int i = 0; i < find.length(); i++){
				if(i % 2 == 0){
					re += find.charAt(i);
				}else{
					re += "*";
				}
			}

			if(mode.equals("id")){
				model.addAttribute("id", re);
			}else{
				model.addAttribute("password", re);	
			}
		}

		model.addAttribute("check", check);

		return ViewPath.LOGIN + "findResult.jsp";
	}
	
	@RequestMapping("/change")
	public String change(HttpServletRequest request, HttpServletResponse response) {
		int status = Integer.parseInt(request.getParameter("status"));
		int member_seq = (int) request.getSession().getAttribute("mlogin");
		
		GosuVO vo = gosuService.selectOne(member_seq);
		
		String msg = "";
		String url = "";
		if(vo == null) {
			 msg = "고수 등록이 되어 있지 않습니다. 고수가입 페이지로 이동합니다";
			 url = "/higo/gosu/joinForm";
			Setting.alertAndGo(response, msg, url);
		}else {
			request.getSession().setAttribute("status", status);
		}
		
		
		return "redirect:/";
	}
}
























