package com.higo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.higo.community.CommunityService;
import com.higo.community.CommunityVO;
import com.higo.member.MemberService;

import common.Paging;
import common.ViewPath;

@Controller
public class CommunityController {
	
	private CommunityService communityService;
	
	private MemberService memberService;
	
	@Autowired
	private ServletContext application;
	
	public CommunityController(CommunityService communityService, MemberService memberService) {
		this.communityService = communityService;
		this.memberService = memberService;
	}
	
	@RequestMapping("/community/list")
	public String list(Model model,Integer page,String type,String word,HttpSession session) {
		
		session.setAttribute("login", memberService.selectOne(3).getMember_seq());
		
		//type이 빈 문자열이면 null값으로 바꿔치기 하자...
		//System.out.println(type);
		
		type = "".equals(type) ? null : type;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("type", type);
		map.put("word", word);
		
		
		if(page == null) {
			page = 1;
		}
		
		int boardCount = communityService.getTotal(map);
		
		Paging paging = new Paging(page, boardCount);
		
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());
		
		List<CommunityVO> list = communityService.selectList(map);
		
		
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		
		
		return ViewPath.COMMUNITY + "list.jsp";
	}

}
