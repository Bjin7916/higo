<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div class="header container text-center">
	<div class="container">
	    <div class="row">
	    	<div class="col-lg-9 mx-auto">
		        <h1 class="mb-4"> ${majorSvc }</h1>
		        <ul class="list-inline">
			        <li class="list-inline-item"><a class="text-default"
								href="${ pageContext.request.contextPath }">홈 &nbsp; &nbsp;
									/</a></li>
			        <li class="list-inline-item text-primary">고수매칭</li>
		        </ul>
	    	</div>
	    </div>
	</div>

	<div class="container text-left overflow-hidden">
		<div class="overflow-hidden  row row-cols-3">
			<c:forEach var="middle" items="${middleSvcVO }" varStatus="mStatus">	
				<c:set var="count" value="${mStatus.count }"/>
				<!-- 중 카테고리 테이블 -->
					<div class="text-left mt-5 col-3 overflow-hidden"><h3><strong>${middle.get("MIDDLESVC_NAME") }</strong></h3></div>	
						<%-- <td><strong>${middle.get("MIDDLESVC_SEQ") }</strong></td>	
						<td>${middle.count}</td> --%>
						<!-- 소 카테고리 -->
					<c:forEach var="sub" items="${subSvcAll }" varStatus="statuse">
						<c:if test="${sub.get('MIDDLESVC_SEQ') == middle.get('MIDDLESVC_SEQ') }">			
								<div class="text-left col-3"><a href="/higo/quote/questionForm?subSvc=${sub.get('SUBSVC_SEQ') }&count=0">${sub.get('SUBSVC_NAME') }</a></div>
								<%-- <td>${sub.get('SUBSVC_SEQ') }</td> --%>
						</c:if>
					</c:forEach>
			</c:forEach>
		</div>
	 </div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>