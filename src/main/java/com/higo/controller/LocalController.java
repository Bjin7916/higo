package com.higo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.higo.local.LocalService;
import com.higo.member.MemberService;
import com.higo.metro.MetroVO;

import common.Setting;
import common.ViewPath;
@Controller
public class LocalController {

	private MemberService memberService;
	private LocalService localService;
	
	public LocalController(LocalService localService, MemberService memberService) {
		this.localService = localService;
		this.memberService = memberService;
	}
	
	@RequestMapping("/metro")
	public String metro(HttpServletRequest request, int metro_seq, String metro_name) {
		//화면전환 status 세션 처리 
		Setting.status(request);
		
		MetroVO mvo = new MetroVO();
		mvo.setMetro_name(metro_name);
		mvo.setMetro_seq(metro_seq);
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("metro_name", metro_name);
		
		List<Map<String,Object>> llvo = localService.localList(metro_seq);																		
		
		List<Map<String,Object>> lvo = localService.localMainSvc(map);
		
		
		
		request.setAttribute("lvo", lvo);
		request.setAttribute("llvo", llvo);
		
		return ViewPath.SEARCHING + "metro.jsp";
	}
}
