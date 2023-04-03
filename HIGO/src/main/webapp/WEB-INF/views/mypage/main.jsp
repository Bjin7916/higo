<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div class="header text-center">
  <div class="container">
    <div class="row">
      <div class="col-lg-9 mx-auto">
        <h1 class="mb-4"> 마이페이지</h1>
        <ul class="list-inline">
         <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }">홈 &nbsp; &nbsp;
							/</a></li>
          <li class="list-inline-item text-primary">마이페이지</li>
        </ul>
      </div>
    </div>
  </div>
</div>
<div class="mypage">
	<h1>마이페이지</h1>
	<a class="mypageName" href="${ pageContext.request.contextPath}/gosu/mypage">
	<img name="profile" width="150" src="${ pageContext.request.contextPath }/resources/images/coffee.jpg">
	<h2>${mvo.name}고수님</h2>
	<h6>${mvo.email }</h6>
	<h5>계정설정</h5>
	</a>
	
	<h3>숨고캐시</h3>
	<a href="${ pageContext.request.contextPath}/mypage/cash/store">스토어</a>
	<h5><fmt:formatNumber value="${vo.cash }" pattern="#,###"/>캐시</h5>
	<a href="${ pageContext.request.contextPath}/mypage/cash/chargeList">충전/사용내역</a>
	<h3>커뮤니티</h3>
	<a href="${ pageContext.request.contextPath}/mypage/mypost">숨고생활 작성글/댓글</a>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>