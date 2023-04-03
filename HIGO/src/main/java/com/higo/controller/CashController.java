package com.higo.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.higo.cash.CashService;
import com.higo.cash.CashVO;
import com.higo.gosu.GosuService;
import com.higo.gosu.GosuVO;

import common.Setting;
import common.ViewPath;
@Controller
public class CashController {

	private CashService cashService;
	private GosuService gosuService;


	public CashController(CashService cashService) {
		this.cashService = cashService;
	}

	public CashController(GosuService gosuService) {
		this.gosuService = gosuService;
	}

	public CashController(CashService cashService, GosuService gosuService) {
		this.gosuService = gosuService;
		this.cashService = cashService;

	}

	@RequestMapping("/mypage/cash/store")
	public String storePage() {
		return ViewPath.CASH + "store.jsp";
	}


	@RequestMapping("/cash/pay")
	public void charge(HttpServletRequest request, CashVO vo,HttpServletResponse response) {
		//int gosu_seq = 2;
		Integer glogin = (Integer)request.getSession().getAttribute("glogin");

		int cashKind_seq =Integer.parseInt(request.getParameter("cashKind_seq"));

		//충전금액 가져오기
		int charge_cash = cashService.getCash(cashKind_seq);
		int bonus_cash = (int)(charge_cash * 0.05);
		vo.setCharge_cash(charge_cash);
		vo.setBonus_cash(bonus_cash);
		vo.setGosu_seq(glogin);

		// cash 테이블 insert (한 회차 충전)
		int ex = cashService.charge(vo);

		//고수 충전 전 보유캐시가져오기
		GosuVO ref = gosuService.selectOneGosu(glogin);

		//고수 기존 캐시 + 충전캐시 
		int cash = ref.getCash() + vo.getCharge_cash();
		bonus_cash = ref.getBonus_cash() + vo.getBonus_cash();

		//고수가 충전 후 보유하는 캐시 수정
		ref.setCash(cash);
		ref.setBonus_cash(bonus_cash);
		int su = cashService.setCash(ref);


//		DecimalFormat fm = new DecimalFormat("#,###.##");
//		String bc = fm.format(ref.getCash());
//		String c = fm.format(ref.getBonus_cash());
//		System.out.println(bc);
//		System.out.println(c);

		if(su != 0) {
			Setting.alertAndGo(response, charge_cash + "충전완료 충전내역 페이지로 갑니다", "/higo/mypage/cash/chargeList");
		}else {
			Setting.alertAndBack(response,  "결제오류 발생, 이전페이지로 돌아갑니다");
		}

	}

	@RequestMapping("/mypage/cash/chargeList")
	public String chargeList(HttpServletRequest request) {
		Integer glogin = (Integer) request.getSession().getAttribute("glogin");

		GosuVO vo = gosuService.selectOneGosu(glogin);



		DecimalFormat fm = new DecimalFormat("#,###.##");
		String bc = fm.format(vo.getCash());
		String c = fm.format(vo.getBonus_cash());
		String tc = fm.format(vo.getCash()+vo.getBonus_cash());

		List<Map<String, Object>> cvo = cashService.chargeList(glogin);

		request.setAttribute("bc", bc);
		request.setAttribute("c", c);
		request.setAttribute("tc", tc);
		request.setAttribute("cvo", cvo);
		return ViewPath.CASH + "chargeList.jsp";

	}

//	@RequestMapping("/quote/quotes")
//	public String useCash(HttpServletRequest request) {
//		
//		Integer glogin = (Integer) request.getSession().getAttribute("glogin");
//		int qPrice = Setting.QUOTEPRICE;
//		//CashVO vo = (CashVO) cashService.chargeList(glogin);
//		// 현재 고수가 가지고있는 캐시 , 보너스캐시
//		GosuVO vo = gosuService.myCash(glogin);
//		int cash = vo.getCash();
//		int bonus = vo.getBonus_cash();
//		int total = cash+ bonus;
//		String msg ="" ;
//		String url ="" ;
//
//		// 순차적으로 캐시 차감 위해 최근에 받은 보너스 불러오기
//		List<Map<String,Object>> cvo = cashService.chargeList(glogin);
//		if(total >= qPrice ) {
//			if(cash >= qPrice) {
//				cash -= qPrice;
//			}else{
					// total 캐시가 견적서보다 많으나, 	
					// 본캐시가견적서보다 적을때 본캐시 먼저 사용후, 보너스캐시 차감
//				if(total >= qPrice) {
//					bonus -= (qPrice-cash);
//					cash = 0;
//				}else {
//					msg = " 캐시 부족 , 견적서보내기 실패";
//				}
//			}
//			vo.setCash(cash);
//			vo.setBonus_cash(bonus);
//		}
//
//
//
//		return ViewPath.QUOTE + "";
//	}



}
