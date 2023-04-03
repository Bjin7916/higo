<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="header text-center">
  <div class="container">
    <div class="row justify-content-center"">
      <div class="col-lg-9 mx-auto">
        <h1 class="mb-4"> ${msg }</h1>
      	<c:choose>
		<c:when test="${check }">
        <ul class="list-inline">
          <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }/mypage/main">마이페이지 &nbsp; &nbsp;
							/</a></li>
         
          <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }/change?status=1">고수전환 &nbsp; &nbsp;
							</a></li>
          </c:when>
          <c:otherwise>
          <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }/login/findForm?mode=id">ID찾기 &nbsp; &nbsp;
							/</a></li>
         
          <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }/login/findForm?mode=pw">PW찾기 &nbsp; &nbsp;
							/</a></li>
          <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }/login/loginForm">Login &nbsp; &nbsp;
							</a></li>
        </ul>
          </c:otherwise>
          </c:choose>
      </div>
    </div>
  </div>
</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>






		
		