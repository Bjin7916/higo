package common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter {
	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		System.out.println("==============STRAT========");
//		System.out.println("Request URI :" + request.getRequestURI());
//		
////		if(request.getSession().getAttribute("mlogin") == null) {
////			response.sendRedirect("/higo/login/check");
////		}
//		
//		return super.preHandle(request, response, handler);
//	}
//	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		System.out.println("=======  =END==========");
//		System.out.println("Request URI :" + request.getRequestURI());
//		super.postHandle(request, response, handler, modelAndView);
//	}

}
