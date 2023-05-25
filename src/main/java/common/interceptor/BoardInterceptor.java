package common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardInterceptor  extends HandlerInterceptorAdapter{

	// 지정한 경로가 시작될 때 먼저 실행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("========  START  ========");
		System.out.println("Request URI : " + request.getRequestURI());
		
		if(request.getSession().getAttribute("login") == null) {
			response.sendRedirect("/higo/login/form");
		}
		
		return super.preHandle(request, response, handler);
	}
	
	
	
	// 지정한 경로가 끝날 때 실행되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("========  END  ========");
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	
	
}
