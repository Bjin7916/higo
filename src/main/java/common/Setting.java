package common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.higo.gosu.GosuService;
import com.higo.gosu.GosuVO;
import com.higo.member.MemberService;
import com.higo.member.MemberVO;

public class Setting {

		//견적서 금액 세팅
		public static final int QUOTEPRICE = 1000;
		
		
		//login 세션 처리 static method
		public static void status(HttpServletRequest request) {
			Integer status =(Integer)request.getSession().getAttribute("status");
		
			//MemberVO vo = (MemberVO) request.getAttribute("vo");
			//GosuVO gvo = (GosuVO) request.getAttribute("gvo");
//			GosuVO gvo = null;
//			MemberVO vo = null;
//			try {
//				vo = memberService.selectOne(mlogin);
//				gvo = gosuService.selectOneGosu(glogin);
//				if(gvo != null) {
//					request.setAttribute("gvo", gvo);
//				}
//				if(vo != null) {
//					request.setAttribute("vo", vo);
//				}
//			}catch(NullPointerException e) {
//				e.printStackTrace();
//			}
		}
		// alert 띄우고 이전 페이지로 가기
		public static void alertAndBack(HttpServletResponse response, String msg) {
		    try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('"+msg+"');history.go(-1);</script>");
		        w.flush();
		        w.close();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
		// alert 띄우고 원하는 페이지로 이동
		public static void alertAndGo(HttpServletResponse response, String msg, String url) {
		    try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('"+msg+"');location.href='"+url+"';</script>");
		        w.flush();
		        w.close();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
		
		public static void goToLogin(HttpServletResponse response) {
			try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('로그인 후 이용해주세요!');location.href='/higo/login/loginForm';</script>");
		        w.flush();
		        w.close();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
}
