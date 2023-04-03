package common;

import javax.servlet.http.HttpServletRequest;

public class ViewPath {

	public static final String MAIN = "/WEB-INF/views/";
	public static final String MEMBER = "/WEB-INF/views/member/";
	public static final String LOGIN = "/WEB-INF/views/login/";
	public static final String GOSU = "/WEB-INF/views/gosu/";
	public static final String PROFILE = "/WEB-INF/views/gosu/profile/";
	public static final String MYPAGE = "/WEB-INF/views/mypage/";
	public static final String REQUEST = "/WEB-INF/views/request/";
	public static final String COMMUNITY ="/WEB-INF/views/community/";
	public static final String POST = "/WEB-INF/views/community/post/";
	public static final String CASH ="/WEB-INF/views/mypage/cash/";
	public static final String QUOTE = "/WEB-INF/views/quote/";
	public static final String MATCHING="/WEB-INF/views/matching/";
	public static final String SEARCHING ="/WEB-INF/views/searching/";
	


	//url 
	public static final String MIDDLESVC = "/higo/quote/middleSvc";
	
	public static int loginCheck(HttpServletRequest request, int mlogin, int glogin) {
		try {
			mlogin = (int) request.getSession().getAttribute("mlogin");
		}catch(NullPointerException e) {
			mlogin = 0;
			System.out.println("로그인부탁");
		}
		return mlogin;
	}
}
