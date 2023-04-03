package com.higo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.higo.gosu.GosuService;
import com.higo.gosu.GosuVO;
import com.higo.member.MemberService;
import com.higo.member.MemberVO;
import com.higo.post.PostService;
import com.higo.post.PostVO;

import common.ViewPath;

@Controller
public class MypageController {

	private MemberService memberService;
	private GosuService gosuService;
	private PostService postService;
	
	public MypageController(MemberService memberService, GosuService gosuService, PostService postService) {
		this.gosuService =gosuService;
		this.memberService=memberService;
		this.postService=postService;
	}
	
	@RequestMapping("/mypage/main")
	public String myPage(HttpServletRequest request) {
		Integer mlogin = (Integer) request.getSession().getAttribute("mlogin");
		Integer glogin = (Integer) request.getSession().getAttribute("glogin");
		MemberVO mvo = memberService.selectOne(mlogin);
		GosuVO vo = gosuService.selectOneGosu(glogin);
		
		request.setAttribute("vo", vo);
		request.setAttribute("mvo", mvo);
		
		return ViewPath.MYPAGE + "main.jsp";
	}
	
	@RequestMapping("/mypage/mypost")
	public String myPost(HttpSession session, HttpServletRequest request) {
		Integer mlogin = (Integer) request.getSession().getAttribute("mlogin");
		Integer glogin = (Integer) request.getSession().getAttribute("glogin");
		System.out.println(mlogin);

		List<PostVO> mPList = postService.mPList(mlogin);
		//System.out.println(mPList);
		
		request.setAttribute("mPList", mPList);
		
		return ViewPath.MYPAGE + "mypost.jsp";
	}
	
	
}
