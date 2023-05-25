package com.higo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.higo.answer.AnswerService;
import com.higo.answer.AnswerVO;
import com.higo.middleSvc.MiddleSvcService;
import com.higo.middleSvc.MiddleSvcVO;
import com.higo.question.QuestionService;
import com.higo.question.QuestionVO;
import com.higo.quoteReq.QuoteReqService;
import com.higo.quoteReq.QuoteReqVO;
import com.higo.subSvc.SubSvcService;
import com.higo.subSvc.SubSvcVO;

import common.Setting;
import common.ViewPath;

@Controller
public class RequestController {

	private MiddleSvcService middleSvcService;
	private SubSvcService subSvcService;
	private QuestionService questionService;
	private AnswerService answerService;
	private QuoteReqService quoteReqService;
	public String req_textTotal = "";

	public RequestController(MiddleSvcService middleSvcService, SubSvcService subSvcService, QuestionService questionService, AnswerService answerService, QuoteReqService quoteReqService) {
		this.middleSvcService = middleSvcService;
		this.subSvcService = subSvcService;
		this.questionService = questionService;
		this.answerService = answerService;
		this.quoteReqService = quoteReqService;

	}

	@RequestMapping("/quote/middleSvc")
	public String middleSvc(HttpServletRequest request) {

		int majorSvc_seq = Integer.parseInt(request.getParameter("majorSvc"));
		System.out.println(majorSvc_seq);
		List<MiddleSvcVO> middleSvcVO = middleSvcService.middleSvcSelect(majorSvc_seq);
		for(int i = 0; i < middleSvcVO.size(); i++) {
			System.out.println(middleSvcVO.get(i));
		}
		List<Map<String, Object>> subSvcAll = subSvcService.subSvcAll();

		List<SubSvcVO> subSvcVO = subSvcService.subSvcSelect(majorSvc_seq);
		String majorSvc	 = quoteReqService.majorSvcVO(majorSvc_seq);

		request.setAttribute("middleSvcVO", middleSvcVO);
		request.setAttribute("subSvcAll", subSvcAll);
		request.setAttribute("majorSvc", majorSvc);


		return ViewPath.REQUEST + "middleSvc.jsp";

	}

	@RequestMapping("/quote/questionForm")
	public String questionForm(HttpServletRequest request,HttpServletResponse response) {

		int subSvc_seq = Integer.parseInt(request.getParameter("subSvc"));
		int count = Integer.parseInt(request.getParameter("count"));
		String req_text = request.getParameter("req_text");


		if(req_text != null) {
			req_textTotal += req_text;
			req_textTotal += "\n";
			req_textTotal += "\n";
		
			System.out.println("종답" + req_textTotal);
		} else {
			req_textTotal += "";
		}

	
		List<QuestionVO> questionVO = null; 
		List<AnswerVO> answerVO = answerService.answerSelect();
		try {
			questionVO = questionService.questionSelect(subSvc_seq);
				
			if(count >= questionVO.size()) {

				request.setAttribute("subSvc_seq", subSvc_seq);
				request.setAttribute("req_textTotal", req_textTotal);
				req_textTotal="";

				return "/quote/quoteRequest";
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
			Setting.alertAndBack(response, "이 서비스는 등록된 고수가 없습니다 ㅜㅜ");
		}


		request.setAttribute("questionVO", questionVO.get(count));

		request.setAttribute("answerVO", answerVO);
		request.setAttribute("count", count+1);
		request.setAttribute("subSvc_seq", subSvc_seq);

		return ViewPath.REQUEST + "questionForm.jsp";
	}

	@RequestMapping("/quote/quoteRequest")
	public String quoteRequest(HttpServletRequest request, SubSvcVO subSvcVO, QuoteReqVO quoteReqVO) {

		int subSvc_seq = (int)request.getAttribute("subSvc_seq");
		String req_text = (String)request.getAttribute("req_textTotal");
		Integer mem_seq = null;
		if((mem_seq =(Integer) request.getSession().getAttribute("mlogin")) == null) {
			mem_seq = 0;
		}
		
		String msg= null;
		int qStatus = 0;

		req_text = req_text.replace("\n", "<br>");
		subSvcVO = subSvcService.subSvcSelectVO(subSvc_seq);

		int middleSvc_seq = subSvcVO.getMiddleSvc_seq();
		int majorSvc_seq = subSvcVO.getMajorSvc_seq();


		quoteReqVO.setSubSvc_seq(subSvc_seq);
		quoteReqVO.setMiddleSvc_seq(middleSvc_seq);
		quoteReqVO.setMajorSvc_seq(majorSvc_seq);
		quoteReqVO.setMember_seq(mem_seq);
		quoteReqVO.setReq_text(req_text);
		quoteReqVO.setQStatus(qStatus);

		System.out.println(subSvc_seq);
		System.out.println(quoteReqVO.getSubSvc_seq());
		System.out.println(quoteReqVO.getMiddleSvc_seq());
		System.out.println(quoteReqVO.getMajorSvc_seq());
		System.out.println(quoteReqVO.getMember_seq());
		System.out.println(req_text);
		System.out.println(quoteReqVO.getQStatus());

		int su = quoteReqService.quoteReqVOInsert(quoteReqVO);

		//		if(su != 0) {
		//			msg = "견적서 삽입 성공";
		//		}else {
		//			msg = "견적서 삽입 실패";	
		//		}

		request.setAttribute("quoteReqVO", quoteReqVO);
		request.setAttribute("msg", msg);
		
		System.out.println("뭐지" + quoteReqVO.getReq_text());


		return ViewPath.REQUEST + "quoteRequestResult.jsp";
	}

	@RequestMapping("/request/quoteRequestD")
	public String quoteRequestD(HttpServletRequest request) {

		// 삭제할 견적요청서 시퀀스
		int quotereq_seq = Integer.parseInt(request.getParameter("quoteReq_seq"));

		System.out.println(quotereq_seq);

		quoteReqService.delectQuoteRequest(quotereq_seq);



		return "/quote/receiveRequestQuote";
	}









	/*
	 * @RequestMapping("/matching/main") public String matching(){ return ViewPath.
	 * }
	 */
}
